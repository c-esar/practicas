import {ElementRef, ViewChild, Component, OnInit } from '@angular/core';
import {LabelService} from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
@Component({
  selector: 'app-form-ocupacional',
  templateUrl: './form-ocupacional.component.html',
  styleUrls: ['./form-ocupacional.component.css']
})
export class FormOcupacionalComponent implements OnInit {
  @ViewChild('MyRef') element: ElementRef;
  constructor(private labelService: LabelService) { }
  datosSingleton: DatosSingleton;
  ngOnInit(): void {
    console.log(this.element);
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }

}
