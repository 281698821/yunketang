package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.RuleDao;
import cn.itsource.model.Rule;
import cn.itsource.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl extends BaseServiceImpl<Rule> implements RuleService {
    @Autowired
    RuleDao ruleDao;
    @Override
    public void updateByIds(String ids) {
        ruleDao.updateDeletes(ids);
    }

}
