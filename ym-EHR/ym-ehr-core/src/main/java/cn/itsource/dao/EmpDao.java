package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmpDao extends BaseMapper<Emp> {
  @Update("update ehr_emp set logicToDelete=0  where  id in (${ids})")
  public void updateDeletes(@Param(value = "ids")String ids);

  public List<Emp> querySomeList(Emp emp);

  public List<Emp> queryAllWithOthers(Emp emp);

  public Emp queryByIdWithOther(Integer id);
}