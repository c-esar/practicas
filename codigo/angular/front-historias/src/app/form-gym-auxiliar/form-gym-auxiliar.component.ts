import { ElementRef, ViewChild, Component, OnInit, Input } from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import { HistoriaPreguntaGym } from '../DatosBean/historiapreguntagym';
import { TipoPreguntaHistoriaGym } from '../DatosBean/tipopreguntahistoriagym';
import { Router } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import { ExamenFisico } from '../DatosBean/examenFisico';
import { FormControl } from '@angular/forms';
import Swal from 'sweetalert2';
import { HistoriaGym } from '../DatosBean/historiaGym';
import { DiagnosticoOcupacional } from '../DatosBean/diagnosticoOcupacional';
import { TipoCuestionario } from '../DatosBean/tipoCuestionario';
import { CuestionarioGym } from '../DatosBean/cuestionariogym';
import { CondicionGym } from '../DatosBean/condiciongym';
import { familiarGym } from '../DatosBean/familiargym';
import { of, Observable, throwError } from 'rxjs';
import { UserIdleService } from 'angular-user-idle';
declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-form-gym-auxiliar',
  templateUrl: './form-gym-auxiliar.component.html',
  styleUrls: ['./form-gym-auxiliar.component.css']
})
export class FormGymAuxiliarComponent implements OnInit {

  persona: Persona;
  date = new FormControl(new Date());
  date2 = new FormControl(new Date());
  Spersona: Persona;
  buscoPerson: boolean;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  tipoUsuario: TipoUsuario[];
  medico: boolean;
  aux: boolean;
  guardado: boolean;
  hide = true;
  estudiante: boolean;
  administrativo: boolean;
  docente: boolean;
  egresado: boolean;
  otro: boolean;
  administrador: boolean;
  medicotipo: boolean;
  auxiliar: boolean;
  //constantes
  private PERSONA_PACIENTE: string = "Paciente";

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService,
    private userIdle: UserIdleService
    ) {
  }

  ngOnInit(): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Cargando Informacion',
        timer: 3000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);
    setTimeout(() => {
      this.onCargarAtributos();
      this.onCargarFunciones();
    }, 1000);

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
  onCargarAtributos(): void {
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.tipoUsuario = new Array<TipoUsuario>();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.buscoPerson = false;
    this.onCargarAtributosNuevos();
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getAuxOMedico();
    this.onLabels();
    this.getTipoDocumento();
    this.getCiudad();
    this.getTipoUsuario();
  }

  public onLimpiar(): void {
    this.onCargarAtributos();
    this.onCargarFunciones();
  }

  private onCargarAtributosNuevos(): void {
    this.estudiante = false;
    this.administrativo = false;
    this.docente = false;
    this.egresado = false;
    this.otro = false;
    this.administrador = false;
    this.medicotipo = false;
    this.auxiliar = false;
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
      this.persona.tipoDocumento = new TipoDocumento();
      this.persona.lugarNacimiento = new Ciudad();
      this.buscoPerson = false;
      this.onCargarAtributosNuevos();
      this.personaService.onBuscarDocumento(this.persona).subscribe(
        (respuesta) => {
          console.log(respuesta);
          this.Spersona = respuesta;
          if (this.Spersona.tipoDocumento === null) {
            this.persona.tipoDocumento = new TipoDocumento();
          }
          if (this.Spersona.lugarNacimiento === null) {
            this.persona.lugarNacimiento = new Ciudad();
          }
          this.persona.seqPersona = this.Spersona.seqPersona;
          this.onListaNuevatipoUsuario(this.Spersona.rolUsuario);
          this.buscoPerson = true;
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      );
    }, 1000);
  }

  private onListaNuevatipoUsuario(lista: TipoUsuario[]): void {
    for (let i = 0; i < lista.length; i++) {
      for (let j = 0; j < this.tipoUsuario.length; j++) {
        if (lista[i].seqTipoUsuario === this.tipoUsuario[j].seqTipoUsuario) {
          //this.tipoUsuario.splice(j, 1);
          switch (this.tipoUsuario[j].nomTipoUsuario) {
            case "ESTUDIANTE": {
              this.estudiante = true;
              break;
            }
            case "ADMINISTRATIVO": {
              this.administrativo = true;
              break;
            }
            case "DOCENTE": {
              this.docente = true;
              break;
            }
            case "EGRESADO": {
              this.egresado = true;
              break;
            }
            case "OTRO": {
              this.otro = true
              break;
            }
            case "ADMINISTRADOR": {
              this.administrador = true;
              break;
            }
            case "MEDICO": {
              this.medicotipo = true;
              break;
            }
            case "AUXILIAR": {
              this.auxiliar = true;
              break;
            }
          }
          break;
        }
      }
    }
  }

  private getAuxOMedico(): void {
    if (this.permiso.crearUsuario === 0) {
      if (this.permiso.crearAux === 1) {
        this.aux = true;
      }
    } else if (this.permiso.crearUsuario === 1) {
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
      if (this.onCargarTipoUsuario()) {
        this.persona.lugarDeResidencia.seqCuidad = 0;
        this.actualizarPerson(this.Spersona);
        let personaup = new Persona();
        personaup = this.persona;
        personaup.historiaGym = new Array<HistoriaGym>();
        this.personaService.update(personaup).subscribe(
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
      } else {
        Swal.fire('Error', 'No selecciono Tipo usuario', 'error');
      }
    }, 1000);
  }

  private onCargarTipoUsuario(): boolean {
    let contar = 0;
    for (let j = 0; j < this.tipoUsuario.length; j++) {
      switch (this.tipoUsuario[j].nomTipoUsuario) {
        case "ESTUDIANTE": {
          if (this.estudiante === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "ADMINISTRATIVO": {
          if (this.administrativo === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "DOCENTE": {
          if (this.docente === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "EGRESADO": {
          if (this.egresado === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "OTRO": {
          if (this.otro === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "ADMINISTRADOR": {
          if (this.administrador === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "MEDICO": {
          if (this.medicotipo === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
        case "AUXILIAR": {
          if (this.auxiliar === true) {
            let usuario = new TipoUsuario();
            usuario = this.tipoUsuario[j];
            this.persona.rolUsuario.push(usuario);
          } else {
            contar = contar + 1;
          }
          break;
        }
      }
    }
    if (contar === 8) {
      return false;
    } else {
      return true;
    }
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
    let lugar_nacimiento = new Ciudad();
    lugar_nacimiento.seqCuidad = 0;
    this.persona.lugarNacimiento = this.persona.lugarNacimiento == null || this.persona.lugarNacimiento.seqCuidad === null ? per.lugarNacimiento.seqCuidad === null ? lugar_nacimiento : per.lugarNacimiento : this.persona.lugarNacimiento;
    this.persona.lugarDeResidencia = (this.persona.lugarDeResidencia == null || this.persona.lugarDeResidencia.seqCuidad == null) ? per.lugarDeResidencia : this.persona.lugarDeResidencia;
    this.persona.escolaridad = this.persona.escolaridad == null ? per.escolaridad : this.persona.escolaridad;
    this.persona.nomCargoDep = this.persona.nomCargoDep == null ? per.nomCargoDep : this.persona.nomCargoDep;
    this.persona.afp = this.persona.afp == null ? per.afp : this.persona.afp;
    this.persona.arl = this.persona.arl == null ? per.arl : this.persona.arl;
    this.persona.aseguradora = this.persona.aseguradora == null ? per.aseguradora : this.persona.aseguradora;
    this.persona.rh = this.persona.rh == null ? per.rh : this.persona.rh;
    this.persona.nomEmergencia = this.persona.nomEmergencia == null ? per.nomEmergencia : this.persona.nomEmergencia;
    this.persona.telEmergencia = this.persona.telEmergencia == null ? per.telEmergencia : this.persona.telEmergencia;
    this.persona.parentescoEmergencia = this.persona.parentescoEmergencia == null ? per.parentescoEmergencia : this.persona.parentescoEmergencia;
    this.persona.codigo = this.persona.codigo == null ? per.codigo : this.persona.codigo;
    this.persona.grupoSanguineo = this.persona.grupoSanguineo == null ? per.grupoSanguineo : this.persona.grupoSanguineo;
    this.persona.perfil = per.perfil == null || per.perfil.seqPerfil == null ? null : per.perfil;
    this.persona.imagen = this.persona.imagen == null ? per.imagen : this.persona.imagen;
  }
  private onLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }
  private getTipoDocumento(): void {
    this.personaService.getTipoDocumento().subscribe(
      (respuesta) => {
        this.tipoDocumento = respuesta
        console.log(respuesta)
      }
    )
  }

  private getCiudad(): void {
    this.personaService.getCiudad().subscribe(
      (respuesta) => {
        this.ciudad = respuesta
        console.log(respuesta)
      }
    )
  }

  private getTipoUsuario(): void {
    this.historiaService.getTipoUsuario().subscribe(
      (respuesta) => {
        this.tipoUsuario = respuesta
        console.log(respuesta)
      }
    )
  }

  private getPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos[0].crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos[0].crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos[0].gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos[0].descargar;
    console.log(this.permiso.crearAux);
  }

}
