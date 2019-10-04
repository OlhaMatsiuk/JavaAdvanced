package logos.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import logos.dao.MagazineDao;
import logos.dao.impl.MagazineDaoImpl;
import logos.domain.Magazine;
import logos.service.MagazineService;

public class MagazineServiceImpl implements MagazineService{

	private MagazineDao magazineDao;
	private static MagazineService magazineServiceImp;
	
	private MagazineServiceImpl() {
		magazineDao = new MagazineDaoImpl();
	}
	
	public static MagazineService getMagazineService() {
		if (magazineServiceImp == null) {
			magazineServiceImp = new MagazineServiceImpl();
		}

		return magazineServiceImp;
	}

	@Override
	public Magazine create(Magazine magazine) {
		return magazineDao.create(magazine);
	}

	@Override
	public Magazine read(Integer id) {
		return magazineDao.read(id);
	}

	@Override
	public Magazine update(Magazine magazine) {
		return magazineDao.update(magazine);
	}

	@Override
	public void delete(Integer id) {
		magazineDao.delete(id);
		
	}

	@Override
	public List<Magazine> readAll() {
		return magazineDao.readAll();
	}

	@Override
	public Map<Integer, Magazine> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Magazine::getId, Function.identity()));
	}

}


