package ua.lviv.lgs.login;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.basic.User;

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

	public void saveUser(User user) {
		listOfUsers.add(user);
	}

	public User getUser(String email) {
		return listOfUsers.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
	}


}
