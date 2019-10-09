package logos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import logos.dao.MagazineDao;
import logos.domain.Magazine;
import logos.shared.FactoryManager;


public class MagazineDaoImpl implements MagazineDao{

	private EntityManager em = FactoryManager.getEntityManager();
		
	@Override
	public Magazine create(Magazine magazine) {
		em.getTransaction().begin();
		em.persist(magazine);
		em.getTransaction().commit();
		
		return magazine;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			magazine = em.find(Magazine.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {
		return magazine;
	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public List<Magazine> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Magazine e");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
}
