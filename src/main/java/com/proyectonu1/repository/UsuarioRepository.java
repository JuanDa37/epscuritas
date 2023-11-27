package com.proyectonu1.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.proyectonu1.app.entidades.UsuarioDocument;

public interface UsuarioRepository extends MongoRepository<UsuarioDocument, String>{
	
	Optional<UsuarioDocument> findByUsuarioAndContrasena(String usuario, String contrasena);
	
	@Query("{'usuario': ?0}")
    UsuarioDocument findByUsuario(String usuario);


}
