package com.konrad.edu.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konrad.edu.IService.IConstantes;

@CrossOrigin(origins = { IConstantes.RUTA })
@RestController
@RequestMapping("/listLocalidad")
public class localidadController {

}