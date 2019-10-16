package logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.dao.UniversityRepository;
import logos.domain.University;
import logos.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRep;
	
	@Override
	public University save(University university) {
		return universityRep.save(university);
	}

	@Override
	public University findById(int id) {
		return universityRep.getOne(id);
	}

	@Override
	public University update(University university) {
		return universityRep.save(university);
	}

	@Override
	public void deleteById(int id) {
		universityRep.deleteById(id);
	}

	@Override
	public List<University> findAll() {
		return universityRep.findAll();
	}

	@Override
	public List<University> findByAddress(String address) {
		return universityRep.findByAddress(address);
	}

	@Override
	public List<University> findByName(String name) {
		return universityRep.findByName(name);
	}

}
