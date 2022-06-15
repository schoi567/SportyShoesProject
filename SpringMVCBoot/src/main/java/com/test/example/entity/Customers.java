package com.test.example.entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Customers")
public class Customers {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;	     
	    @Column(nullable = false, unique = true, length = 45)
	    private String email;	     
	    @Column(nullable = false, length = 64)
	    private String pwd;    
	    @Column(nullable = false, length = 64)
	    private String fullname;
	    
	    @Column(nullable = false, length = 64)
	    public String CreditCardNumber;
	    
	    @Column(nullable = false, length = 64)  
	    public String CreditCardType;
	    
	    

/* 	    @ManyToMany //(mappedBy ="Customers", fetch = FetchType.EAGER) 
	    //@JoinColumn(name="customers_id", nullable=false)
		List<Purchases> PurchasesList1 = new ArrayList(); 
		public List<Purchases> getPurchasesList1() {return PurchasesList1;}
		public void setPurchasesList1(List<Purchases> PurchasesList1) {this.PurchasesList1 = PurchasesList1;}  */ 
		
//	    @Column(name = "first_name", nullable = false, length = 20)
//	    private String firstName;
//	     
//	    @Column(name = "last_name", nullable = false, length = 20)
//	    private String lastName;
	    

		@Override
		public String toString() {
			return "Customers [id=" + id + ", email=" + email + ", fullname=" + fullname + ", CreditCardNumber="
					+ CreditCardNumber + ", CreditCardType=" + CreditCardType + "]";
		}






		public Customers() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		
		public Customers(String email, String pwd, String fullname, String creditCardNumber, String creditCardType) {
	super();

	this.email = email;
	this.pwd = pwd;
	this.fullname = fullname;
	this.CreditCardNumber = creditCardNumber;
	this.CreditCardType = creditCardType;
}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

 
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getpwd() {
			return pwd;
		}

		public void setpwd(String pwd) {
			this.pwd = pwd;
		}


		public String getCreditCardNumber() {
			return CreditCardNumber;
		}


		public void setCreditCardNumber(String creditCardNumber) {
			CreditCardNumber = creditCardNumber;
		}


		public String getCreditCardType() {
			return CreditCardType;
		}


		public void setCreditCardType(String creditCardType) {
			CreditCardType = creditCardType;
		}

		
	    
	    
	}


	
	
