package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Departure;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface DepartureDao extends BaseMapper<Departure> {
    @Select("select * from ehr_departure where departureTime >= #{start} and departureTime < #{endtime}")
    List<Departure> queryDate(@Param("start") Date start, @Param("endtime")Date endtime);
}