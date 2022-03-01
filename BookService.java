package org.sid.Services;


import java.util.List;

import org.sid.Model.Book;

public interface BookService {
	public abstract Book SaveBook(Book book);  
	public abstract List<Book> GetAllBooks() ; 
	public abstract Book GetBookByID(int id) ; 
	public abstract void Delete(int id) ; 
	public abstract Book Update(Book book , int id) ; 
}
