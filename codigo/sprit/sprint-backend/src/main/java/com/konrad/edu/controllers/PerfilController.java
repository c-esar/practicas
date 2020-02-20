package com.konrad.edu.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.entity.IConstantes;
import com.konrad.edu.entity.LabelConstantes;
import com.konrad.edu.entity.Perfil;
import com.konrad.edu.service.IPerfilService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/login")
public class PerfilController {

	@Autowired
	private IPerfilService perfilService;
	
	@GetMapping("/sesion/{nomUsuario}/{pass}")
	public Perfil RecibirSesion(@PathVariable("nomUsuario") String nom_usuario, @PathVariable("pass") String password){
		System.out.println("entre"+ nom_usuario + password);
		Perfil p = perfilService.getSession(nom_usuario, password);
		System.out.println(p.toString());
		if(p != null && p.getEstado() != null && p.getEstado().equalsIgnoreCase("activo")) {
			System.out.println("entre activo");
			p.setEstado(IConstantes.ESTADOSESIONACTIVO);
			return p;
		}else{
			System.out.println("entre inactivo");
			p.setEstado(IConstantes.ESTADOSESIONINACTIVO);
			return p;
		}	
	}
	
	@GetMapping("/labels")
	public LabelConstantes getLabels(){
		LabelConstantes tmp = perfilService.getLabels();
		System.out.println(tmp.toString());
		return tmp;
	}
}
