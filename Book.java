package org.sid.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "programmerbooks")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	
	@Column(name = "Title_Book")
	private String title ; 
	
	@Column(name = "Description_Book")
	private String description ; 
	
	@Column(name = "Type_Book")
	private String type ;
   ///////////////////// Constructors //////////////////////
	public Book(int id, String title, String description, String type) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = type;
	} 
	public Book() {
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
