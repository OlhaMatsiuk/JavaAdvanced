package logos.login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logos.basic.User;
import logos.dao.UserDao;
import logos.service.ConnectionUtils;


public class UserService {
	
	private List<User> listOfUsers = new ArrayList<>();
	private static UserService userService;

	private UserService() {}

	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	public void saveUser(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		listOfUsers.add(user);
		UserDao UserDao = new UserDao(ConnectionUtils.openConnection());
		UserDao.insert(user);
	}

	public User getUser(String email) {
		return listOfUsers.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
	}


}
