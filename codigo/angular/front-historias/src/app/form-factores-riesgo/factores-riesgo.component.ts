import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FactoresRiesgo } from '../DatosBean/factoresRiesgo';
import { LabelService } from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
@Component({
  selector: 'app-factores-riesgo',
  templateUrl: './factores-riesgo.component.html',
  styleUrls: ['./factores-riesgo.component.css']
})
export class FactoresRiesgoComponent implements OnInit {
  factoresRiesgo: FactoresRiesgo;
  datosSingleton: DatosSingleton;
  @Output() messageEvent = new EventEmitter<FactoresRiesgo>();
  constructor(private labelService: LabelService) { }

  ngOnInit(): void {
    this.factoresRiesgo = new FactoresRiesgo();
    this.onLabels();
  }

  guardarDatosGrillas(): void {
    this.messageEvent.emit(this.factoresRiesgo);
  }

  onLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta;
        console.log(respuesta);
      }
    );
  }
}
