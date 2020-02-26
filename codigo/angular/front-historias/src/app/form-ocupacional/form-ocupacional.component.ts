import { ElementRef, ViewChild, Component, OnInit } from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { Aseguradora } from '../DatosBean/aseguradora';
import {Router} from '@angular/router';
declare var jQuery: any;
declare var $: any;
@Component({
  selector: 'app-form-ocupacional',
  templateUrl: './form-ocupacional.component.html',
  styleUrls: ['./form-ocupacional.component.css']
})
export class FormOcupacionalComponent implements OnInit {

  persona: Persona;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];


  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router:Router,) {
    this.persona = new Persona();

   }

  ngOnInit(): void {
    this.activarLabels();
    this.activar("DatosPricipales");
    this.obtenerTipoDocumento();
    this.obtenerCiudad();
    this.obtenerAseguradora();
  }

  private activarLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }
  private obtenerTipoDocumento():void{
    this.personaService.getTipoDocumento().subscribe(
      (respuesta) => {
        this.tipoDocumento = respuesta
        console.log(respuesta)
      }
    )
  }

  private obtenerCiudad():void{
    this.personaService.getCiudad().subscribe(
      (respuesta) => {
        this.ciudad = respuesta
        console.log(respuesta)
      }
    )
  }

  private obtenerAseguradora():void{
    this.personaService.getAseguradora().subscribe(
      (respuesta) => {
        this.aseguradora = respuesta
        console.log(respuesta)
      }
    )
  }

  public activar(id: String) {
    var menues = $(".nav-link");
    menues.removeClass("active");
    menues.removeClass("btn-primary");
    menues.css("color", "black");
    $('#' + id).addClass("active");
    $('#' + id).addClass("btn-primary");
    $('#' + id).css("color", "#fff");
  }

  public create():void{
    this.persona.localidad.seqLocalidad = 0;
    this.persona.lugarDeResidencia.seqCuidad = 0;
    console.log(this.persona)
    this.personaService.create(this.persona).subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/menuPrincipal'])
      }
    );
  }

}
