import { ElementRef, ViewChild, Component, OnInit, Input} from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { Aseguradora } from '../DatosBean/aseguradora';
import { Router } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import Swal from 'sweetalert2';
declare var jQuery: any;
declare var $: any;
@Component({
  selector: 'app-form-ocupacional',
  templateUrl: './form-ocupacional.component.html',
  styleUrls: ['./form-ocupacional.component.css']
})
export class FormOcupacionalComponent implements OnInit {

  persona: Persona;
  Spersona: Persona;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];
  datosPersonales: boolean;
  datosHistoriaLaboral: boolean;
  constante: number;
  tablaCondicionesTrabajo: Array<Permiso>;
  tmp:string;
  medico:boolean;
  aux:boolean;
  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router) {
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.datosSingleton = new DatosSingleton();
    this.tablaCondicionesTrabajo = new Array<Permiso>();
    this.tablaCondicionesTrabajo.push(new Permiso);
    this.Spersona = new Persona();
  }

  ngOnInit(): void {
    this.constante = 2;
    this.activarLabels();
    this.obtenerPermisos();
    this.activar("DatosPricipales");
    this.obtenerTipoDocumento();
    this.obtenerCiudad();
    this.obtenerAseguradora();
    this.getAuxOMedico();
  }

  private activarLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }
  private obtenerTipoDocumento(): void {
    this.personaService.getTipoDocumento().subscribe(
      (respuesta) => {
        this.tipoDocumento = respuesta
        console.log(respuesta)
      }
    )
  }

  private obtenerCiudad(): void {
    this.personaService.getCiudad().subscribe(
      (respuesta) => {
        this.ciudad = respuesta
        console.log(respuesta)
      }
    )
  }

  private obtenerAseguradora(): void {
    this.personaService.getAseguradora().subscribe(
      (respuesta) => {
        this.aseguradora = respuesta
        console.log(respuesta)
      }
    )
  }

  private obtenerPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos.crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos.crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos.gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos.descargar;
    console.log(this.permiso.crearAux);
  }

  public onValidatePersona():void{
    this.personaService.onBuscarDocumento(this.persona).subscribe(
      respuesta => {
        debugger
        if(respuesta == null || respuesta.nomPrimerNombre == null){
          Swal.fire('Error', 'Persona No Registrada', 'error');
        }else{
          this.Spersona = respuesta
        }
      }
    );
    console

  }
  private getAuxOMedico():void{
    console.log("permiso"+this.permiso.crearUsuario);
    if (this.permiso.crearUsuario == 0) {
      if (this.permiso.crearAux == 1) {
        this.aux = true;
      }
    } else if (this.permiso.crearUsuario == 1) {
      this.medico = true;
    }
  }

  public activar(id: String) {
    var menues = $(".nav-link");
    menues.removeClass("active");
    menues.removeClass("disabled");
    menues.removeClass("btn-primary");
    menues.removeAttr("style");
    menues.css("color", "black");
    switch (id) {
      case "DatosPricipales": {
        if (this.permiso.crearUsuario == 0) {
          if (this.permiso.crearAux == 1) {
            this.activarSubMenu(id);
            $('#DatosHistoriaLaboral').addClass("disabled");
          }
        } else if (this.permiso.crearUsuario == 1) {
          this.activarSubMenu(id);
        }
        this.datosPersonales = true;
        this.datosHistoriaLaboral = false;
        break;
      }
      case "DatosHistoriaLaboral": {
          this.activarSubMenu(id);
          this.datosPersonales = false;
          this.datosHistoriaLaboral = true;
        break;
      }
      default: {
        //statements;
        break;
      }
    }
  }

  private activarSubMenu(id: String): void {
    console.log("activar sub menu");
    $('#' + id).removeAttr("style");
    $('#' + id).addClass("active");
    $('#' + id).addClass("btn-primary");
    $('#' + id).css("color", "#fff");
    $('#' + id).css("background-color", "#007bff")
  }

  public agregarElemento(): void {
    this.constante = this.constante + 1;
    var numero = this.constante;
    $(".table tbody").prepend(function(n) {
      return "<tr>"
        + "<td><input type='text' [(ngModel)]='tablaAtributo" + numero + "' /></td>"
        + "<td><input type='text' /></td>"
        + "<td><input type='text' /></td>"
        + "</tr> ";
    });
    console.log(this.tablaCondicionesTrabajo[0].crearAux);
  }
  public create(): void {
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
