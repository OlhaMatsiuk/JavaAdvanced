package logos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import logos.domain.University;

public interface UniversityRepository extends JpaRepository<University, Integer>, CrudRepository<University, Integer>{

	List<University> findByAddress(String address);
	List<University> findByName(String name);	
}
