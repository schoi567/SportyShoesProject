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

@Repository
@Component
@Transactional
public class ProductsDAO {
	@Autowired
	EntityManager em;
	 
	
	@SuppressWarnings("unchecked")
	public Products getAllProducts() {
		List<Products> list4 = em.createQuery("select * from Products").getResultList();
		if (list4.size() > 0)
			return (Products) list4.get(0);
		else
			return null;	}
	
 
	@SuppressWarnings("unchecked")
	public Products getProductsId(int Productsid) {
		List<Products> list1 = em.createQuery("Select a from Products a where a.Productsid=:Productsid")
				.setParameter("Productsid", Productsid)
				.getResultList();
		if (list1.size() > 0)
			return (Products) list1.get(0);
		else
			return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public void deleteProduct(int id) {
		// delete all purchase items for this product before deleting this product
		// Pending:Purchase total is not updated in the purchase total - it shows the old value
		
		String sql = "delete from Products where Productsid=:id";
		Query query = (Query) em.createQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
		
	}
	 
	



}

	
