package com.clc.product.assignment;

import java.util.Arrays;

public class Bank {
	private int bankId;
	private String bankName;
	private Customer customers[];
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Customer[] getCustomers() {
		return customers;
	}
	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName
				+ ", customers=" + Arrays.toString(customers) + "]";
	}
	public Bank(int bankId, String bankName, Customer[] customers) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.customers = customers;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
