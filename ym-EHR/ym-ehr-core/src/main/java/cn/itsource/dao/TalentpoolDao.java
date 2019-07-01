package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Talentpool;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface TalentpoolDao extends BaseMapper<Talentpool> {
    @Update("update ehr_talentpool set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);
}