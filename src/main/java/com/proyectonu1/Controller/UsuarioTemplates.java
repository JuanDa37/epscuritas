package com.proyectonu1.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.UsuarioDocument;
import com.proyectonu1.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioTemplates {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/usuario/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("usuario", UsuarioRepository.findAll());
        return "lista-usuario";
    }
	
	@GetMapping("/loginUsuario")
	public String entrarlogin(Model model) {
	    model.addAttribute("usuario", new UsuarioDocument()); 
	    return "login-usuario";
	}
	
	@PostMapping("/loginUsuario")
	public String ingresarlogin(@RequestParam String usuario, @RequestParam String contrasena, HttpSession sesion, Model model) {
		Optional<UsuarioDocument> usuarioOptinal = UsuarioRepository.findByUsuarioAndContrasena(usuario, contrasena);
		if (usuarioOptinal.isPresent()) {
		    UsuarioDocument usuarios = usuarioOptinal.get();
		    sesion.setAttribute("usuario", usuarios);
		    return "redirect:/homeUsuario";
		}
		model.addAttribute("usuario", new UsuarioDocument());
		model.addAttribute("errorCredenciales", true);
		return "login-usuario";
	}

    @GetMapping("/usuario/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("usuario", new UsuarioDocument());
        return "formulario-usuario";
    }

    @GetMapping("/usuario/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("usuario", UsuarioRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-usuario";
    }

    @PostMapping("/usuario/save")
    public String equiposSaveProcess(@ModelAttribute("usuario") UsuarioDocument usuario) {
        if (usuario.getId().isEmpty()) {
            usuario.setId(null);
        }
        UsuarioRepository.save(usuario);
        return "redirect:/usuario/";
    }

    @GetMapping("/usuario/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        UsuarioRepository.deleteById(id);
        return "redirect:/usuario/";
    }
    
    @GetMapping("/homeUsuario") //<---------------------------------
    public String mostrarInicio(HttpSession session, Model model) {
        UsuarioDocument usuario = (UsuarioDocument) session.getAttribute("usuario");
        if (usuario != null) {
        	 model.addAttribute("usuario", usuario);
        	 model.addAttribute("nombreUsuario",usuario.getNombre()); 
        	 model.addAttribute("apellidoUsuario",usuario.getApellido()); 
            return "homeUsuario";
        } else {
            return "redirect:/login-suario";
        }
    }
    
    @GetMapping("/vermisdatos")
    public String mostrarMisDatos(HttpSession session, Model model) { //<---------------------------------
        UsuarioDocument usuario = (UsuarioDocument) session.getAttribute("usuario");
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "datosusuario";
        } else {
            return "redirect:/homeUsuario";
        }
    }
    
    @PostMapping("/vermisdatos")
    public String actualizarMisDatos(@ModelAttribute UsuarioDocument usuario, HttpSession session) {
    	UsuarioRepository.save(usuario); // Actualiza los datos
        session.setAttribute("usuario", usuario); // Actualiza la información de la sesión
        return "redirect:/vermisdatos";
    }
    
    @GetMapping("/cambio")
    public String mostrarFormCambioContrasena(HttpSession session, Model model) {
        UsuarioDocument usuario = (UsuarioDocument) session.getAttribute("usuario");
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "CambioUsuario"; // Nombre de la vista Thymeleaf
        } else {
            return "redirect:/homeUsuario";
        }
    }
}