package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Activity;
import cn.itsource.model.Dept;
import cn.itsource.model.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ActivityDao extends BaseMapper<Activity> {
    @Update("update ehr_activity set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    public Emp queryByEmp(Integer empId);

    public Activity queryDeptById(Integer id);

    public List<Activity> queryPageListByParams(Activity activity);

    public void insertWithActivity(Activity activity);

    public void updateWithActivity(Activity activity);

    public List<Activity> queryEmpAllList();
}