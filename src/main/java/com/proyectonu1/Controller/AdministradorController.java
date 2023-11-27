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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.AdminstradorDocument;
import com.proyectonu1.repository.AdministradorRepository;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
	
	@Autowired
	private AdministradorRepository AdministradorRepository;
	
	@GetMapping("/")
    public List<AdminstradorDocument> getAllEquipos() {
        return AdministradorRepository.findAll();
    }

    @GetMapping("/{id}")
    public AdminstradorDocument getEquipoById(@PathVariable String id) {
        return AdministradorRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public AdminstradorDocument saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        AdminstradorDocument administrador = mapper.convertValue(body, AdminstradorDocument.class);
        return AdministradorRepository.save(administrador);
    }

    @PutMapping("/{id}")
    public AdminstradorDocument updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        AdminstradorDocument administrador = mapper.convertValue(body, AdminstradorDocument.class);
        administrador.setId(id);
        return AdministradorRepository.save(administrador);
    }

    @DeleteMapping("/{id}")
    public AdminstradorDocument deleteEquipo(@PathVariable String id) {
        AdminstradorDocument administrador = AdministradorRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        AdministradorRepository.deleteById(id);
        return administrador;
    }

}
