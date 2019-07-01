package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.SocialsecurityDao;
import cn.itsource.model.Socialsecurity;
import cn.itsource.service.SocialsecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SocialsecurityServiceImpl extends BaseServiceImpl<Socialsecurity> implements SocialsecurityService {
    @Autowired
    SocialsecurityDao socialsecurityDao;

    @Override
    public void updateDeletes(String ids) {
        socialsecurityDao.updateDeletes(ids);

    }
}
