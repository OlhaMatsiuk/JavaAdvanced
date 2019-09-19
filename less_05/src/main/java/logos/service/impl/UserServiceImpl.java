package logos.service.impl;

import java.util.List;

import logos.dao.UserDao;
import logos.dao.impl.UserDaoImpl;
import logos.domain.User;
import logos.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
		
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

}
