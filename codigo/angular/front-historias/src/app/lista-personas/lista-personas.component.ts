import { Component, OnInit } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { PersonaService } from '../Servicios/persona.service';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { Permiso } from '../DatosBean/permiso';
@Component({
  selector: 'app-lista-personas',
  templateUrl: './lista-personas.component.html',
  styleUrls: ['./lista-personas.component.css']
})
export class ListaPersonasComponent implements OnInit {

  personas: Persona[];


  constructor(private personaService: PersonaService,
    private labelService: LabelService,
      private loginService: LoginService) { }

  ngOnInit(): void {
    this.personaService.getPersonas().subscribe(
      personas => this.personas = personas
    );

  }
}
