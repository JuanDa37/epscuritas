package com.proyectonu1.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "comentario")
public class comentarios {
	
	@Id
	private String id;
	
	@DocumentReference
	private UsuarioDocument usuarios;
	
	private String comentarios;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UsuarioDocument getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuarioDocument usuarios) {
		this.usuarios = usuarios;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	

}
