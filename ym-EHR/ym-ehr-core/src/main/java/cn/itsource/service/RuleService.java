package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Rule;

import java.util.List;

public interface RuleService extends BaseService<Rule> {
    /*批量删除*/
    public void updateByIds(String ids);
}
