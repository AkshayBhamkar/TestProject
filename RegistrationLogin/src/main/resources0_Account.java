package com.clc.product.assignment;

public class Account {
	private long accNo;
	private String accType;
	private double accBalance;
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType
				+ ", accBalance=" + accBalance + "]";
	}
	public Account(long accNo, String accType, double accBalance) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.accBalance = accBalance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
