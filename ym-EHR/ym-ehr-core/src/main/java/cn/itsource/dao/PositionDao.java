package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Position;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PositionDao extends BaseMapper<Position> {
    @Update("update ehr_position set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);

    //根据部门条件查询
    public List<Position> queryPageListByParams(Position position);
    //查询所有数据

    //根据职位id查询
    public Position queryPositionById(Long id);

    //职位联合部门查询
    public List<Position> queryAllListWithDept();

    /*部门保存的方法*/
    public void insertWithDept(Position position);

    /*部门修改的方法*/
    public void updateWithDept(Position position);
}