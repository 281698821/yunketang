package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Compensation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CompensationDao extends BaseMapper<Compensation> {
    @Update("update ehr_compensation set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids")String ids);

    public Compensation findById(Integer id);
    public List<Compensation> queryListByPage(@Param(value = "name")String name);
}