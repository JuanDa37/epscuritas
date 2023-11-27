package com.projectcuritas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projectcuritas.document.UsuarioDocument;

public interface UsuarioRepository extends MongoRepository<UsuarioDocument, String>{

}
