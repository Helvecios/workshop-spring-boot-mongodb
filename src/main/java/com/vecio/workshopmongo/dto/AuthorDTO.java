package com.vecio.workshopmongo.dto;

import java.io.Serializable;

import com.vecio.workshopmongo.domain.User;

//implementar Serializable para transmitir os dados serial na rede
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//atributos
	private String id;
	private String name;
	
	//construtor padrão
	public AuthorDTO() {
	}
	
	//construtor carregado (com usuário como argumeto)
	public AuthorDTO(User obj) {
		//instanciar o autor
		id = obj.getId();
		name = obj.getName();
	}

	//getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
