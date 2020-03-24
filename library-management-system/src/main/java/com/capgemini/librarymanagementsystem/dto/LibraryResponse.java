package com.capgemini.librarymanagementsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class LibraryResponse {
	private int statusCode;
	private String message;
	private String description;
	
	private List<BookDetailsInfoBean> beans;
	private List<BookDetailsInfoBean> bookList;
}
