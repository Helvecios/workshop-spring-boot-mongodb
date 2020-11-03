package com.vecio.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vecio.workshopmongo.domain.Post;
import com.vecio.workshopmongo.domain.User;
import com.vecio.workshopmongo.dto.AuthorDTO;
import com.vecio.workshopmongo.dto.CommentDTO;
import com.vecio.workshopmongo.repository.PostRepository;
import com.vecio.workshopmongo.repository.UserRepository;

@Configuration //annotation para o Spring entender que isso é uma configuração
public class Instantiation implements CommandLineRunner{

	//injetar o UserRepository para fazer a operação com o BD
	@Autowired
	private UserRepository userRepository;
	
	//injetar o PostRepository para fazer a operação com o BD
		@Autowired
		private PostRepository postRepository;
		
	//método para instanciar objetos e salvar no BD
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll(); //para limpar a coleção de User no MogoDB
		postRepository.deleteAll(); //para limpar a coleção de Post no MogoDB
		
		//instanciar os objetos dados do usuário
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar os objetos na coleção de usuários
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		//instaciar os objetos Post
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		//instanciar os comentários
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		//salvar os objetos na coleção de comentários
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		//salvar os objetos na coleção de Post
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		//salvar os Posts da maria no BD
		userRepository.save(maria);
	}
}
