package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Paygrades;

public interface PaygradesService extends BaseService<Paygrades> {
    public void updateDeletes(String ids);
}
