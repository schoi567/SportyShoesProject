package com.test.example.entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table  
public class Purchases {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PurchaseId;
	
 
	@Column(name = "date")
	private LocalDate date;
	

	
	@ManyToMany
	List<Customers> CustomersList = new ArrayList(); 
	public List<Customers> getCustomersList() {return CustomersList;}
	public void setCustomersList(List<Customers> CustomersList) {this.CustomersList = CustomersList;}  
	
	
	
	@ManyToMany
	List<Products> ProductsList = new ArrayList(); 
	public List<Products> getProductsList() {return ProductsList;}
	public void setProductsList(List<Products> ProductsList) {this.ProductsList = ProductsList;}  
	
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(nullable = true, name = "PurchaseAmount")
	private BigDecimal PurchaseAmount;
	
	
	
	
	
	public Purchases() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchases(LocalDate date, int quantity) {
		super();
		this.date = date;	
		this.quantity = quantity;		
	}



	
	public Long getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		PurchaseId = purchaseId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPurchaseAmount() {
		return PurchaseAmount;
	}
	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.PurchaseAmount = purchaseAmount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	 
	
	
	
	
}
