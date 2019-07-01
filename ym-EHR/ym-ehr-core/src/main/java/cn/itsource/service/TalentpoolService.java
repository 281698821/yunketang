package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Talentpool;
import org.apache.ibatis.annotations.Param;

public interface TalentpoolService extends BaseService<Talentpool> {
    public void updateDeletes(@Param(value = "ids") String ids);
}