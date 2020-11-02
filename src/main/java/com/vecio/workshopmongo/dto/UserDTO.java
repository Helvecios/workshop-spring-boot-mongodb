package com.vecio.workshopmongo.dto;

import java.io.Serializable;

import com.vecio.workshopmongo.domain.User;

//para enviar os dados serial para a rede
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
		//atributos
		private String id;
		private String name;
		private String email;
		
	//construtor padrao
		public UserDTO() {
		}
		
	//construtor sobrecarregado
		public UserDTO(User obj) {
			id = obj.getId();
			name = obj.getName();
			email = obj.getEmail();
			
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
}
