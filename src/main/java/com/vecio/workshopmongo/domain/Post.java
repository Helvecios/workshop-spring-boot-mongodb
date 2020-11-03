package com.vecio.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vecio.workshopmongo.dto.AuthorDTO;
import com.vecio.workshopmongo.dto.CommentDTO;

//implementar Serializable para transmitir os dados serial na rede
@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//atributos
	@Id
	private String id;
	private Date date;
	private String title;
	private String doby;
	private AuthorDTO author;
	
	//lista de CommentDTO e instanciar a lista
	private List<CommentDTO> comments = new ArrayList<>();
	
	//construtor padrão
	public Post() {
	}

	//construtor com argumentos
	public Post(String id, Date date, String title, String doby, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.doby = doby;
		this.author = author;
	}

	//getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoby() {
		return doby;
	}

	public void setDoby(String doby) {
		this.doby = doby;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	
	//hashCode and Equals para comparar objetos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
