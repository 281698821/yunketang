package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Holiday;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface HolidayDao extends BaseMapper<Holiday> {

    @Update("update ehr_holiday set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    @Select("select * from ehr_holiday where time=#{data,jdbcType=DATE}")
    public Holiday queryByTime(@Param(value = "data") Date data);
}