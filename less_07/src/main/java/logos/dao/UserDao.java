package logos.dao;

import logos.domain.User;
import logos.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}
