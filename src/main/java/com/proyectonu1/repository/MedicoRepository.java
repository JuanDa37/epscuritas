package com.proyectonu1.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyectonu1.app.entidades.MedicoDocument;
public interface MedicoRepository extends MongoRepository<MedicoDocument, String>{
	
	Optional<MedicoDocument> findByUsuarioAndContrasena(String usuario, String contrasena);

}
