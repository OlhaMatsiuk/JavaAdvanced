package logos.service;

import logos.domain.User;
import logos.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}
