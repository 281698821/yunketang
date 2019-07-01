package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Releases;
import org.apache.ibatis.annotations.Param;

public interface ReleasesService extends BaseService<Releases> {
    public void updateDeletes(@Param(value = "ids") String ids);
}