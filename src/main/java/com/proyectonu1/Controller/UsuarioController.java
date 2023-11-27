package com.proyectonu1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.UsuarioDocument;
import com.proyectonu1.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@GetMapping("/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("usuario", UsuarioRepository.findAll());
        return "Homeusuario";
    }

    @GetMapping("/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("usuario", new UsuarioDocument());
        return "Formulario-usuario";
    }

    @GetMapping("/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("usuario", UsuarioRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "Formulario-usuario";
    }

    @PostMapping("/save")
    public String equiposSaveProcess(@ModelAttribute("usuario") UsuarioDocument usuario) {
        if (usuario.getId().isEmpty()) {
            usuario.setId(null);
        }
        UsuarioRepository.save(usuario);
        return "redirect:/usuario/";
    }

    @GetMapping("/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        UsuarioRepository.deleteById(id);
        return "redirect:/usuario/";
    }
}