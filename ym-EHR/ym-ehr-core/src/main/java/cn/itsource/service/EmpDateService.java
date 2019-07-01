package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.wechat.EmpDate;

import java.util.Date;

public interface EmpDateService extends BaseService<EmpDate> {
    Integer updateCardDate(Date date);
}
