package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Releases;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ReleasesDao extends BaseMapper<Releases> {
    @Update("update ehr_releases set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);
}