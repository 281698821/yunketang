package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.HolidayDao;
import cn.itsource.model.Holiday;
import cn.itsource.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class HolidayServiceImpl extends BaseServiceImpl<Holiday> implements HolidayService {

    @Autowired
    HolidayDao holidayDao;
    @Override
    public void updateDeletes(String ids) {
        holidayDao.updateDeletes(ids);

    }

    @Override
    public Holiday queryByTime(Date data) {
        return holidayDao.queryByTime(data);
    }


}
