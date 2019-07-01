package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.ReleasesDao;
import cn.itsource.model.Releases;
import cn.itsource.service.ReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReleasesServiceImpl extends BaseServiceImpl<Releases> implements ReleasesService {

    @Autowired
    ReleasesDao releasesDao;

    @Override
    public void updateDeletes(String ids) {
        releasesDao.updateDeletes(ids);
    }
}