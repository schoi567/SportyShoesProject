package com.test.example.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.test.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;


@RepositoryRestResource(path="Administrators")
@Component

public class AdministratorsDAO {
	@Autowired
	EntityManager em; 
	
 
	
	
	@SuppressWarnings("unchecked")
	public Administrators getAdminId(String id) {
		List<Administrators> list2 = em.createQuery("Select c from Administrators c where c.id=:id")
				.setParameter("id", id)
				.getResultList();;
		if (list2.size() > 0)
			return (Administrators) list2.get(0);
		else
			return null;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Administrators authenticate(String adminid, String pwd) {
		List<Administrators> list = em.createQuery("Select c from Administrators c where c.id=:id and c.pwd=:pwd")
				.setParameter("id", adminid)
				.setParameter("pwd", pwd)
				.getResultList();
		if (list.size() > 0)
			return (Administrators) list.get(0);
		else
			return null;
		
	}  
		
	
			
	

	@SuppressWarnings("unchecked")
	public void updatePwd(Administrators admin) {	
		String sql = "update Administrators set pwd=:pwd WHERE id=:id";
		Query query = (Query) em.createQuery(sql);
		query.setParameter("pwd", admin.getPwd());
		query.setParameter("id", admin.getId());		
		query.executeUpdate();		
	}




}

	
