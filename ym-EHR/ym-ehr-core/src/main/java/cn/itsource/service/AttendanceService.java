package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Attendance;

import java.util.List;

public interface AttendanceService extends BaseService<Attendance> {
    List<Attendance> getAttendanceEmpName(List<Integer> integers);
    /*批量删除*/
    public void updateByIds(String ids);
}
