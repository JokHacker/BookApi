package org.sid.Services.Impl;


import java.util.List;

import org.sid.Exceptions.RecourceNotFound;
import org.sid.Model.Book;
import org.sid.Repositories.BookRepository;
import org.sid.Services.BookService;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImplement implements BookService{
	
	private BookRepository bookRepo ; 
	
	
	public BookServiceImplement(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}


	@Override
	public Book SaveBook(Book book) {
		return this.bookRepo.save(book);
	}

	@Override
	public List<Book> GetAllBooks() {
		 return this.bookRepo.findAll();
	}

	@Override
	public Book GetBookByID(int id) {
		for (Book book : this.bookRepo.findAll()) {
			if(book.getId() == id) {
				return book ; 
			}
		};
		return null ; 
	}


	@Override
	public void Delete(int id) {
		this.bookRepo.deleteById(id);
		}


	@Override
	public Book Update(Book book , int id) {
		// if id exist in data base 
		Book existingBook = this.bookRepo.findById(id).orElseThrow(
				() -> new RecourceNotFound("Book","id", id)
				);
		
		existingBook.setTitle(book.getTitle());
		existingBook.setDescription(book.getDescription());
		existingBook.setType(book.getType());
		// save existing book to DB
		this.bookRepo.save(existingBook);
		return existingBook;
	}
	
	
}
