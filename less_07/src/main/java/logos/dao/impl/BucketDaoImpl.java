package logos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import logos.dao.BucketDao;
import logos.domain.Bucket;
import logos.shared.FactoryManager;


public class BucketDaoImpl implements BucketDao{
		
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Bucket create(Bucket bucket) {

		em.getTransaction().begin();
		em.persist(bucket);
		em.getTransaction().commit();

		return bucket;
	}
	
	
	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		bucket = em.find(Bucket.class, id);
		return bucket;
	}
	
	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		Bucket bucket = read(id);
		em.getTransaction().begin();
		em.remove(bucket);
		em.getTransaction().commit();
	}

	@Override
	public List<Bucket> readAll() {
		
		List<Bucket> bucketRecords = new ArrayList<>();
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();	}
}
	

