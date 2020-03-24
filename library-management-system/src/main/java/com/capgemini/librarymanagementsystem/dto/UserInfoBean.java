package com.capgemini.librarymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserInfoBean {
	@Id
	@Column
	@GeneratedValue
	private int userId;
	@Column
	private String userName;
	@Column
	private String email;
	@Column
	private String password;
	

}
