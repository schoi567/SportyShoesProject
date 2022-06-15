package com.test.example.entity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Productsid;

    @Column(nullable = false)
	@Enumerated(EnumType.STRING)   
	private BrandType brand;
    private String productname;
    @Enumerated(EnumType.STRING)   
	private ColorType color;
    @Column(name="size", precision=12, scale=2)
    private BigDecimal size;
    private BigDecimal price;        
    
/*	@ManyToMany 
	List<Purchases> PurchasesList = new ArrayList(); 
	public List<Purchases> getPurchasesList() {return PurchasesList;}
	public void setPurchasesList(List<Purchases> PurchasesList) {this.PurchasesList = PurchasesList;}  */ 

/*    @ManyToOne 
    private Purchases purchases; */ 

	public Products() {super();}
	public Products( BrandType brand, String productname, ColorType color, BigDecimal size, BigDecimal price) {
		super();
		this.brand = brand;
		this.productname = productname;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public int getProductsid() {
		return Productsid;
	}
	public void setProductsid(int productsid) {
		Productsid = productsid;
	}
	public BrandType getBrand() {
		return brand;
	}
	public void setBrand(BrandType brand) {
		this.brand = brand;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public ColorType getColor() {
		return color;
	}
	public void setColor(ColorType color) {
		this.color = color;
	}
	public BigDecimal getSize() {
		return size;
	}
	public void setSize(BigDecimal size) {
		this.size = size;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [Productsid=" + Productsid + ", brand=" + brand + ", productname=" + productname + ", color="
				+ color + ", size=" + size + ", price=" + price + "]";
	}

	

    
}
