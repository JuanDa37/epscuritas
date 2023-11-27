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
import com.proyectonu1.app.entidades.MedicoDocument;
import com.proyectonu1.repository.MedicoRepository;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {
	
	@Autowired
	private MedicoRepository MedicoRepository;
	
	@GetMapping("/")
    public List<MedicoDocument> getAllEquipos() {
        return MedicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public MedicoDocument getEquipoById(@PathVariable String id) {
        return MedicoRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public MedicoDocument saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        MedicoDocument medico = mapper.convertValue(body, MedicoDocument.class);
        return MedicoRepository.save(medico);
    }

    @PutMapping("/{id}")
    public MedicoDocument updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        MedicoDocument medico = mapper.convertValue(body, MedicoDocument.class);
        medico.setId(id);
        return MedicoRepository.save(medico);
    }

    @DeleteMapping("/{id}")
    public MedicoDocument deleteEquipo(@PathVariable String id) {
        MedicoDocument medico = MedicoRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        MedicoRepository.deleteById(id);
        return medico;
    }
}