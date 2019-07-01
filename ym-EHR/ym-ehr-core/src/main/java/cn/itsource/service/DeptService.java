package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Dept;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeptService extends BaseService<Dept> {
    //假删除
    public void updateDeletes(@Param(value = "ids") String ids);

    /*和部门和公司连接查询*/
    public PageInfo<Dept> queryPageListByParams(Integer page, Integer limit, Dept dept);

    //查询所有部门及所属公司
    public List<Dept> queryAllListWithCompany();

    //根据id查询数据
    public Dept queryDeptById(Long id);

    /*部门保存的方法*/
    public void insertWithCompany(Dept dept);

    /*部门修改的方法*/
    public void updateWithCompany(Dept dept);

    /*根据部门名称查询部门*/
    public List<Dept> queryDeptByName(String name);

    /*部门去重*/
    public List<Dept> queryAllByDistinct();
}
