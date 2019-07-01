package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.ResponseAPI;
import cn.itsource.excel.DepartureExcel;
import cn.itsource.excel.RewardPunishExcel;
import cn.itsource.model.Departure;
import cn.itsource.model.Emp;
import cn.itsource.model.RewardPunish;
import cn.itsource.service.DepartureService;
import cn.itsource.service.DepartureService;
import cn.itsource.service.EmpService;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.PageTable;
import cn.itsource.utils.WebConstant;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.idn.Punycode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/departureController")
public class DepartureController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    protected ResponseAPI responseAPI;
    @Autowired
    private EmpService empService;

    @Autowired
    private DepartureService departureService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        return "departure/list";
    }



    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Departure departure) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
        if (departure.getId() != null) {
            departure.setLogictodelete(WebConstant.DELETECODE);
            departureService.updateDelete(departure);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }




    @RequestMapping("/deletes")
    @ResponseBody
    public String deletes(String ids) {
        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "批量删除失败");
        if (!StringUtils.isEmpty(ids)) {
            String[] idss = ids.split(",");
            for (int i = 0; i < idss.length; i++) {

                Departure departure = departureService.queryById(Integer.valueOf(idss[i]));
                departure.setLogictodelete(WebConstant.DELETECODE);
                departureService.updateDelete(departure);
            }

            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("批量删除成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }

    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Departure> list = departureService.queryAllList();
        List<DepartureExcel> listExcel = new ArrayList<DepartureExcel>();
        for (Departure departure : list) {
            DepartureExcel departureExcel = new DepartureExcel();
            BeanUtils.copyProperties(departure, departureExcel);
            Emp emp = new Emp();
            emp.setId(departureExcel.getEmpId());
            Emp emp1 = empService.queryByParam(emp);
            if (emp1!=null&&emp1.getName()!=null){
                departureExcel.setEmpName(emp1.getName());
            }else {
                departureExcel.setEmpName("该用户名不存在");
            }
            listExcel.add(departureExcel);
        }
        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, DepartureExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "用户信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @RequestMapping("/getName")
    @ResponseBody
    public Map getEmp(Integer id) {
        Map<String, Object> map = new HashMap<>();
        if (id != null) {
            Emp emp = empService.queryById(id);
            if (emp != null) {
                map.put("name", emp.getName());
                map.put("msg", "success");
            } else {
                map.put("name", "该用户不存在");
            }
        }
        return map;
    }
    //高级查询

    /***
     *      自定义查询queryDate  不能显示出来enpId
     *      只能查询出所有的对象，然后比较日期的大小，筛选
     */
    @RequestMapping("/queryDate")
    @ResponseBody
    public Map queryDate(String start, String end) {

        List<Departure> list = new ArrayList<>();
        List<Departure> departures = departureService.queryAllList();

        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTime = sdf.parse(start);
            Date endTime = sdf.parse(end);
            for (Departure departure : departures) {
                Date departuretime = departure.getDeparturetime();
                boolean equals = departuretime.equals(startTime);
                boolean before = departuretime.before(endTime);
                boolean after = departuretime.after(startTime);
                if (equals && before && after) {
                    list.add(departure);
                }
            }
            map.put("json", list);
            map.put("msg", "success");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.err.println(map);
        return map;
    }
    @RequestMapping("/ajaxList")
    @ResponseBody
    public String ajaxList(Integer page, Integer limit, Departure departure) {
        PageTable<List<Departure>> pageTable = new PageTable<List<Departure>>();
        departure.setLogictodelete(WebConstant.NODELETECODE);
        PageInfo<Departure> pageInfo = departureService.queryPageListByParam(page, limit, departure);
        pageTable.setCode(WebConstant.PAGESUCCESSCODE);
        pageTable.setMsg("获取成功");
        pageTable.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        System.out.println(responseAPI + "------------------------------");
        return responseAPI.getJsonString(pageTable);
    }
    @RequestMapping("/saveUpdatePage")
    public String saveUpdatePage(Integer id, ModelMap modelMap) {
        if (id != null) {
            modelMap.put("departure", departureService.queryById(id));
        }
        return "departure/saveUpdatePage";
    }

    @RequestMapping("/saveUpdate")
    @ResponseBody
    public String saveUpdate(Departure departure) {

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        if (departure.getId() != null) {
            departureService.updateNoNull(departure);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("更新成功");
        } else {
            departure.setLogictodelete(1);
            departureService.insert(departure);
            jsonReturnData.setCode(WebConstant.SUCCESSCODE);
            jsonReturnData.setMsg("添加成功");
        }

        return responseAPI.getJsonString(jsonReturnData);
    }
    @RequestMapping("/queryDate2")
    @ResponseBody
    public String queryDate2(Integer page,Integer limit,String start, String end) {
        PageTable<List<Departure>> pageTable = new PageTable<List<Departure>>();

        JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PageInfo<List> pageInfo = null;
        try {
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            pageInfo = departureService.queryDatePage(page, limit, startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.err.println(pageInfo.getList());
        System.err.println(pageInfo.getTotal());
//        pageTable.setData(pageInfo.getList());
//        jsonReturnData.setData(pageInfo.getList());
        pageTable.setCount(pageInfo.getTotal());
        jsonReturnData.setCode(WebConstant.PAGESUCCESSCODE);
        jsonReturnData.setMsg("更新成功");

//        System.err.println(responseAPI.getJsonString(jsonReturnData));
    //{"code":200,"msg":"success","data":null,"jsonMap":null}
        return responseAPI.getJsonString(jsonReturnData);
    }

}