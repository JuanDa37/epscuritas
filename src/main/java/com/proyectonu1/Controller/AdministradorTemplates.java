package com.proyectonu1.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.proyectonu1.app.entidades.AdminstradorDocument;
import jakarta.servlet.http.HttpSession;
import com.proyectonu1.repository.AdministradorRepository;

@Controller
public class AdministradorTemplates {
	
	@Autowired
	private AdministradorRepository AdministradorRepository;
	
	@GetMapping("/administrador/")
    public String equiposListTemplate(Model model) {
        model.addAttribute("administrador", AdministradorRepository.findAll());
        return "lista-administrador";
    }

    @GetMapping("/administrador/new")
    public String equiposNewTemplate(Model model) {
        model.addAttribute("administrador", new AdminstradorDocument());
        return "Formulario-administrador";
    }
    
    @GetMapping("/loginAdministrador")
	public String entrarlogin(Model model) {
	    model.addAttribute("administrador", new AdminstradorDocument()); // Agrega un objeto coordinador vacío al modelo
	    return "login-administrador";
	}
    
    public class AdminSession {   /*Paso 1*/
        private AdminstradorDocument administrador;

        public AdminstradorDocument getAdministrador() {
            return administrador;
        }

        public void setAdministrador(AdminstradorDocument administrador) {
            this.administrador = administrador;
        }
    }

    @PostMapping("/loginAdministrador")   /*Paso 2*/
    public String ingresarlogin(@RequestParam String usuario, @RequestParam String contrasena, HttpSession session, Model model) {
        Optional<AdminstradorDocument> administradorOptional = AdministradorRepository.findByUsuarioAndContrasena(usuario, contrasena);
        if (administradorOptional.isPresent()) {
            AdminSession adminSession = new AdminSession();
            adminSession.setAdministrador(administradorOptional.get());
            session.setAttribute("adminSession", adminSession);
            return "redirect:/homeAdministrador/";
        }
        model.addAttribute("adminSession", new AdminSession());
        model.addAttribute("errorCredenciales", true);
        return "login-administrador";
    }

    @GetMapping("/administrador/edit/{id}")
    public String equipoEditTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("administrador", AdministradorRepository.findById(id).orElseThrow(() -> new Exception("Equipo no encontrado")));
        return "Formulario-administrador";
    }

    @PostMapping("/administrador/save")
    public String equiposSaveProcess(@ModelAttribute("administrador") AdminstradorDocument administrador) {
        if (administrador.getId().isEmpty()) {
            administrador.setId(null);
        }
        AdministradorRepository.save(administrador);
        return "redirect:/administrador/";
    }

    @GetMapping("/administrador/delete/{id}")
    public String equipoDeleteProcess(@PathVariable("id") String id) {
        AdministradorRepository.deleteById(id);
        return "redirect:/administrador/";
    }
    
    @GetMapping("/homeAdministrador/")   /* /*Paso 3*/
    public String mostrarInicio(HttpSession session, Model model) {   
        AdminSession adminSession = (AdminSession) session.getAttribute("adminSession");
        if (adminSession != null && adminSession.getAdministrador() != null) {
            AdminstradorDocument administrador = adminSession.getAdministrador();
            model.addAttribute("nombreAdministrador", administrador.getNombre()); 
            model.addAttribute("apellidoAdministrador", administrador.getApellido()); 
            return "homeAdministrador";
        } else {
            return "redirect:/loginAdministrador";
        }
    }
    
    @GetMapping("/vermisdatosAdmin")
    public String mostrarMisDatos(HttpSession session, Model model) {
    	AdminSession adminSession = (AdminSession) session.getAttribute("adminSession");
        if (adminSession != null && adminSession.getAdministrador() != null) {
            AdminstradorDocument administrador = adminSession.getAdministrador();
            model.addAttribute("administrador", administrador);
            return "datosadministrador";
        } else {
            return "redirect:/loginAdministrador";
        }
    }
    
    @PostMapping("/actualizarMisDatosAdmin")
    public String actualizarMisDatos(@ModelAttribute AdminstradorDocument administrador, HttpSession session) {
        AdminSession adminSession = (AdminSession) session.getAttribute("adminSession");
        if (adminSession != null && adminSession.getAdministrador() != null) {
            AdminstradorDocument administradorActual = adminSession.getAdministrador();
            // Actualiza los campos relevantes con los nuevos valores
            administradorActual.setNombre(administrador.getNombre());
            administradorActual.setApellido(administrador.getApellido());
            administradorActual.setUsuario(administrador.getUsuario());
            administradorActual.setContrasena(administrador.getContrasena());
            // Agrega más campos según tus necesidades

            // Guarda los cambios en la base de datos
            AdministradorRepository.save(administradorActual);

            // Actualiza el objeto de sesión con los datos actualizados
            adminSession.setAdministrador(administradorActual);
            session.setAttribute("adminSession", adminSession);

            return "redirect:/vermisdatosAdmin";
        } else {
            return "redirect:/loginAdministrador";
        }
    }

    
    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.removeAttribute("administrador");
        return "redirect:/loginAdministrador";
    }
    
    @GetMapping("/mostrarFecha")
    public LocalDate mostrarFecha(Model model) {
    	LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        System.out.println("La fecha actual es: " + now.format(formatter));
        return now;
    }
}