package com.test.example.DAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.example.entity.*; 

@Repository
@Component
@Transactional
public class PurchaseDAO {
		@Autowired
		EntityManager em; 
		@Autowired                                                                                                                                             
	    private SessionFactory sessionFactory;

		@SuppressWarnings("unchecked")
		public void AddQuantity(int quantity) {
			Purchases pur = new Purchases();
			String sql = "update Purchases set quantity=:quantity WHERE PurchaseId = :PurchaseId";
			Query query = (Query) em.createQuery(sql);
			query.setParameter("quantity", quantity);
			query.setParameter("PurchaseId", pur.getPurchaseId());
			query.executeUpdate();	
			
		
		}
	 
		@SuppressWarnings("unchecked")
		public void deletePurchase(Long id) {
			String sql = "delete from Purchases where PurchaseId=:id";
			Query query = (Query) em.createQuery(sql);
			query.setParameter("id", id);
			query.executeUpdate();
			
		}
		
		
 
	 
		
		
		
 
		
		
		
		
	}

