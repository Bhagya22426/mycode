package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bookTransaction_info")
public class BookTransactionInfoBean {
	@Id
	@Column
	@GeneratedValue
	private int transactionId;
	@Column
	private double fine;
	@Column
	private String issueDate;
	@Column
	private int bookRegistrationId;
	@Column
	private String returnDate;

}
