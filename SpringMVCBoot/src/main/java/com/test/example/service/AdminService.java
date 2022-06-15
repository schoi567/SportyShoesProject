package com.test.example.service;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.test.example.DAO.*;
import com.test.example.entity.Administrators;


@Component
@RepositoryRestResource(path="administrators")
public class AdminService {

	 @Autowired
	 private AdministratorsDAO AdminDAO;
	 
	 	@Transactional
		public Administrators getAdminId(String id) {
			return AdminDAO.getAdminId(id);
		}		

		
		@Transactional
		public void updatePwd(Administrators Admin) {
			AdminDAO.updatePwd(Admin);
		}


	
	

}

