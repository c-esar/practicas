import { Component, OnInit } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { PersonaService } from '../Servicios/persona.service';
@Component({
  selector: 'app-lista-personas',
  templateUrl: './lista-personas.component.html',
  styleUrls: ['./lista-personas.component.css']
})
export class ListaPersonasComponent implements OnInit {

personas: Persona[];

  constructor(private personaService: PersonaService) { }

  ngOnInit(): void {
    this.personaService.getPersonas().subscribe(
      personas => this.personas = personas
    );
  }

}
