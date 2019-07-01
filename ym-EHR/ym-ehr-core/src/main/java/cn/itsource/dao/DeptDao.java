package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Dept;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DeptDao extends BaseMapper<Dept> {

    @Update("update ehr_dept set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    //根据
    public List<Dept> queryPageListByParams(Dept dept);
    //查询所有数据

    /*根据部门名字查询公司*/
    @Select("select * from ehr_dept e where e.name = #{name} ")
    public List<Dept> queryDeptByName(String name);

    //根据部门id查询
    public Dept queryDeptById(Long id);

    public List<Dept> queryAllListWithCompany();
    /*部门保存的方法*/
    public void insertWithCompany(Dept dept);

    /*部门修改的方法*/
    public void updateWithCompany(Dept dept);

    /*部门去重*/
    @Select("select distinct name,id from ehr_dept")
    public List<Dept> queryAllByDistinct();

}