package com.capgemini.librarymanagementsystem.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.dto.BookDetailsInfoBean;
import com.capgemini.librarymanagementsystem.exception.LibraryException;

import lombok.extern.java.Log;
@Log
@Repository
public class BookDetailsDaoImpl implements BookDetailsDao{
	@PersistenceUnit
	private EntityManagerFactory factory;
	

	@Override
	public boolean addBook(BookDetailsInfoBean book) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			throw new LibraryException("BookName is already exist");
		}
	
	}

	@Override
	public boolean deleteBook(int bookId) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		BookDetailsInfoBean bean=manager.find(BookDetailsInfoBean.class, bookId);
		manager.remove(bean);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateBook(int bookId, String bookName) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		BookDetailsInfoBean bean=manager.find(BookDetailsInfoBean.class,bookId);
		transaction.begin();
		try {
			bean.setBookName(bean.getBookName());
			manager.persist(bean);
			transaction.commit();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return true;
	}

	@Override
	public List<BookDetailsInfoBean> showAllBooks() {
		String jpql="select b from BookDetailsInfoBean b";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<BookDetailsInfoBean> query = manager.createQuery(jpql,BookDetailsInfoBean.class);
		List<BookDetailsInfoBean> beans = query.getResultList();
		//return query.getResultList();
		return beans;
	}

	@Override
	public List<BookDetailsInfoBean> searchBook(String bookName) {
		String jpql="select b from BookDetailsInfoBean b where b.bookName =:bookName";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<BookDetailsInfoBean> query = manager.createQuery(jpql,BookDetailsInfoBean.class);
		query.setParameter("bookName", bookName);
				
		return query.getResultList();
		//return query.getSingleResult();
	}

}
