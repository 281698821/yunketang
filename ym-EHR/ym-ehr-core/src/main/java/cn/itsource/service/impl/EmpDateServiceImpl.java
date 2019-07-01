package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.EmpDateDao;
import cn.itsource.model.Attendance;
import cn.itsource.model.Emp;
import cn.itsource.model.wechat.EmpDate;
import cn.itsource.service.AttendanceService;
import cn.itsource.service.EmpDateService;
import cn.itsource.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpDateServiceImpl extends BaseServiceImpl<EmpDate> implements EmpDateService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EmpDateDao empDateDao;
    @Autowired
    AttendanceService attendanceService;
    @Autowired
    EmpService empService;
    @Value("${qywx.empinterface}")
    String dataurl;
    @Override
    public Integer updateCardDate(Date date){
//        List<EmpDate> empDates = restTemplate.getForObject(dataurl, List.class);
        long l = Date.parse(String.valueOf(new Date()))/1000;
//        l = 1548000000;
        /*list是复杂的嵌套json*/
        List<EmpDate> empDates= restTemplate.exchange(dataurl+"?date="+l, HttpMethod.GET, null, new ParameterizedTypeReference<List<EmpDate>>() {
        }).getBody();
        //将打卡数据与员工名字对应
        empDates.forEach(empDate -> {
            Emp emp = new Emp();
            emp.setUserid(empDate.getUserid());
            Emp emp1 = empService.queryByParam(emp);
            empDate.setEmpname(emp1.getName());
            if ("未打卡".equals(empDate.getException_type())){
                Attendance attendance = new Attendance();
                attendance.setEmpId(emp1.getId());
                attendance.setClockiniocation("未打卡");
                attendance.setTag(3);
                attendance.setLogictodelete(1);
                attendanceService.insert(attendance);
            }else if("时间异常".equals(empDate.getException_type())){
                Attendance attendance = new Attendance();
                attendance.setClockintime(new Date(empDate.getCheckin_time()));
                attendance.setClockiniocation("时间异常");
                attendance.setEmpId(emp1.getId());
                attendance.setTag(2);
                attendance.setLogictodelete(1);
                attendanceService.insert(attendance);
            }else {
                Attendance attendance = new Attendance();
                attendance.setClockintime(new Date(empDate.getCheckin_time()));
                attendance.setClockiniocation("地点异常");
                attendance.setEmpId(emp1.getId());
                attendance.setLogictodelete(1);
                attendanceService.insert(attendance);
            }
        });
        int i = empDateDao.insertList(empDates);
        return i;
    }
}
