package com.test.example.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Administrators")
public class Administrators {
		@Id
	    public String id;	    
		@Column(nullable = false)
	    private String pwd;

		public Administrators() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		public Administrators(String id, String pwd) {
			super();
			this.id = id;
			this.pwd = pwd;
		}



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public String getPwd() {
			return pwd;
		}



		public void setPwd(String pwd) {
			this.pwd = pwd;
		}



	 
		
	
	    
	    
	    
}
