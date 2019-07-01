package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.Channel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelService extends BaseService<Channel> {
    public void updateDeletes(@Param(value = "ids") String ids);


    List<Channel> findAll(@Param(value = "logicToDelete") Integer num);
}