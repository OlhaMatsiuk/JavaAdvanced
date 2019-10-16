package logos.service;

import java.util.List;

import logos.domain.University;

public interface UniversityService {

	University save(University university);
	University findById(int id);
	University update(University university);
	void deleteById(int id);
	
	List<University> findAll();
	List<University> findByAddress(String address);
	List<University> findByName(String name);	
}
