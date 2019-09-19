package logos.service.impl;

import java.util.List;

import logos.dao.MagazineDao;
import logos.dao.impl.MagazineDaoImpl;
import logos.domain.Magazine;
import logos.service.MagazineService;

public class MagazineServiceImpl implements MagazineService{

	MagazineDao magazineDao;
	
	public MagazineServiceImpl() {
		magazineDao = new MagazineDaoImpl();
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

}
