package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Position;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService extends BaseService<Position> {
    public void updateDeletes(@Param(value = "ids") String ids);

    //根据部门条件查询
    public PageInfo<Position> queryPageListByParams(Integer page, Integer limit, Position position);
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
