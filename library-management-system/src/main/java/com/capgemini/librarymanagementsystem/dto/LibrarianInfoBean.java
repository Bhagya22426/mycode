package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="librarian_info")
public class LibrarianInfoBean {
	@Id
	@Column
	private String userName;
	@Column
	private String password;
	
	
}
