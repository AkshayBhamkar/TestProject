package com.scp.spring.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.spring.mvc.entities.ProductEntity;
import com.scp.spring.mvc.util.SessionFactoryUtil;
import com.scp.spring.mvc.dao.ProductDao;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	
	static{
		System.out.println("productDaoImpl Loaded.....!");
	}
	
	@Autowired
	SessionFactory sfactory;
	
	public SessionFactory getSfactory() {
		return sfactory;
	}

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}


	public boolean insertProduct(ProductEntity prod) {
		Session session = null;
		Transaction tr =null;
		try{
			session = sfactory.openSession();
			tr= session.beginTransaction();
			session.save(prod);
			return true;
		}catch(Exception e){
			System.out.println("Insert product Failed..!"+e.getMessage());
			return false;
		}finally{
			SessionFactoryUtil.closeResources(session, tr);
		}
		
	}

	public ProductEntity fetchProduct(int prodId) {
		Session session = null;
		try{
			session = sfactory.openSession();
			return session.get(ProductEntity.class,prodId);
		}catch(Exception e){
			System.out.println("fetch product Failed..!"+e.getMessage());
			return null;
		}finally{
			SessionFactoryUtil.closeResources(session, null);
		}
		
	}

	public List<ProductEntity> removeProduct(int prodId) {
		Session session = null;
		Transaction tr =null;
		ProductEntity dbEntity = fetchProduct(prodId);
		if (null!=dbEntity){
			try{
				session = sfactory.openSession();
				tr= session.beginTransaction();
				session.remove(dbEntity);
			}catch(Exception e){
				System.out.println("Fetch product Failed..!"+e.getMessage());
			}finally{
				SessionFactoryUtil.closeResources(session, tr);
			}
		}
		return fetchAllProduct();
	}

	public ProductEntity modifyProduct(ProductEntity prod) {
		Session session = null;
		Transaction tr =null;
		
		ProductEntity dbEntity = fetchProduct(prod.getProductId());
		
		if(dbEntity!=null){
			try{
				session = sfactory.openSession();
				tr= session.beginTransaction();
				dbEntity.setActive(prod.isActive());
				dbEntity.setProductName(prod.getProductName());
				dbEntity.setProductPrice(prod.getProductPrice());
				return (ProductEntity) session.merge(dbEntity);
			}catch(Exception e){
				System.out.println("MOdify product Failed..!"+e.getMessage());
			}finally{
				SessionFactoryUtil.closeResources(session, tr);
			}
		}
		return null;
	}

	public List<ProductEntity> fetchAllProduct() {
		Session session = null;
		try{
			session = sfactory.openSession();
			return session.createCriteria(ProductEntity.class).list();
		}catch(Exception e){
			System.out.println("Insert product Failed..!"+e.getMessage());
			return null;
		}finally{
			SessionFactoryUtil.closeResources(session, null);
		}
		
	}

	
	
}

