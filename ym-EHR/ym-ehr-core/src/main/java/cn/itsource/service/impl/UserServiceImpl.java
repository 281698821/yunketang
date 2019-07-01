/**
 * 代号:隐无为
 * 文件名：UserServiceImpl.java
 * 修改人：
 * 描述：
 */
package cn.itsource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itsource.common.base.impl.BaseServiceImpl;
import cn.itsource.dao.UserDao;
import cn.itsource.model.User;
import cn.itsource.service.UserService;

/**
 * 用途：业务模块名称
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void updateDeletes(String ids) {
	userDao.updateDeletes(ids);
	}

}
