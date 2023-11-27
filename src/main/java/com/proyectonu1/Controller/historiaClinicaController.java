package com.proyectonu1.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.historiaClinica;
import com.proyectonu1.repository.historiaClinicaRepository;

public class historiaClinicaController {
	
	@Autowired
	private historiaClinicaRepository historiaClinicaRepository;
	
	@GetMapping("/")
    public List<historiaClinica> getAllEquipos() {
        return historiaClinicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public historiaClinica getEquipoById(@PathVariable String id) {
        return historiaClinicaRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public historiaClinica saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        historiaClinica historiaClinica = mapper.convertValue(body, historiaClinica.class);
        return historiaClinicaRepository.save(historiaClinica);
    }

    @PutMapping("/{id}")
    public historiaClinica updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        historiaClinica historiaClinica = mapper.convertValue(body, historiaClinica.class);
        historiaClinica.setId(id);
        return historiaClinicaRepository.save(historiaClinica);
    }

    @DeleteMapping("/{id}")
    public historiaClinica deleteEquipo(@PathVariable String id) {
        historiaClinica historiaClinica = historiaClinicaRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        historiaClinicaRepository.deleteById(id);
        return historiaClinica;
    }
}