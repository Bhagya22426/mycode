package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookDetailsInfoBean;

public interface BookDetailsDao {


	
	public boolean addBook(BookDetailsInfoBean book);
	public boolean deleteBook(int bookId);
	public boolean updateBook(int bookId,String bookName);
	public  List<BookDetailsInfoBean> showAllBooks();
	public List<BookDetailsInfoBean> searchBook(String bookName);
}
