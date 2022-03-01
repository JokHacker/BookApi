package org.sid.Controllers;


import java.util.List;

import org.sid.Model.Book;
import org.sid.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private BookService bookSer;
	
	public BookController(BookService bookSer) {
		super();
		this.bookSer = bookSer;
	} 
	// Build Create Book Rest Api
	
	@PostMapping
	public ResponseEntity<Book> SaveBook(@RequestBody Book book ){
		return new ResponseEntity<Book>( this.bookSer.SaveBook(book) , HttpStatus.CREATED) ; 
	}
	
	@GetMapping("/GetAllBooks")
	public List<Book> GetAllBooks(){
		return this.bookSer.GetAllBooks() ; 
	}
	
	@GetMapping("/id={id}")
	public Book GetById(@PathVariable int id){
		return this.bookSer.GetBookByID(id); 
	}
	
	@DeleteMapping("/id={id}")
	public void Delete(@PathVariable int id){
		this.bookSer.Delete(id);
	}
	
	@PutMapping("/id={id}")
	public ResponseEntity<Book> UpdateById(@PathVariable int id , @RequestBody Book book){
		return new ResponseEntity<Book>(this.bookSer.Update(book, id) , HttpStatus.OK);
	}
	
	@GetMapping("/Backend")
	public String Hello() {
		return "Hello Im Backend" ; 
	}
	
}
