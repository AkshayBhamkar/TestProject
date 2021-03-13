package com.scp.spring.mvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//POJO  -- POJI -- Bean  -- Entity




@Entity
@Table(name="annt_product_info")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double productPrice;
	private String isActive;
	
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String isActive() {
		return isActive;
	}
	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "\n ProductEntity [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice
				+ ", isActive=" + isActive + "]";
	}
	public ProductEntity(int productId, String productName, double productPrice,String active) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.isActive=active;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
