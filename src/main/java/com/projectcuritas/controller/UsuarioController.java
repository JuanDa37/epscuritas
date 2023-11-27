package com.projectcuritas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projectcuritas.document.UsuarioDocument;
import com.projectcuritas.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	private UsuarioRepository UsuarioRepository;
	
	@PostMapping("/usuario")
	public UsuarioDocument save(@RequestBody UsuarioDocument usuariodocumet) {
		return UsuarioRepository.save(usuariodocumet);
	}
	
	@GetMapping("/usuario")
	public List<UsuarioDocument> saveAll() {
		return (List<UsuarioDocument>)UsuarioRepository.findAll();
	}

}
