import { ElementRef, ViewChild, Component, OnInit, Input } from '@angular/core';
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
import { EmpresaLaboral } from '../DatosBean/empresaLaboral';
import { AntecedentesTrabajo } from '../DatosBean/antecedentesTrabajo';
import { EnfermedadesLaboral } from '../DatosBean/enfermedadesLaboral';
import { FactoresRiesgo } from '../DatosBean/factoresRiesgo';

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
  buscoPerson: boolean;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];
  //boolean menu
  datosPersonales: boolean;
  datosHistoriaLaboral: boolean;
  datosTerceraFase: boolean;

  medico: boolean;
  aux: boolean;
  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router) {
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.buscoPerson = false;
  }

  ngOnInit(): void {
    this.activarLabels();
    this.obtenerPermisos();
    this.activar("DatosPricipales");
    this.obtenerTipoDocumento();
    this.obtenerCiudad();
    this.obtenerAseguradora();
    this.getAuxOMedico();
    this.cargarListas();
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

  public onValidatePersona(): void {
    this.personaService.onBuscarDocumento(this.persona).subscribe(
      respuesta => {
        debugger
        if (respuesta == null || respuesta.nomPrimerNombre == null) {
          this.Spersona = new Persona();
          Swal.fire('Error', 'Persona No Registrada', 'error');
        } else {
          this.Spersona = respuesta
          this.buscoPerson = true;
        }
      }
    );
    console

  }
  private getAuxOMedico(): void {
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
        this.datosTerceraFase = false;
        break;
      }
      case "DatosHistoriaLaboral": {
        this.activarSubMenu(id);
        this.datosPersonales = false;
        this.datosHistoriaLaboral = true;
        this.datosTerceraFase = false;
        break;
      }
      case "DatosTerceraFase": {
        this.activarSubMenu(id);
        this.datosPersonales = false;
        this.datosHistoriaLaboral = false;
        this.datosTerceraFase = true;
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

  public create(): void {
    this.persona.localidad.seqLocalidad = 0;
    this.persona.lugarDeResidencia.seqCuidad = 0;
    console.log(this.persona)
    debugger;
    this.personaService.create(this.persona).subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/menuPrincipal'])
      }
    );
  }

  private cargarListas(): void {
    this.persona.historias.historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias.historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias.historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias.historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias.historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias.historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias.historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias.historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias.historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias.historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias.historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias.historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias.historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias.historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias.historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias.historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias.historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias.historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias.historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias.historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
  }

}
