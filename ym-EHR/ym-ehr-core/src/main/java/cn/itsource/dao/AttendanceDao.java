package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Attendance;
import com.github.pagehelper.Page;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttendanceDao extends BaseMapper<Attendance> {
    List<Attendance> queryById(List<Integer> integers);
    @Update("update ehr_attendance set logictoDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

}