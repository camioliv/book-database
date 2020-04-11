package com.books.apirest.models;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
