import {ElementRef, ViewChild, Component, OnInit } from '@angular/core';
import {LabelService} from '../Servicios/label.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
declare var jQuery:any;
declare var $:any;
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
    this.activar("DatosPricipales");
  }

  public activar(id: String)
  {
    var menues = $(".nav-link");
    menues.removeClass("active");
    menues.removeClass("btn-primary");
    menues.css("color", "black");
    $('#'+id).addClass("active");
    $('#'+id).addClass("btn-primary");
    $('#'+id).css("color", "#fff");
  }

}
