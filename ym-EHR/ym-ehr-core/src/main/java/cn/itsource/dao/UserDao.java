package cn.itsource.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.itsource.common.base.BaseMapper;
import cn.itsource.model.User;

/*继承通用的mapper，实现增删改查*/
public interface UserDao extends BaseMapper<User> {

    @Update("update ym_user set del_flag=0  where  id in (${ids})")
    public void updateDeletes(@Param(value = "ids") String ids);


}