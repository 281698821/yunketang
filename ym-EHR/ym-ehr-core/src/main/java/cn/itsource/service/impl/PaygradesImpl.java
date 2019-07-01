package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.PaygradesDao;
import cn.itsource.model.Paygrades;
import cn.itsource.service.PaygradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaygradesImpl extends BaseServiceImpl<Paygrades> implements PaygradesService {
    @Autowired
    private PaygradesDao paygradesDao;
    @Override
    public void updateDeletes(String ids) {
        paygradesDao.updateDeletes(ids);
    }
}
