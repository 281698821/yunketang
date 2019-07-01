package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.AttendanceDao;
import cn.itsource.model.Attendance;
import cn.itsource.service.AttendanceService;
import cn.itsource.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AttendanceServiceImpl extends BaseServiceImpl<Attendance> implements AttendanceService {
    @Autowired
    AttendanceDao attendanceDao;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EmpService empService;
    @Value("${qywx.empinterface}")
    String dataurl;
    @Override
    public List<Attendance>  getAttendanceEmpName(List<Integer> integers) {
        List<Attendance> attendances = attendanceDao.queryById(integers);
        return attendances;
    }

    @Override
    public void updateByIds(String ids) {
        attendanceDao.updateDeletes(ids);
    }

}
