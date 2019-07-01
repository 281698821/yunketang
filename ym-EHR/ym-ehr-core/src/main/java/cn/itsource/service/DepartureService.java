package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Departure;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface DepartureService extends BaseService<Departure> {
    PageInfo<List> queryDatePage(Integer page, Integer limit, Date start, Date end);
}
