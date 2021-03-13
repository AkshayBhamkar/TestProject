package com.scp.spring.mvc.dao;

import java.util.List;

import com.scp.spring.mvc.entities.ProductEntity;

public interface ProductDao {
	public boolean insertProduct(ProductEntity prod);
	public ProductEntity fetchProduct(int prodId);
	public List<ProductEntity> removeProduct(int prodId);
	public ProductEntity modifyProduct(ProductEntity prod);
	public List<ProductEntity> fetchAllProduct();
}
