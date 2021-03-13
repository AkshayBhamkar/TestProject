package com.clc.product.assignment;

abstract public class ProductService {
	
	abstract public void purchaseProduct(int vid,int pid,int qty, Customer cust);
	abstract public void returnProduct(int vid,int pid,int qty, Customer cust);

}
