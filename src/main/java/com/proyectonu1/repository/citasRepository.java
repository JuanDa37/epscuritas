package com.proyectonu1.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyectonu1.app.entidades.MedicoDocument;
import com.proyectonu1.app.entidades.UsuarioDocument;
import com.proyectonu1.app.entidades.citas;

public interface citasRepository extends MongoRepository<citas, String>{
	
	List<citas> findByUsuarios(UsuarioDocument usuarios);
	
	List<citas> findByMedico(MedicoDocument medico);
	
}
