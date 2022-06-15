package com.test.example.DAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.example.entity.Administrators;
import com.test.example.entity.Customers;

@Repository
@Component
@Transactional

public class CustomersDAO {
		@Autowired
		EntityManager em; 
		@Autowired                                                                                                                                             
	    private SessionFactory sessionFactory;
		
		@SuppressWarnings("unchecked")	
		public Customers authenticate(String email, String pwd) {
			List<Customers> list = em.createQuery("Select c from Customers c where c.email=:email and c.pwd=:pwd")
					.setParameter("email", email)
					.setParameter("pwd", pwd)
					.getResultList();
			if (list.size() > 0)
				return (Customers) list.get(0);
			else
				return null;
			
		}
		
		@SuppressWarnings("unchecked")
		public Customers authenticateid(Long id, String pwd) {
			List<Customers> list2 = em.createQuery("Select c from Customers c where c.id=:id and c.pwd=:pwd")
					.setParameter("id", id)
					.setParameter("pwd", pwd)
					.getResultList();
			if (list2.size() > 0)
				return (Customers) list2.get(0);
			else
				return null;
			
		}
		
		
		
		
		
		@SuppressWarnings("unchecked")
		public Customers getCustEmail(String email) {
			List<Customers> list3 = em.createQuery("Select c from Customers c where c.email=:email")
					.setParameter("email", email)
					.getResultList();;
			if (list3.size() > 0)
				return (Customers) list3.get(0);
			else
				return null;	}
		
		@SuppressWarnings("unchecked")
		public Customers getCustId(Long id) {
			List<Customers> list3 = em.createQuery("Select c from Customers c where c.id=:id")
					.setParameter("id", id)
					.getResultList();;
			if (list3.size() > 0)
				return (Customers) list3.get(0);
			else
				return null;	}
		 
		@SuppressWarnings("unchecked")
		public Customers getCustByName(String fullname) {
			List<Customers> list3 = em.createQuery("Select c from Customers c where c.fullname=:fullname")
					.setParameter("fullname", fullname)
					.getResultList();;
			if (list3.size() > 0)
				return (Customers) list3.get(0);
			else
				return null;	}
		
		
		
		

		@SuppressWarnings("unchecked")
		public void updatecPwd(Customers cust) {	
			String sql = "update Customers set pwd=:pwd WHERE email=:email";
			Query query = (Query) em.createQuery(sql);
			query.setParameter("email", cust.getEmail());
			query.setParameter("pwd", cust.getPwd());
			query.executeUpdate();			}
		
//   in this case String sql = "update Customers set pwd=:pwd WHERE email=:email"; has to match with the class name 
		
		
		@SuppressWarnings("unchecked")
		public Customers getAllCustomers() {
			List<Customers> list3 = em.createQuery("select * from Customers").getResultList();
			if (list3.size() > 0)
				return (Customers) list3.get(0);
			else
				return null;	}
	 
		
		
	}

