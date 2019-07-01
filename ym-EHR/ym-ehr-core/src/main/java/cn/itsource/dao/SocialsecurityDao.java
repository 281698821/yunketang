package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Socialsecurity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface SocialsecurityDao extends BaseMapper<Socialsecurity> {
    @Update("update ehr_socialsecurity set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids")String ids);
}
