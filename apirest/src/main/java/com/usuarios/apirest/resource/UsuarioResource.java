package com.usuarios.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.apirest.models.Usuario;
import com.usuarios.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//Lista todos os usuarios da tabela(banco de dados)
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	//Lista um usuario especifico de acordo com a id passada
	@GetMapping("/usuario/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	//Adiciona um novo usuario na tabela(banco de dados)
	@PostMapping("/usuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//Remove uma linha(usuario) da tabela(banco de dados)
	@DeleteMapping("/usuario")
	public void deletaUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	//Atualizar um usuario no banco de dados
	@PutMapping("/usuario")
	public Usuario editaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
}
