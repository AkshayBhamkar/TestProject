package com.scp.spring.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.spring.mvc.beans.ProductBean;
import com.scp.spring.mvc.entities.ProductEntity;
import com.scp.spring.mvc.dao.ProductDao;
import com.scp.spring.mvc.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

		@Autowired
		ProductDao productDao;
	
		static{
			System.out.println("ServiceImpl Loaded...!");
	}
		
		public ProductDao getProductDao() {
			return productDao;
		}

		public void setProductDao(ProductDao productDao) {
			this.productDao = productDao;
		}

	
	
	
	
	
	public boolean addProduct(ProductBean prod) {
		ProductEntity entity = convertBeanToEntity(prod);
		entity.setActive("Y");
		return productDao.insertProduct(entity);
	}

	public ProductBean getProduct(int prodId) {
		return convertEntityToBean(productDao.fetchProduct(prodId));
	}

	public List<ProductBean> deleteProduct(int prodId) {
		return convertEntitiesToBean(productDao.removeProduct(prodId));
	}

	public ProductBean updateProduct(ProductBean prod) {
		ProductEntity entity = productDao.modifyProduct(convertBeanToEntity(prod));
		entity.setActive(prod.getActive());
		return convertEntityToBean(entity);
	}

	public List<ProductBean> getAllProduct() {
		return convertEntitiesToBean(productDao.fetchAllProduct());
	}
	
	private ProductEntity convertBeanToEntity(ProductBean bean){
		ProductEntity entity = new ProductEntity();
		entity.setProductId(bean.getProductId());
		entity.setProductName(bean.getProductName());
		entity.setProductPrice(bean.getProductPrice());
		return entity;
	}
	
	private ProductBean convertEntityToBean(ProductEntity entity){
		ProductBean bean = new ProductBean();
		bean.setProductId(entity.getProductId());
		bean.setProductName(entity.getProductName());
		bean.setProductPrice(entity.getProductPrice());
		return bean;
	}

	private List<ProductBean> convertEntitiesToBean(List<ProductEntity> entities){
		List<ProductBean> beans = new ArrayList<ProductBean>();
		for (ProductEntity entity : entities) {
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}
	
	
	
}
