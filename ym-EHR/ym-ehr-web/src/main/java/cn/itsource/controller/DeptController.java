package cn.itsource.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.itsource.common.ResponseAPI;
import cn.itsource.excel.CompanyNameExcel;
import cn.itsource.excel.DeptExcel;
import cn.itsource.model.Company;
import cn.itsource.model.Dept;
import cn.itsource.service.CompanyService;
import cn.itsource.service.DeptService;
import cn.itsource.utils.JsonReturnData;
import cn.itsource.utils.PageTable;
import cn.itsource.utils.WebConstant;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/deptController")
public class DeptController {
    
        // 日志对象
        Logger logger = LoggerFactory.getLogger(getClass());
        @Autowired
        DeptService deptService;

        @Autowired
        CompanyService companyService;

        @Autowired
        ResponseAPI responseAPI;

        /**
         * 功能: 列表页面
         * 代号: 隐无为
         */
        @RequestMapping("/list")
        public String list(Model model) {
            //得到部门列表
            //得到公司列表
            List<Company> companies = companyService.queryAllList();
            List<Dept> depts=deptService.queryAllByDistinct();
            model.addAttribute("deptNames", depts);
            model.addAttribute("companies", companies);
            logger.info("===============进入列表页面==================");
            return "dept/list";
        }

        /**
         * 功能: 保存或修改页面
         * 代号: 隐无为
         */
        @RequestMapping("/saveUpdatePage")
        public String saveUpdatePage(Long id, ModelMap modelMap) {
            //得到公司列表
            List<Company> companies = companyService.queryAllList();
            modelMap.put("companies", companies);
            if (id != null) {
                modelMap.put("dept", deptService.queryDeptById(id));
            }
            return "dept/saveUpdatePage";
        }

        /**
         * 功能: ajax-获取列表数据
         * 代号: 隐无为
         */
        @RequestMapping("/ajaxList")
        @ResponseBody
        public String ajaxList(Integer page, Integer limit, Dept dept, String companyName) {
            PageTable<List<Dept>> pageTable = new PageTable<List<Dept>>();
            dept.setLogictodelete(WebConstant.NODELETECODE);
            Company company = companyService.queryCompanyByName(companyName);
            dept.setCompany(company);
            PageInfo<Dept> pageInfo = deptService.queryPageListByParams(page, limit, dept);
//            PageInfo<Dept> pageInfo = deptService.queryPageListByParam(page, limit, dept);
            pageTable.setCode(WebConstant.PAGESUCCESSCODE);
            pageTable.setMsg("获取成功");
            pageTable.setData(pageInfo.getList());
            pageTable.setCount(pageInfo.getTotal());
            return responseAPI.getJsonString(pageTable);

        }


        /**
         * 功能: 保存或修改操作
         * 代号: 隐无为
         */
        @RequestMapping("/saveUpdate")
        @ResponseBody
        public String saveUpdate(Dept dept, String companyName) {
            Company company = companyService.queryCompanyByName(companyName);
            dept.setCompany(company);
            JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "操作失败");
            if (dept.getId() != null) {
                deptService.updateWithCompany(dept);
                jsonReturnData.setCode(WebConstant.SUCCESSCODE);
                jsonReturnData.setMsg("更新成功");
            } else {
                dept.setLogictodelete(1);
                deptService.insertWithCompany(dept);
                jsonReturnData.setCode(WebConstant.SUCCESSCODE);
                jsonReturnData.setMsg("添加成功");
            }

            return responseAPI.getJsonString(jsonReturnData);
        }

        /**
         * 功能: 删除(假删除)
         * 代号: 隐无为
         */
        @RequestMapping("/delete")
        @ResponseBody
        public String delete(Dept dept) {

            JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "删除失败");
            if (dept.getId() != null) {
                dept.setLogictodelete(WebConstant.DELETECODE);
                deptService.updateDelete(dept);
                jsonReturnData.setCode(WebConstant.SUCCESSCODE);
                jsonReturnData.setMsg("删除成功");
            }

            return responseAPI.getJsonString(jsonReturnData);
        }

        /**
         * 功能: 批量删除(假删除)
         * 代号: 隐无为
         */
        @RequestMapping("/deletes")
        @ResponseBody
        public String deletes(String ids) {
            JsonReturnData<String> jsonReturnData = new JsonReturnData<>(WebConstant.ERRORCODE, "批量删除失败");
            if (!StringUtils.isEmpty(ids)) {
                deptService.updateDeletes(ids);
                jsonReturnData.setCode(WebConstant.SUCCESSCODE);
                jsonReturnData.setMsg("批量删除成功");
            }
            return responseAPI.getJsonString(jsonReturnData);
        }

        /**
         * 功能: 导出excel
         * 代号: 隐无为
         */
    @RequestMapping("/export")
    public void export(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<Dept> list = deptService.queryAllListWithCompany();
        List<DeptExcel> listExcel = new ArrayList<DeptExcel>();

        for (Dept dept : list) {
            DeptExcel deptExcel = new DeptExcel();

            BeanUtils.copyProperties(dept, deptExcel);

            Company company = dept.getCompany();

            CompanyNameExcel companyNameExcel = new CompanyNameExcel();

            BeanUtils.copyProperties(company,companyNameExcel);

            deptExcel.setCompanyNameExcel(companyNameExcel);

            listExcel.add(deptExcel);
        }

        ExportParams params = new ExportParams(null, "测试", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, listExcel);//导出的列表集合
        map.put(NormalExcelConstants.CLASS, DeptExcel.class);//excel 类
        map.put(NormalExcelConstants.PARAMS, params);// 参数
        map.put(NormalExcelConstants.FILE_NAME, "部门信息"); //文件名
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

}
