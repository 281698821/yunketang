package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.CompensationDao;
import cn.itsource.model.Compensation;
import cn.itsource.service.CompensationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationServiceImpl extends BaseServiceImpl<Compensation> implements CompensationService {
    @Autowired
    CompensationDao compensationDao;
    @Override
    public void updateDeletes(String ids) {
        compensationDao.updateDeletes(ids);
    }
    @Override
    public PageInfo<Compensation> queryListByPage(Integer pageNum, Integer pageSize, String name){
        PageHelper.startPage(pageNum,pageSize);
        List<Compensation> compensations= compensationDao.queryListByPage(name);
        return new PageInfo<Compensation>(compensations);
    }

    @Override
    public List<Compensation> findAllList() {
        return compensationDao.queryListByPage(null);
    }

    @Override
    public Compensation findById(Integer id) {
        return compensationDao.findById(id);
    }
}
