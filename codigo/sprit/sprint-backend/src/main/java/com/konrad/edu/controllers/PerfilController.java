package com.konrad.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;
import com.konrad.edu.IService.IPerfilService;
import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.PerfilEntity;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/login")
public class PerfilController {

	@Autowired
	private IPerfilService perfilService;

	@GetMapping("/sesion/{nomUsuario}/{pass}")
	public ResponseEntity<PerfilEntity> RecibirSesion(@PathVariable("nomUsuario") String nom_usuario,
			@PathVariable("pass") String password) {
		System.out.println("entre" + nom_usuario + password);
		PerfilEntity p = perfilService.getSession(nom_usuario, password);
		System.out.println(p.toString());
		if (p != null && p.getEstado() != null && p.getEstado().equalsIgnoreCase("a")) {
			System.out.println("entre activo");
			p.setEstado(IConstantes.ESTADO_SESION_ACTIVO);
			return ResponseEntity.ok().body(p);
		} else {
			System.out.println("entre inactivo");
			p.setEstado(IConstantes.ESTADO_SESION_INACTIVO);
			return ResponseEntity.ok().body(p);
		}
	}

	@GetMapping("/labels")
	public LabelConstantes getLabels() {
		LabelConstantes tmp = perfilService.getLabels();
		System.out.println(tmp.toString());
		return tmp;
	}
}
