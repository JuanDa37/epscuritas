package com.proyectonu1.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class citas {
	
	@Id
	private String id;
	
	private String fecha;
	
	private String hora;
	
	private String direccion;
	
	private String tipo;
	
	@DocumentReference
	private UsuarioDocument usuarios;
	
	@DocumentReference
	private MedicoDocument medico;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioDocument getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuarioDocument usuarios) {
		this.usuarios = usuarios;
	}

	public MedicoDocument getMedico() {
		return medico;
	}

	public void setMedico(MedicoDocument medico) {
		this.medico = medico;
	}
	
	
	
	

}
