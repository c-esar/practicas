import { Component, OnInit } from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
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
  selector: 'app-form-auxiliar',
  templateUrl: './form-auxiliar.component.html',
  styleUrls: ['./form-auxiliar.component.css']
})
export class FormAuxiliarComponent implements OnInit {

  persona: Persona;
  Spersona: Persona;
  buscoPerson: boolean;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];

  medico: boolean;
  aux: boolean;
  //constantes
  private PERSONA_PACIENTE: string = "Paciente";
  //lista elementos a bloquear
  listaElementosBLoquear: string[];
  sinAgregarLista: boolean;

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService) {
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.buscoPerson = false;
    this.listaElementosBLoquear = new Array<string>();
    this.sinAgregarLista = true;
  }

  ngOnInit(): void {
    this.activarLabels();
    this.obtenerPermisos();
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
  }

  public onValidatePersona(): void {
    this.persona.rolUsuario = this.PERSONA_PACIENTE;
    this.Spersona = new Persona();
    this.personaService.onBuscarDocumento(this.persona).subscribe(
      (respuesta) => {
        if (respuesta == null || respuesta.nomPrimerNombre == null) {
          this.Spersona = new Persona();
          this.buscoPerson = false;
          Swal.fire('Error', 'Persona No Registrada', 'error');
        } else {
          this.Spersona = respuesta;
          this.persona.seqPersona = this.Spersona.seqPersona
          if (this.permiso.crearAux == 1) {
            this.Spersona.historias = null;
          }
          this.buscoPerson = true;
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      }
    );
  }

  private getAuxOMedico(): void {
    if (this.permiso.crearUsuario == 0) {
      if (this.permiso.crearAux == 1) {
        this.aux = true;
        this.medico = false;
      }
    } else if (this.permiso.crearUsuario == 1) {
      this.medico = true;
    }
  }


  public create(): void {
    this.persona.localidad.seqLocalidad = 0;
    this.persona.lugarDeResidencia.seqCuidad = 0;
    this.persona.rolUsuario = this.PERSONA_PACIENTE;
    if (this.permiso.crearAux == 1) {
      this.persona.historias = null;
      if (this.buscoPerson) {
        this.actualizarPerson(this.Spersona);
      }
    }
    console.log(this.persona)
    this.personaService.create(this.persona).subscribe(
      response => {
        console.log(response);
        if (response == null) {
          Swal.fire('Error', 'Persona No Registrada', 'error');
        } else {
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
        this.router.navigate(['/menuPrincipal'])
      }
    );
  }

  private actualizarPerson(per: Persona): void {
    this.persona.seqPersona = per.seqPersona;
    this.persona.nomPrimerNombre = this.persona.nomPrimerNombre == null ? per.nomPrimerNombre : this.persona.nomPrimerNombre;
    this.persona.nomPrimerApellido = this.persona.nomPrimerApellido == null ? per.nomPrimerApellido : this.persona.nomPrimerApellido;
    this.persona.nomSegundoNombre = this.persona.nomSegundoNombre == null ? per.nomSegundoNombre : this.persona.nomSegundoNombre;
    this.persona.nomSegundoApellido = this.persona.nomSegundoApellido == null ? per.nomSegundoApellido : this.persona.nomSegundoApellido;
    this.persona.tipoDocumento = this.persona.tipoDocumento == null ? per.tipoDocumento : this.persona.tipoDocumento;
    this.persona.numeroDocumento = this.persona.numeroDocumento == null ? per.numeroDocumento : this.persona.numeroDocumento;
    this.persona.edad = this.persona.edad == null ? per.edad : this.persona.edad;
    this.persona.direccion = this.persona.direccion == null ? per.direccion : this.persona.direccion;
    this.persona.telefono = this.persona.telefono == null ? per.telefono : this.persona.telefono;
    this.persona.celular = this.persona.celular == null ? per.celular : this.persona.celular;
    this.persona.genero = this.persona.genero == null ? per.genero : this.persona.genero;
    this.persona.estadoCivil = this.persona.estadoCivil == null ? per.estadoCivil : this.persona.estadoCivil;
    this.persona.fechaNacimiento = this.persona.fechaNacimiento == null ? per.fechaNacimiento : this.persona.fechaNacimiento;
    this.persona.lugarNacimiento = this.persona.lugarNacimiento == null ? per.lugarNacimiento : this.persona.lugarNacimiento;
    this.persona.lugarDeResidencia = this.persona.lugarDeResidencia == null ? per.lugarDeResidencia : this.persona.lugarDeResidencia;
    this.persona.escolaridad = this.persona.escolaridad == null ? per.escolaridad : this.persona.escolaridad;
    this.persona.nomCargoDep = this.persona.nomCargoDep == null ? per.nomCargoDep : this.persona.nomCargoDep;
    this.persona.afp = this.persona.afp == null ? per.afp : this.persona.afp;
    this.persona.arl = this.persona.arl == null ? per.arl : this.persona.arl;
    this.persona.aseguradora = this.persona.aseguradora == null ? per.aseguradora : this.persona.aseguradora;
  }

}
