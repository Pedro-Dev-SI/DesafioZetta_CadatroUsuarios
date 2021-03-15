package com.usuarios.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.apirest.models.Usuario;

//Usando o JpaRepository para utilizar os metodos prontos para fazer persistencias no banco de dados
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);
	
}
