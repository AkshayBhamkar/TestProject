package com.scp.spring.mvc.service;

import java.util.List;

import com.scp.spring.mvc.beans.ProductBean;

public interface ProductService {
		public boolean addProduct(ProductBean prod);
		public ProductBean getProduct(int prod);
		public List<ProductBean> deleteProduct(int prod);
		public ProductBean updateProduct(ProductBean prod);
		public List<ProductBean> getAllProduct();
}
