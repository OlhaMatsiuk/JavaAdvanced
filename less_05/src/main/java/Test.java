import java.util.Date;

import logos.domain.Magazine;
import logos.domain.User;
import logos.service.MagazineService;
import logos.service.UserService;
import logos.service.impl.MagazineServiceImpl;
import logos.service.impl.UserServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		us.create(new User("olha","matsiuk","olya@ef.com", "erfe"));
		
	}

}
