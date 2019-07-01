package cn.itsource.dao;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.Channel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChannelDao extends BaseMapper<Channel> {
    @Update("update ehr_channel set logicToDelete=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);


    @Select("SELECT * FROM ehr_channel WHERE logicToDelete in (#{logicToDelete})")
    List<Channel> findAll(@Param(value = "logicToDelete") Integer num);

}