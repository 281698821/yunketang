package cn.itsource.service.impl;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.ActivityDao;
import cn.itsource.model.Activity;
import cn.itsource.model.Emp;
import cn.itsource.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl extends BaseServiceImpl<Activity> implements ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Override
    public void updateDeletes(String ids) {
        activityDao.updateDeletes(ids);
    }

    @Override
    public Emp queryByEmp(Integer empId) {
        return activityDao.queryByEmp(empId);
    }

    @Override
    public PageInfo<Activity> queryPageListByParams(Integer page, Integer limit, Activity activity) {
        PageHelper.startPage(page,limit);
        List<Activity> activities = activityDao.queryPageListByParams(activity);
        return new PageInfo<>(activities);
    }

    @Override
    public Activity queryDeptById(Integer id) {
        return activityDao.queryDeptById(id);
    }

    @Override
    public void insertWithActivity(Activity activity){
       activityDao.insertWithActivity(activity);
    }

    @Override
    public void updateWithActivity(Activity activity) {
        activityDao.updateWithActivity(activity);
    }

    @Override
    public List<Activity> queryEmpAllList() {
        return activityDao.queryEmpAllList();
    }
}
