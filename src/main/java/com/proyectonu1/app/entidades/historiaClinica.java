package com.proyectonu1.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class historiaClinica {
	
	@Id
	private String id;
	
	@DocumentReference
	private UsuarioDocument usuario;

	private String motivoDeLaConsulta;
	
	private String antecedentesCardiobasculares;
	
	private String antecedentesPulmonares;
	
	private String antecedentesDigestivos;
	
	private String antecedentesDiabetes;
	
	private String antecedentesRenales;
	
	private String antecedentesQuirurgicos;
	
	private String alergicos;
	
	private String antecedentesTransfusiones;
	
	private String medicamentos;
	
	private String alcoholismo;
	
	private String tabaquismo;
	
	private String inmunizaciones;
	
	private int numeroHistoria;
	
	private String enfermedadActual;
	
	private String medicamentosRecomendados;
	
	private String fecha;
	
	private String recomendaciones;
	
	@DocumentReference
	private citas citas;
	
	@DocumentReference
	private MedicoDocument medicos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UsuarioDocument getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDocument usuario) {
		this.usuario = usuario;
	}

	public String getMotivoDeLaConsulta() {
		return motivoDeLaConsulta;
	}

	public void setMotivoDeLaConsulta(String motivoDeLaConsulta) {
		this.motivoDeLaConsulta = motivoDeLaConsulta;
	}

	public String getAntecedentesCardiobasculares() {
		return antecedentesCardiobasculares;
	}

	public void setAntecedentesCardiobasculares(String antecedentesCardiobasculares) {
		this.antecedentesCardiobasculares = antecedentesCardiobasculares;
	}

	public String getAntecedentesPulmonares() {
		return antecedentesPulmonares;
	}

	public void setAntecedentesPulmonares(String antecedentesPulmonares) {
		this.antecedentesPulmonares = antecedentesPulmonares;
	}

	public String getAntecedentesDigestivos() {
		return antecedentesDigestivos;
	}

	public void setAntecedentesDigestivos(String antecedentesDigestivos) {
		this.antecedentesDigestivos = antecedentesDigestivos;
	}

	public String getAntecedentesDiabetes() {
		return antecedentesDiabetes;
	}

	public void setAntecedentesDiabetes(String antecedentesDiabetes) {
		this.antecedentesDiabetes = antecedentesDiabetes;
	}

	public String getAntecedentesRenales() {
		return antecedentesRenales;
	}

	public void setAntecedentesRenales(String antecedentesRenales) {
		this.antecedentesRenales = antecedentesRenales;
	}

	public String getAntecedentesQuirurgicos() {
		return antecedentesQuirurgicos;
	}

	public void setAntecedentesQuirurgicos(String antecedentesQuirurgicos) {
		this.antecedentesQuirurgicos = antecedentesQuirurgicos;
	}

	public String getAlergicos() {
		return alergicos;
	}

	public void setAlergicos(String alergicos) {
		this.alergicos = alergicos;
	}

	public String getAntecedentesTransfusiones() {
		return antecedentesTransfusiones;
	}

	public void setAntecedentesTransfusiones(String antecedentesTransfusiones) {
		this.antecedentesTransfusiones = antecedentesTransfusiones;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getAlcoholismo() {
		return alcoholismo;
	}

	public void setAlcoholismo(String alcoholismo) {
		this.alcoholismo = alcoholismo;
	}

	public String getTabaquismo() {
		return tabaquismo;
	}

	public void setTabaquismo(String tabaquismo) {
		this.tabaquismo = tabaquismo;
	}

	public String getInmunizaciones() {
		return inmunizaciones;
	}

	public void setInmunizaciones(String inmunizaciones) {
		this.inmunizaciones = inmunizaciones;
	}

	public int getNumeroHistoria() {
		return numeroHistoria;
	}

	public void setNumeroHistoria(int numeroHistoria) {
		this.numeroHistoria = numeroHistoria;
	}

	public String getEnfermedadActual() {
		return enfermedadActual;
	}

	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}

	public String getMedicamentosRecomendados() {
		return medicamentosRecomendados;
	}

	public void setMedicamentosRecomendados(String medicamentosRecomendados) {
		this.medicamentosRecomendados = medicamentosRecomendados;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public citas getCitas() {
		return citas;
	}

	public void setCitas(citas citas) {
		this.citas = citas;
	}

	public MedicoDocument getMedicos() {
		return medicos;
	}

	public void setMedicos(MedicoDocument medicos) {
		this.medicos = medicos;
	}
}
