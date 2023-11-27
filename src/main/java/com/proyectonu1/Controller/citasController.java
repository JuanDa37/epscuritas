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
import com.proyectonu1.app.entidades.citas;
import com.proyectonu1.repository.citasRepository;

@RestController
@RequestMapping("/api/citas")
public class citasController {
	
	@Autowired
	private citasRepository citasRepository;
	
	@GetMapping("/")
    public List<citas> getAllEquipos() {
        return citasRepository.findAll();
    }

    @GetMapping("/{id}")
    public citas getEquipoById(@PathVariable String id) {
        return citasRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public citas saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        citas citas = mapper.convertValue(body, citas.class);
        return citasRepository.save(citas);
    }

    @PutMapping("/{id}")
    public citas updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        citas citas = mapper.convertValue(body, citas.class);
        citas.setId(id);
        return citasRepository.save(citas);
    }

    @DeleteMapping("/{id}")
    public citas deleteEquipo(@PathVariable String id) {
        citas citas = citasRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        citasRepository.deleteById(id);
        return citas;
    }
}