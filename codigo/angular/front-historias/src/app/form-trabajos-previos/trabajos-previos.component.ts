import { Component, OnInit,Output, EventEmitter } from '@angular/core';
import { EmpresaLaboral } from '../DatosBean/empresaLaboral';
import { LabelService } from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-trabajos-previos',
  templateUrl: './trabajos-previos.component.html',
  styleUrls: ['./trabajos-previos.component.css']
})
export class TrabajosPreviosComponent implements OnInit {

  empresaLabora: EmpresaLaboral;
  datosSingleton: DatosSingleton;
  date = new FormControl(new Date());
  @Output() messageEvent = new EventEmitter<EmpresaLaboral>()
  constructor(private labelService: LabelService) { }

  ngOnInit(): void {
    this.empresaLabora = new EmpresaLaboral;
    this.onLabels();
  }

  guardarDatosGrillas():void{
    this.messageEvent.emit(this.empresaLabora);
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
