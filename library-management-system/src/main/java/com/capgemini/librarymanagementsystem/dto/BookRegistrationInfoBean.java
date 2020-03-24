package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bookRegistration_info")
public class BookRegistrationInfoBean {
	@Id
	@Column
	@GeneratedValue
	private int bookRegistrationId;
	@Column
	private int bookId;
	@Column
	private String bookName;
	@Column
	private int userId;
	@Column
	private String registrationDate;

}
