package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.model.Talentpool;
import cn.itsource.service.TalentpoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TalentpoolServiceImpl extends BaseServiceImpl<Talentpool> implements TalentpoolService {

    @Autowired
    TalentpoolService talentpoolService;

    @Override
    public void updateDeletes(String ids) {
        talentpoolService.updateDeletes(ids);
    }
}