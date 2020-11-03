package com.vecio.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

//para converter os objetos em bytes para transmitir pela rede
public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//atributos
	private String text;
	private Date date;
	private AuthorDTO author;
	
	//construtor padrão
	public CommentDTO() {
	}

	//construtor com argumentos
	public CommentDTO(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}
	
	//getters and setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
