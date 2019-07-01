package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Holiday;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface HolidayService extends BaseService<Holiday> {
    public void updateDeletes(@Param(value = "ids") String ids);


    public Holiday queryByTime(@Param(value = "data") Date data);

}
