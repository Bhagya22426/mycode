package com.capgemini.librarymanagementsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.dto.BookDetailsInfoBean;
import com.capgemini.librarymanagementsystem.dto.LibraryResponse;
import com.capgemini.librarymanagementsystem.service.BookDetailsService;

@RestController
public class BookDetailsController {

	@Autowired
	private BookDetailsService service;

	@PostMapping(path= "/addBook",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse addBook(@RequestBody BookDetailsInfoBean bean) {
		LibraryResponse response = new LibraryResponse();
		if(service.addBook(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Added to the database");
			response.setBookList(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Book Not Added to Database");
		}
		return response;
	}

	@PutMapping(path="/updateBook",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse updateBook(@RequestBody BookDetailsInfoBean bean) {
		LibraryResponse response =new LibraryResponse();
		if(service.updateBook(bean.getBookId(), bean.getBookName())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Book is updated successfully");
			response.setBookList(Arrays.asList(bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book is not updated");
		}
		return response;
	}
	@DeleteMapping(path="/deleteBook/{bookId}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse deleteBook(@PathVariable("bookId") int bookId) {
		LibraryResponse response= new LibraryResponse();
		if(service.deleteBook(bookId)){
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Book is deleted successfully");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book is not deleted");

		}
		return response;
	}
	@GetMapping(path="/showAllBooks",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse showAllBooks() {
		LibraryResponse response=new LibraryResponse();
		List<BookDetailsInfoBean> bean= service.showAllBooks();
		if(bean!=null && !bean.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Displayed books");
			response.setBookList(bean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Books are not displayed");

		}
		return response;
	}

	@GetMapping(path = "/search",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse searchBook(@RequestParam("bookName")String bookName) {
		List<BookDetailsInfoBean> bean= service.searchBook(bookName);
		LibraryResponse response=new LibraryResponse();
		if(bean!=null && !bean.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Book found in database");
			response.setBookList(bean);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book is not present in database");

		}
		return response;
	}
}
