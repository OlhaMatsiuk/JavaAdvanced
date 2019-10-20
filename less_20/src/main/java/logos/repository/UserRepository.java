package logos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import logos.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUserName(String userName);
}
