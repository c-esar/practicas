import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Paraclinicos } from '../DatosBean/paraclinicos';
import { LabelService } from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';

@Component({
  selector: 'app-form-paraclinicos',
  templateUrl: './form-paraclinicos.component.html',
  styleUrls: ['./form-paraclinicos.component.css']
})
export class FormParaclinicosComponent implements OnInit {

  paraclinicos: Paraclinicos;
  datosSingleton: DatosSingleton;
  @Output() messageEvent = new EventEmitter<Paraclinicos>();
  constructor(private labelService: LabelService) { }

  ngOnInit(): void {
    this.paraclinicos = new Paraclinicos();
    this.onLabels();
  }

  guardarDatosGrillas(): void {
    this.messageEvent.emit(this.paraclinicos);
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
