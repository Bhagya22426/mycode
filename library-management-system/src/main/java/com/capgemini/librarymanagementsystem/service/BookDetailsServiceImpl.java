package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.dao.BookDetailsDao;
import com.capgemini.librarymanagementsystem.dto.BookDetailsInfoBean;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{
	@Autowired
private BookDetailsDao dao;
	
	@Override
	public boolean addBook(BookDetailsInfoBean book) {
		return dao.addBook(book);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public boolean updateBook(int bookId, String bookName) {
		return dao.updateBook(bookId, bookName);
	}

	@Override
	public List<BookDetailsInfoBean> showAllBooks() {
		return dao.showAllBooks();
	}

	@Override
	public List<BookDetailsInfoBean> searchBook(String bookName) {
		return dao.searchBook(bookName);
	}

}
