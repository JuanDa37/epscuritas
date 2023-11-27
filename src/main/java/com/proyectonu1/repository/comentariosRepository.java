package com.proyectonu1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectonu1.app.entidades.comentarios;

public interface comentariosRepository extends MongoRepository<comentarios, String>{

}
