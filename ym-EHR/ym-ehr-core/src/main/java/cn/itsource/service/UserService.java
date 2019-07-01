package cn.itsource.service;

import cn.itsource.common.base.BaseService;
import cn.itsource.model.User;

public interface UserService extends BaseService<User>{
	public void updateDeletes(String ids);
}
