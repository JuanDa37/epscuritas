package com.proyectonu1.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.AdminstradorDocument;

public interface AdministradorRepository extends MongoRepository<AdminstradorDocument, String>{
	
	Optional<AdminstradorDocument> findByUsuarioAndContrasena(String usuario, String contrasena);

}
