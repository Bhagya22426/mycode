package com.capgemini.librarymanagementsystem.dao;


import com.capgemini.librarymanagementsystem.dto.BookRegistrationInfoBean;

public interface BookRegistrationDao {

	public BookRegistrationInfoBean searchRegistration(int bookRegistrationId);
	public boolean addRegistration(int bookRegistrationId);
	public boolean updateRegistration(int bookRegistrationId, BookRegistrationInfoBean beans);
	public boolean deleteRegistration(int bookRegistrationId);
	
	


}
