package com.clc.product.assignment;

import java.util.Arrays;

public class Vendor {
	private int vendorId;
	private String vendorName;
	private Account[] accounts = new Account[1];
	private double vendorFund; // all account bal sum
	private Product[] listOfProducts;
	
	 
	
	public Product[] getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(Product[] listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	public double getVendorFund() {
		return vendorFund;
	}
	public void setVendorFund(double vendorFund) {
		this.vendorFund = vendorFund;
	}
	
	
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", accounts=" + Arrays.toString(accounts) + ", vendorFund="
				+ vendorFund + ", listOfProducts="
				+ Arrays.toString(listOfProducts) + "]";
	}
	
	
	public Vendor(int vendorId, String vendorName, Account[] accounts,
			double vendorFund, Product[] listOfProducts) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.accounts = accounts;
		this.vendorFund = vendorFund;
		this.listOfProducts = listOfProducts;
	}
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
