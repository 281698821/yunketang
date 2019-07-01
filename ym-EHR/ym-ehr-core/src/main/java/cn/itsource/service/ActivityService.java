package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Activity;
import cn.itsource.model.Dept;
import cn.itsource.model.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ActivityService extends BaseService<Activity> {
    public void updateDeletes(String ids);


    public Emp queryByEmp(Integer empId);

    public PageInfo<Activity> queryPageListByParams(Integer page, Integer limit, Activity activity);

    public Activity queryDeptById(Integer id);

    public void insertWithActivity(Activity activity);

    public void updateWithActivity(Activity activity);

    public List<Activity> queryEmpAllList();


}
