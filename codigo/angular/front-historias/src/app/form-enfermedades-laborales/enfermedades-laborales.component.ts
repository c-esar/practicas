import { Component, OnInit,Output, EventEmitter } from '@angular/core';
import { EnfermedadesLaboral } from '../DatosBean/enfermedadesLaboral';
import { LabelService } from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { FormControl } from '@angular/forms';
@Component({
  selector: 'app-enfermedades-laborales',
  templateUrl: './enfermedades-laborales.component.html',
  styleUrls: ['./enfermedades-laborales.component.css']
})
export class EnfermedadesLaboralesComponent implements OnInit {
  enfermedadesLaboral: EnfermedadesLaboral;
  datosSingleton: DatosSingleton;
  date = new FormControl(new Date());
  @Output() messageEvent = new EventEmitter<EnfermedadesLaboral>()
  constructor(private labelService: LabelService) { }

  ngOnInit(): void {
    this.enfermedadesLaboral = new EnfermedadesLaboral;
    this.onLabels();
  }

  guardarDatosGrillas():void{
    this.messageEvent.emit(this.enfermedadesLaboral);
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
