package com.proyectonu1.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectonu1.Exception.Exception;
import com.proyectonu1.app.entidades.MedicoDocument;
import com.proyectonu1.app.entidades.UsuarioDocument;
import com.proyectonu1.app.entidades.citas;
import com.proyectonu1.app.entidades.historiaClinica;
import com.proyectonu1.repository.citasRepository;
import jakarta.servlet.http.HttpSession;
import com.proyectonu1.repository.MedicoRepository;
import com.proyectonu1.repository.historiaClinicaRepository;

@Controller
@RequestMapping("")
public class citasTemplates {
	
	@Autowired
	private citasRepository citasRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private historiaClinicaRepository historiaClinicaRepository;
	
	@GetMapping("/mismedicos")
    public String equiposListTemplate(Model model) {
        model.addAttribute("medico", medicoRepository.findAll());
        return "mismedicos";
    }

	@GetMapping("/citas/new")
	public String equiposNewTemplate(Model model, HttpSession sesion) {
	    model.addAttribute("citas", new citas());
	    List<MedicoDocument> medicoDocument = medicoRepository.findAll();
	    model.addAttribute("medico", medicoDocument);
	    return "formulario-citas";
	}

	@GetMapping("/historiaClinica/new/{citaId}")
	public String mostrarFormularioHistoriaClinica2(@PathVariable String citaId, Model model) {	
		Optional<citas> citas = citasRepository.findById(citaId);
		if(citas.isPresent()) {
			citas cita = citas.get();
			historiaClinica historiaClinica = new historiaClinica();
			historiaClinica.setUsuario(cita.getUsuarios());
			historiaClinica.setMedicos(cita.getMedico());
			model.addAttribute("cita", cita);	
			model.addAttribute("historiaClinica", historiaClinica);
			return "formulario-historiaClinica";
		}else {
			return "redirect:/miscitasmedico";
		}
	}

    @GetMapping("/citas/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("citas", citasRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "formulario-citas";
    }

    @PostMapping("/citas/save")
    public String equiposSaveProcess(@ModelAttribute("citas") citas citas, HttpSession sesion) {
        UsuarioDocument UsuarioDocument = (UsuarioDocument) sesion.getAttribute("usuario");
    	if(sesion.getAttribute("usuario") == null){
        	return "redirect:/loginUsuario";
        }
    	if(UsuarioDocument != null) {
    		if (citas.getId().isEmpty()) {
                citas.setId(null);
                citas.setUsuarios(UsuarioDocument);
                citasRepository.save(citas);
            } else {
                citasRepository.save(citas);
            }
    	}
    	return "redirect:/miscitas";
    }

    @GetMapping("/citas/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        citasRepository.deleteById(id);
        return "redirect:/miscitas";
    }
    
    @GetMapping("/citasmed/delete/{id}")
    public String equipoDeleteProcess2(@PathVariable("id") String id) {
        citasRepository.deleteById(id);
        return "redirect:/miscitasmedico";
    }
    
    @GetMapping("/miscitas")
    public String equipoListTemplate(HttpSession session, Model model) {
    	UsuarioDocument usuario = (UsuarioDocument) session.getAttribute("usuario");
    	if(usuario == null) {
    		return "redirect:/login-usuario";
    	}  	
    	List<citas> citasDelUsuario = citasRepository.findByUsuarios(usuario);
    	model.addAttribute("citas", citasDelUsuario);
    	return "miscitas";
    }
    
    @GetMapping("/historiaClinicaUsuario")
    public String equipoLitstTemplate3(HttpSession session, Model model) {
    	UsuarioDocument usuario = (UsuarioDocument) session.getAttribute("usuario");
    	if(usuario == null) {
    		return "redirect:/login-usuario";
    	}
    	List<historiaClinica> historiaClinica = historiaClinicaRepository.findByUsuario(usuario);
    	model.addAttribute("historiaClinica", historiaClinica);
    	return "miHistoriaClinica";
    }

    @PostMapping("/historiaClinica/save")
    public String historiaClinicaSaveProcess(@ModelAttribute("historiaClinica") historiaClinica historiaClinica, @ModelAttribute("citas") citas citas ) {
    	historiaClinica.setCitas(citas);
    	historiaClinicaRepository.save(historiaClinica);
    	return "redirect:/miscitasmedico";
    }
    
    @GetMapping("/miscitasmedico")
    public String equipoListTemplateM(HttpSession session, Model model) {
    	MedicoDocument medico = (MedicoDocument) session.getAttribute("medico");
    	
    	if(medico == null) {
    		return "redirect:/login-medico";
    	}  	
    	List<citas> citasDelMedico = citasRepository.findByMedico(medico);
    	model.addAttribute("citas", citasDelMedico);
    	
    	Set<historiaClinica> historiasClinicasDelMedico = new HashSet<>();
        for (citas cita : citasDelMedico) {
            UsuarioDocument usuarioDeCita = cita.getUsuarios();
            List<historiaClinica> historiasClinicasDeUsuario = historiaClinicaRepository.findByUsuario(usuarioDeCita);
            historiasClinicasDelMedico.addAll(historiasClinicasDeUsuario);
        }

        model.addAttribute("historiaClinica", new ArrayList<>(historiasClinicasDelMedico));
    	return "miscitasmedico";
    }
}