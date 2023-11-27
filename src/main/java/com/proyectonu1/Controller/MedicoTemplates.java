package com.proyectonu1.Controller;

import java.util.List;
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
import com.proyectonu1.app.entidades.MedicoDocument;
import com.proyectonu1.app.entidades.eps;
import com.proyectonu1.repository.MedicoRepository;

import jakarta.servlet.http.HttpSession;
import com.proyectonu1.repository.epsRepository;

@Controller
public class MedicoTemplates {
	
	@Autowired
	private MedicoRepository MedicoRepository;
	
	@Autowired
	private epsRepository epsRepository;
	
	@GetMapping("/medico/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("medico", MedicoRepository.findAll());
        return "lista-medico";
    }
	
	@GetMapping("/loginMedico")
	public String entrarlogin(Model model) {
	    model.addAttribute("medico", new MedicoDocument()); 
	    return "login-medico";
	}
	
	@GetMapping("/calendarioMedico")
	public String calendarioMed(Model model) {
	    return "calendario";
	}
	
	@PostMapping("/loginMedico")
	public String ingresarlogin(@RequestParam String usuario, @RequestParam String contrasena, HttpSession sesion, Model model) {
		Optional<MedicoDocument> medicoOptional = MedicoRepository.findByUsuarioAndContrasena(usuario, contrasena);
		if (medicoOptional.isPresent()) {
		    MedicoDocument medico = medicoOptional.get();
		    sesion.setAttribute("medico", medico);
		    return "redirect:/homeMedico";
		}
		model.addAttribute("medico", new MedicoDocument());
		model.addAttribute("errorCredenciales", true);
		return "login-medico";
	}

    @GetMapping("/medico/new")
    public String equiposNewTemplate(Model model) {
    	List<eps> eps = epsRepository.findAll();
		model.addAttribute("eps", eps);
        model.addAttribute("medico", new MedicoDocument());
        return "formulario-medico";
    }

    @GetMapping("/medico/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
    	List<eps> eps = epsRepository.findAll();
    	model.addAttribute("eps", eps);
        model.addAttribute("medico", MedicoRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-medico";
    }

    @PostMapping("/medico/save")
    public String equiposSaveProcess(@ModelAttribute("medico") MedicoDocument  medico) {
        if (medico.getId().isEmpty()) {
            medico.setId(null);
        }
        MedicoRepository.save(medico);
        return "redirect:/medico/";
    }

    @GetMapping("/medico/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        MedicoRepository.deleteById(id);
        return "redirect:/medico/";
    }
    
    @GetMapping("/homeMedico")
    public String mostrarInicio(HttpSession session, Model model) {
        MedicoDocument medico = (MedicoDocument) session.getAttribute("medico");
        if (medico != null) {
        	 model.addAttribute("medico", medico);
        	 model.addAttribute("nombreUsuario",medico.getNombre()); 
        	 model.addAttribute("apellidoUsuario",medico.getApellido());
            return "homeMedico";
        } else {
            return "redirect:/login-medico";
        }
    }
    
    @GetMapping("/vermisdatosmedico")
    public String mostrarMisDatos(HttpSession session, Model model) {
        MedicoDocument medico = (MedicoDocument) session.getAttribute("medico");
        if (medico != null) {
            model.addAttribute("medico", medico);
            return "datosmedico";
        } else {
            return "redirect:/login-medico";
        }
    }
    
    @PostMapping("/vermisdatosmedico")
    public String actualizarMisDatos(@ModelAttribute MedicoDocument medico, HttpSession session) {
    	MedicoRepository.save(medico);
        session.setAttribute("medico", medico); 
        return "redirect:/vermisdatosmedico";
    }
}