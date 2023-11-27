package com.proyectonu1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.historiaClinica;
import com.proyectonu1.repository.historiaClinicaRepository;

public class historiaClinicaTemplates {
	
	@Autowired
	private historiaClinicaRepository historiaClinicaRepository;
	
	@GetMapping("/historiaClinica/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("historiaClinica", historiaClinicaRepository.findAll());
        return "lista-historiaClinica";
    }

    @GetMapping("/historiaClinica/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("historiaClinica", historiaClinicaRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-historiaClinica";
    }

    @PostMapping("/historiaClinica/save")
    public String equiposSaveProcess(@ModelAttribute("historiaClinica") historiaClinica historiaClinica) {
        if (historiaClinica.getId().isEmpty()) {
            historiaClinica.setId(null);
        }
        historiaClinicaRepository.save(historiaClinica);
        return "redirect:/historiaClinica/";
    }

    @GetMapping("/historiaClinica/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        historiaClinicaRepository.deleteById(id);
        return "redirect:/historiaClinica/";
    }
}