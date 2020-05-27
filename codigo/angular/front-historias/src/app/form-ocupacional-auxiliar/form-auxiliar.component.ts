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
import { TipoHistoria } from '../DatosBean/tipoHistoria';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import Swal from 'sweetalert2';
import { UserIdleService } from 'angular-user-idle';
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
    private historiaService: HistoriasService,
    private userIdle: UserIdleService) {

  }

  ngOnInit(): void {
    this.onCargarAtributos();
    this.onFunciones();
    this.userIdle.startWatching();

    // Start watching when user idle is starting.
    this.userIdle.onTimerStart().subscribe(count => console.log(count));

    // Start watch when time is up.
    this.userIdle.onTimeout().subscribe(() => {
      this.loginService.logOut();
      this.router.navigate(['login']);
      Swal.fire('Tiempo agotado', 'Inactivo', 'error');
    });
  }

  stop() {
    this.userIdle.stopTimer();
  }

  stopWatching() {
    this.userIdle.stopWatching();
  }

  startWatching() {
    this.userIdle.startWatching();
  }

  restart() {
    this.userIdle.resetTimer();
  }

  private onCargarAtributos(): void {
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.buscoPerson = false;
    this.listaElementosBLoquear = new Array<string>();
    this.sinAgregarLista = true;
  }
  private onFunciones(): void {
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

  public onLimpiar(): void {
    this.onCargarAtributos();
    this.onFunciones();
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
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos[0].crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos[0].crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos[0].gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos[0].descargar;
  }

  public onValidatePersona(): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Buscando',
        timer: 10000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      let tmpDoc = this.persona.numeroDocumento;
      this.Spersona = new Persona();
      this.persona.aseguradora = new Aseguradora();
      this.persona.tipoDocumento = new TipoDocumento();
      this.persona.lugarNacimiento = new Ciudad();
      this.buscoPerson = false;
      this.personaService.onBuscarDocumento(this.persona).subscribe(
        (respuesta) => { 
          console.log(respuesta);
          this.Spersona = respuesta;
          if (this.Spersona.aseguradora === null) {
            this.persona.aseguradora = new Aseguradora();
            this.Spersona.aseguradora = new Aseguradora();
          }
          if (this.Spersona.tipoDocumento === null) {
            this.persona.tipoDocumento = new TipoDocumento();
            this.Spersona.tipoDocumento = new TipoDocumento();
          }
          if (this.Spersona.lugarNacimiento === null) {
            this.persona.lugarNacimiento = new Ciudad();
            this.Spersona.lugarNacimiento = new Ciudad();
          }
          this.persona.seqPersona = this.Spersona.seqPersona;
          this.buscoPerson = true;
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      );
    }, 1000);
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

  updatePersona(funcion: string): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Guardando',
        timer: 10000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      this.persona.localidad.seqLocalidad = 0;
      this.persona.lugarDeResidencia.seqCuidad = 0;
      this.actualizarPerson(this.Spersona);
      this.personaService.update(this.persona).subscribe(
        response => {
          console.log(response);
          if (funcion === '1') {
            Swal.fire('Exitoso', 'Persona Actualizada', 'success');
          } else {
            Swal.fire('Exitoso', 'Persona Creada', 'success');
            this.router.navigate(['/menuPrincipal']);
          }
        }
      );
    }, 1000);
  }

  private actualizarPerson(per: Persona): void {
    this.persona.seqPersona = per.seqPersona;
    this.persona.nomPrimerNombre = this.persona.nomPrimerNombre == null ? per.nomPrimerNombre : this.persona.nomPrimerNombre;
    this.persona.nomPrimerApellido = this.persona.nomPrimerApellido == null ? per.nomPrimerApellido : this.persona.nomPrimerApellido;
    this.persona.nomSegundoNombre = this.persona.nomSegundoNombre == null ? per.nomSegundoNombre : this.persona.nomSegundoNombre;
    this.persona.nomSegundoApellido = this.persona.nomSegundoApellido == null ? per.nomSegundoApellido : this.persona.nomSegundoApellido;
    this.persona.tipoDocumento = (this.persona.tipoDocumento == null || this.persona.tipoDocumento.seqTipoDocumento == null) ? per.tipoDocumento : this.persona.tipoDocumento;
    this.persona.numeroDocumento = this.persona.numeroDocumento == null ? per.numeroDocumento : this.persona.numeroDocumento;
    this.persona.edad = this.persona.edad == null ? per.edad : this.persona.edad;
    this.persona.direccion = this.persona.direccion == null ? per.direccion : this.persona.direccion;
    this.persona.telefono = this.persona.telefono == null ? per.telefono : this.persona.telefono;
    this.persona.celular = this.persona.celular == null ? per.celular : this.persona.celular;
    this.persona.genero = this.persona.genero == null ? per.genero : this.persona.genero;
    this.persona.estadoCivil = this.persona.estadoCivil == null ? per.estadoCivil : this.persona.estadoCivil;
    this.persona.fechaNacimiento = this.persona.fechaNacimiento == null ? per.fechaNacimiento : this.persona.fechaNacimiento;
    this.persona.lugarNacimiento = (this.persona.lugarNacimiento == null || this.persona.lugarNacimiento.seqCuidad == null) ? per.lugarNacimiento : this.persona.lugarNacimiento;
    this.persona.lugarDeResidencia = (this.persona.lugarDeResidencia == null || this.persona.lugarDeResidencia.seqCuidad == null) ? per.lugarDeResidencia : this.persona.lugarDeResidencia;
    this.persona.escolaridad = this.persona.escolaridad == null ? per.escolaridad : this.persona.escolaridad;
    this.persona.nomCargoDep = this.persona.nomCargoDep == null ? per.nomCargoDep : this.persona.nomCargoDep;
    this.persona.afp = this.persona.afp == null ? per.afp : this.persona.afp;
    this.persona.arl = this.persona.arl == null ? per.arl : this.persona.arl;
    this.persona.aseguradora = (this.persona.aseguradora == null || this.persona.aseguradora.seqAseguradora == null) ? per.aseguradora : this.persona.aseguradora;
    this.persona.rh = this.persona.rh == null ? per.rh : this.persona.rh;
    this.persona.nomEmergencia = this.persona.nomEmergencia == null ? per.nomEmergencia : this.persona.nomEmergencia;
    this.persona.telEmergencia = this.persona.telEmergencia == null ? per.telEmergencia : this.persona.telEmergencia;
    this.persona.parentescoEmergencia = this.persona.parentescoEmergencia == null ? per.parentescoEmergencia : this.persona.parentescoEmergencia;
    this.persona.codigo = this.persona.codigo == null ? per.codigo : this.persona.codigo;
    this.persona.grupoSanguineo = this.persona.grupoSanguineo == null ? per.grupoSanguineo : this.persona.grupoSanguineo;
    let nuevoRol = new TipoUsuario();
    nuevoRol.seqTipoUsuario = 2;
    if (this.persona.rolUsuario != null && this.persona.rolUsuario.length > 0) {
    } else if (per.rolUsuario != null && per.rolUsuario.length > 0) {
      this.persona.rolUsuario = per.rolUsuario;
    } else {
      this.persona.rolUsuario = new Array<TipoUsuario>();
      this.persona.rolUsuario.push(nuevoRol);
    }
    this.persona.perfil = per.perfil == null || per.perfil.seqPerfil == null ? null : per.perfil;
    this.persona.imagen = this.persona.imagen == null ? per.imagen : this.persona.imagen;
  }

}
