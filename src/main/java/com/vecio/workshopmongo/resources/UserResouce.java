package com.vecio.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vecio.workshopmongo.domain.Post;
import com.vecio.workshopmongo.domain.User;
import com.vecio.workshopmongo.dto.UserDTO;
import com.vecio.workshopmongo.services.UserService;

//annotation para falar que é um recurso REST
@RestControllerAdvice
@RequestMapping(value="/users")
public class UserResouce {
	
	//instanciar um objeto do tipo UserService
	@Autowired //annotation para instaciar um serviço automaticamente
	private UserService service;
	
	//método lista de usuários
	//para informar que este método vai ser um end point rest no caminho "/users"
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		//preenche a lista buscando os usuários no BD
		List<User> list = service.findAll();
		//converter a lista de User para lista UserDTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //usando função labda
		return ResponseEntity.ok(listDto);
	}
	
	//método findById (retornando o DTO)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		//instanciar um obj usuário
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//método para inserir usuário
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
		User obj = service.fromDTO(objDTO); //converte DTO para User
		obj = service.insert(obj); //insere no BD
		//instanciar um obj uri para pegar o novo endereço do objeto que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); //created retorna o código 201 que é o código de resposta http quando vc cria um novo recurso
	}
	
	//método para deletar por id
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable String id) {
			service.delete(id); //para deletar o usuário a partir do id
			return ResponseEntity.noContent().build(); //noContent código 204 do http
		}
		
		//método para atualizar dados do usuário
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {
			User obj = service.fromDTO(objDTO); //intancia um obj a partir do objDTO
			obj.setId(id); //para buscar o id do usuario que está sendo utualizado
			obj = service.update(obj); //atualiza os dados no BD
			//instanciar um obj uri para pegar o novo endereço do objeto que foi inserido
			return ResponseEntity.noContent().build(); //noContent código 204 do http
		}
	
		//método para retornar os Posts de um usuário
		@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
		public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
			//instanciar um obj usuário
			User obj = service.findById(id);
			return ResponseEntity.ok().body(obj.getPosts());
		}
}
