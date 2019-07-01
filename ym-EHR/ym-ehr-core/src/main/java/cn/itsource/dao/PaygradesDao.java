package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Paygrades;
import org.apache.ibatis.annotations.Param;

public interface PaygradesDao extends BaseMapper<Paygrades> {

    public void updateDeletes(@Param(value = "ids") String ids);

}