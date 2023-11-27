package com.proyectonu1.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyectonu1.app.entidades.UsuarioDocument;
import com.proyectonu1.app.entidades.historiaClinica;

public interface historiaClinicaRepository extends MongoRepository<historiaClinica, String>{
	
	List<historiaClinica> findByUsuario(UsuarioDocument usuarios);
	
}
