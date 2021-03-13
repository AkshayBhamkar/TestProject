package com.scp.spring.mvc.beans;

public class ProductBean {
	private int productId;
	private String productName;
	private double productPrice;
	private String active="Y";
	
	
	
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(int productId, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
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
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice
				+ ", isActive=" + active + "]";
	}
	
	
	
}
