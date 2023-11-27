package com.proyectonu1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.eps;
import com.proyectonu1.repository.epsRepository;

@Controller
public class epsTemplates {
	
	@Autowired
	private epsRepository epsRepository;
	
	@GetMapping("/eps/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("eps", epsRepository.findAll());
        return "lista-eps";
    }
	
	@GetMapping("/eps/usuario")
    public String epsListTemplate(Model model) {
        model.addAttribute("eps", epsRepository.findAll());
        return "info-eps";
    }
	
	@GetMapping("/eps/medico")
    public String epsListTemplate2(Model model) {
        model.addAttribute("eps", epsRepository.findAll());
        return "infom-eps";
    }

    @GetMapping("/eps/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("eps", new eps());
        return "formulario-eps";
    }

    @GetMapping("/eps/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("eps", epsRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-eps";
    }

    @PostMapping("/eps/save")
    public String equiposSaveProcess(@ModelAttribute("eps") eps eps) {
        if (eps.getId().isEmpty()) {
            eps.setId(null);
        }
        epsRepository.save(eps);
        return "redirect:/eps/";
    }

    @GetMapping("/eps/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        epsRepository.deleteById(id);
        return "redirect:/eps/";
    }
}