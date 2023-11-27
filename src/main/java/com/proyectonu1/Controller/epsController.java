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
import com.proyectonu1.app.entidades.eps;
import com.proyectonu1.repository.epsRepository;

@RestController
@RequestMapping("/api/eps")
public class epsController {
	
	@Autowired
	private epsRepository epsRepository;
	
	@GetMapping("/")
    public List<eps> getAllEquipos() {
        return epsRepository.findAll();
    }

    @GetMapping("/{id}")
    public eps getEquipoById(@PathVariable String id) {
        return epsRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
    }

    @PostMapping("/")
    public eps saveEquipo(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        eps eps = mapper.convertValue(body, eps.class);
        return epsRepository.save(eps);
    }

    @PutMapping("/{id}")
    public eps updateEquipo(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        eps eps = mapper.convertValue(body, eps.class);
        eps.setId(id);
        return epsRepository.save(eps);
    }

    @DeleteMapping("/{id}")
    public eps deleteEquipo(@PathVariable String id) {
        eps eps = epsRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado"));
        epsRepository.deleteById(id);
        return eps;
    }
}