package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.DepartureDao;
import cn.itsource.model.Departure;
import cn.itsource.service.DepartureService;
import cn.itsource.utils.WebConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.Date;
import java.util.List;

@Service
public class DepartureServiceImpl extends BaseServiceImpl<Departure> implements DepartureService {
    @Autowired
    private DepartureDao departureDao;


    @Override
    public PageInfo<List> queryDatePage(Integer page, Integer limit, Date start, Date end) {
        System.err.println(page);
        PageHelper.startPage(page, WebConstant.PAGESIZE);
        List<Departure> departures = departureDao.queryDate(start, end);
        PageInfo<List> pageInfo = new PageInfo(departures);
        return pageInfo;
    }
}
