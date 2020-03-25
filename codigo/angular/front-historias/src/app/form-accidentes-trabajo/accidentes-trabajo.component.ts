import { Component, OnInit,Output, EventEmitter } from '@angular/core';
import { AntecedentesTrabajo } from '../DatosBean/antecedentesTrabajo';
import { LabelService } from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-accidentes-trabajo',
  templateUrl: './accidentes-trabajo.component.html',
  styleUrls: ['./accidentes-trabajo.component.css']
})
export class AccidentesTrabajoComponent implements OnInit {

  antecedentesTrabajo: AntecedentesTrabajo;
  datosSingleton: DatosSingleton;
  date = new FormControl(new Date());
  @Output() messageEvent = new EventEmitter<AntecedentesTrabajo>()
  constructor(private labelService: LabelService) { }

  ngOnInit(): void {
    this.antecedentesTrabajo = new AntecedentesTrabajo;
    this.onLabels();
  }

  guardarDatosGrillas():void{
    debugger
    this.messageEvent.emit(this.antecedentesTrabajo);
  }

  onLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }

}
