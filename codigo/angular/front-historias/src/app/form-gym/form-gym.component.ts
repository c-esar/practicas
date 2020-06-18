import { ElementRef, ViewChild, Component, OnInit, Input, AfterViewInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
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
import { FirmaIndividualComponent } from '../firma-individual/firma-individual.component';
import { UserIdleService } from 'angular-user-idle';
declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-form-gym',
  templateUrl: './form-gym.component.html',
  styleUrls: ['./form-gym.component.css']
})
export class FormGymComponent implements OnInit, AfterViewInit {

  @ViewChild('medicoind') firmaMedicohtml: FirmaIndividualComponent;
  @ViewChild('pacienteind') firmaPacientehtml: FirmaIndividualComponent;
  firmaMedico: any;
  firmaPaciente: any;
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
  listAnosHabito: number[];
  diagnostica: DiagnosticoOcupacional[];
  examenFisico: ExamenFisico;
  medico: boolean;
  aux: boolean;
  tipoPreguntaHistoriaGym: TipoPreguntaHistoriaGym[];
  tipoCuestionario: TipoCuestionario[];
  EMBARAZO: HistoriaPreguntaGym;
  FUMA: HistoriaPreguntaGym;
  LICOR: HistoriaPreguntaGym;
  EJERCICIO: HistoriaPreguntaGym;
  ENERGIZANTES: HistoriaPreguntaGym;
  PSICOACTIVAS: HistoriaPreguntaGym;
  condicionGym: CondicionGym[];
  familiarsGym: familiarGym[];
  estadoCondicion: boolean;
  estadoFamiliar: boolean;
  estadoTipoCancer: boolean;
  guardado: boolean;
  historiaUpdate = new HistoriaGym();
  seqPersona: any;
  estudiante: boolean;
  administrativo: boolean;
  docente: boolean;
  egresado: boolean;
  otro: boolean;
  administrador: boolean;
  medicotipo: boolean;
  auxiliar: boolean;
  personaLogin: Persona;
  //constantes
  private PERSONA_PACIENTE: string = "Paciente";
  private CODIGO_CIUDAD: number = 5137;

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService,
    private _sanitizer: DomSanitizer,
    private userIdle: UserIdleService) {
  }

  ngOnInit(): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Cargando Informacion',
        timer: 4000,
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
  
  ngAfterViewInit() {
    this.getDatosPersonaLogin();
  }

  private getDatosPersonaLogin(): void {
    this.personaLogin = this.loginService.obtenerPerfilSesion().persona[0];
    this.personaService.onBuscarDocumento(this.personaLogin).subscribe(
      (response) => {
        this.personaLogin = new Persona();
        this.personaLogin = response;
        this.onCargaImagenMedico();
      }
    );
  }

  private onCargaImagenMedico(): void {
    if (this.personaLogin.imagen != null) {
      this.firmaMedico = this.personaLogin.imagen;//this._sanitizer.bypassSecurityTrustResourceUrl();
    } else {
      this.firmaMedico = null;
    }
  }

  private actualizarFirmaMedico(): void{
    this.personaLogin.historiaGym = null;
    this.personaLogin.historias = null;
    this.personaService.update(this.personaLogin).subscribe(
      response => {
        console.log(response);
      }
    );
  }

  onCargarAtributos(): void {
    this.persona = new Persona();
    this.persona.historiaGym.push(new HistoriaGym());
    this.permiso = new Permiso();
    this.tipoUsuario = new Array<TipoUsuario>();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.EMBARAZO = new HistoriaPreguntaGym();
    this.FUMA = new HistoriaPreguntaGym();
    this.LICOR = new HistoriaPreguntaGym();
    this.EJERCICIO = new HistoriaPreguntaGym();
    this.ENERGIZANTES = new HistoriaPreguntaGym();
    this.PSICOACTIVAS = new HistoriaPreguntaGym();
    this.listAnosHabito = new Array<number>();
    this.examenFisico = new ExamenFisico();
    this.buscoPerson = false;
    this.estadoCondicion = false;
    this.estadoFamiliar = false;
    this.estadoTipoCancer = false;
    this.guardado = true;
    this.persona.historiaGym[0].ciudadHistoria.seqCuidad = this.CODIGO_CIUDAD;
    this.onCargarAtributosNuevos();
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getAuxOMedico();
    this.onLabels();
    this.getTipoDocumento();
    this.getCiudad();
    this.getTipoUsuario();
    this.getTipoPreguntaHistoriaGym();
    this.getImpresionDiagnostica();
    this.getAnosHabitosList();
    this.getTipoCuestionarioGym();
    this.getCondicionGym();
    this.getFamiliarGym();
    this.onActivarSubMenu("DatosPricipales");

  }

  public onLimpiar(): void {
    this.onCargarAtributos();
    this.onCargarFunciones();
    this.firmaPacientehtml.ngAfterViewInit();
    this.firmaPaciente = null;
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
      this.onCargarAtributosNuevos();
      this.persona.tipoDocumento = new TipoDocumento();
      this.persona.lugarNacimiento = new Ciudad();
      this.buscoPerson = false;
      this.persona.historiaGym = new Array<HistoriaGym>();
      this.persona.historiaGym.push(new HistoriaGym());
      this.persona.historiaGym[0].ciudadHistoria.seqCuidad = this.CODIGO_CIUDAD;
      this.personaService.onBuscarDocumento(this.persona).subscribe(
        (respuesta) => {
          console.log(respuesta);
          this.Spersona = respuesta;
          this.seqPersona = respuesta.seqPersona;
          if (this.Spersona.tipoDocumento === null) {
            this.persona.tipoDocumento = new TipoDocumento();
          }
          if (this.persona.lugarNacimiento === null) {
            this.persona.lugarNacimiento = new Ciudad();
          }
          if (this.Spersona.imagen != null) {
            this.firmaPaciente = this.Spersona.imagen;//this._sanitizer.bypassSecurityTrustResourceUrl(this.Spersona.imagen);
          } else {
            this.firmaPaciente = null;
          }
          this.persona.seqPersona = this.Spersona.seqPersona;
          this.onListaNuevatipoUsuario(this.Spersona.rolUsuario);
          this.buscoPerson = true;
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      );
    }, 1000);
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

  public onValidarSelect(value: string, id: string): void {
    console.log("entre validar select");
    if (value == "si") {
      switch (id) {
        case "formcantidadCigarrilloGym": {
          $('#' + id).show();
          break;
        }
        case "formcantidadlicorGym": {
          $('#' + id).show();
          break;
        }
        case "formejercicioGym": {
          $('#' + id).show();
          break;
        }
        case "formcantidadenergizanteGym": {
          $('#' + id).show();
          break;
        }
        case "formcantidadsustanciasGym": {
          $('#' + id).show();
          break;
        }
      }
    } else if (value == "no") {
      switch (id) {
        case "formcantidadCigarrilloGym": {
          $('#' + id).hide();
          break;
        }
        case "formcantidadlicorGym": {
          $('#' + id).hide();
          break;
        }
        case "formejercicioGym": {
          $('#' + id).hide();
          break;
        }
        case "formcantidadenergizanteGym": {
          $('#' + id).hide();
          break;
        }
        case "formcantidadsustanciasGym": {
          $('#' + id).hide();
          break;
        }
      }
    }
  }

  public onGuardarCuestionario(estado: string, id: string): void {
    let entre = true;
    let pos = this.persona.historiaGym[0].cuestionarioGymEntity.length;
    for (let i = 0; i < this.persona.historiaGym[0].cuestionarioGymEntity.length; i++) {
      if (this.persona.historiaGym[0].cuestionarioGymEntity[i].tipoCuestionarioEntity.seqTipoCuestionario === id) {
        this.persona.historiaGym[0].cuestionarioGymEntity[i].estadoCuestionario = estado;
        entre = false;
      }
    }
    if (entre) {
      this.persona.historiaGym[0].cuestionarioGymEntity.push(new CuestionarioGym());
      this.persona.historiaGym[0].cuestionarioGymEntity[pos].tipoCuestionarioEntity.seqTipoCuestionario = id;
      this.persona.historiaGym[0].cuestionarioGymEntity[pos].estadoCuestionario = estado;
    }
  }

  private cargarListas(): void {
    for (let i = 0; i < this.tipoPreguntaHistoriaGym.length; i++) {
      switch (this.tipoPreguntaHistoriaGym[i].nomPregunta) {
        case "EMBARAZO": {
          this.EMBARAZO.estadoPregunta = "S";
          this.EMBARAZO.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[i];
          break;
        }
        case "FUMA": {
          this.FUMA.estadoPregunta = "S";
          this.FUMA.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[i];
          break;
        }
        case "LICOR": {
          this.LICOR.estadoPregunta = "S";
          this.LICOR.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[i];
          break;
        }
        case "EJERCICIO": {
          this.EJERCICIO.estadoPregunta = "S";
          this.EJERCICIO.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[i];
          break;
        }
        case "ENERGIZANTES": {
          this.ENERGIZANTES.estadoPregunta = "S";
          this.ENERGIZANTES.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[i];
          break;
        }
        case "PSICOACTIVAS": {
          this.PSICOACTIVAS.estadoPregunta = "S";
          this.PSICOACTIVAS.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[i];
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

  public onFuncionHistoriaPersonal(nom: string, id: number, estado: string): void {
    if (nom === "OTRA" && id === 14 && this.estadoCondicion) {
      document.getElementById("formotracondicionym").style.display = "none";
      this.persona.historiaGym[0].otraCondicion = null;
      this.estadoCondicion = false;
    } else if (nom === "OTRA" && id === 14 && this.estadoCondicion === false) {
      document.getElementById("formotracondicionym").style.display = "block";
      this.estadoCondicion = true;
    }
  }

  public onFuncionesHistoriaFamiliar(nom: string, id: number): void {
    if (nom === "OTROS" && id === 10 && this.estadoFamiliar) {
      document.getElementById("formotrafamiliargym").style.display = "none";
      this.persona.historiaGym[0].otraFamiliar = null;
      this.estadoFamiliar = false;
    } else if (nom === "OTROS" && id === 10 && this.estadoFamiliar === false) {
      document.getElementById("formotrafamiliargym").style.display = "block";
      this.estadoFamiliar = true;
    }

    if (nom === this.datosSingleton.labelCancer && id === 7 && this.estadoTipoCancer) {
      document.getElementById("formtipocancergym").style.display = "none";
      this.persona.historiaGym[0].tipoCancer = null;
      this.estadoTipoCancer = false;
    } else if (nom === this.datosSingleton.labelCancer && id === 7 && this.estadoTipoCancer === false) {
      document.getElementById("formtipocancergym").style.display = "block";
      this.estadoTipoCancer = true;
    }
  }

  onActivarSubMenu(id: string) {
    var menues = $(".nav-link");
    menues.removeClass("active");
    menues.removeClass("disabled");
    menues.removeClass("btn-primary");
    menues.removeAttr("style");
    menues.css("color", "black");
    switch (id) {
      case "DatosPricipales": {
        if (this.permiso.crearUsuario === 0) {
          if (this.permiso.crearAux === 1) {
            this.activarSubMenu(id);
            $('#DatosHistoriaLaboral').addClass("disabled");
          }
        } else if (this.permiso.crearUsuario === 1) {
          this.activarSubMenu(id);
        }
        document.getElementById("DatosPricipalesHtml").style.display = "block";
        document.getElementById("DatosHistoriaPersonalHtml").style.display = "none";
        document.getElementById("DatosHistoriaFamiliarHtml").style.display = "none";
        document.getElementById("DatosCuestionarioHtml").style.display = "none";
        document.getElementById("DatosExamenFisicoHtml").style.display = "none";
        document.getElementById("DatosFinalFormularioHtml").style.display = "none";
        break;
      }
      case "DatosHistoriaPersonal": {
        this.activarSubMenu(id);
        document.getElementById("DatosPricipalesHtml").style.display = "none";
        document.getElementById("DatosHistoriaPersonalHtml").style.display = "block";
        document.getElementById("DatosHistoriaFamiliarHtml").style.display = "none";
        document.getElementById("DatosCuestionarioHtml").style.display = "none";
        document.getElementById("DatosExamenFisicoHtml").style.display = "none";
        document.getElementById("DatosFinalFormularioHtml").style.display = "none";
        break;
      }
      case "DatosHistoriaFamiliar": {
        this.activarSubMenu(id);
        document.getElementById("DatosPricipalesHtml").style.display = "none";
        document.getElementById("DatosHistoriaPersonalHtml").style.display = "none";
        document.getElementById("DatosHistoriaFamiliarHtml").style.display = "block";
        document.getElementById("DatosCuestionarioHtml").style.display = "none";
        document.getElementById("DatosExamenFisicoHtml").style.display = "none";
        document.getElementById("DatosFinalFormularioHtml").style.display = "none";
        break;
      }
      case "DatosCuestionario": {
        this.activarSubMenu(id);
        document.getElementById("DatosPricipalesHtml").style.display = "none";
        document.getElementById("DatosHistoriaPersonalHtml").style.display = "none";
        document.getElementById("DatosHistoriaFamiliarHtml").style.display = "none";
        document.getElementById("DatosCuestionarioHtml").style.display = "block";
        document.getElementById("DatosExamenFisicoHtml").style.display = "none";
        document.getElementById("DatosFinalFormularioHtml").style.display = "none";
        break;
      }
      case "DatosExamenFisico": {
        this.activarSubMenu(id);
        document.getElementById("DatosPricipalesHtml").style.display = "none";
        document.getElementById("DatosHistoriaPersonalHtml").style.display = "none";
        document.getElementById("DatosHistoriaFamiliarHtml").style.display = "none";
        document.getElementById("DatosCuestionarioHtml").style.display = "none";
        document.getElementById("DatosExamenFisicoHtml").style.display = "block";
        document.getElementById("DatosFinalFormularioHtml").style.display = "none";
        break;
      }
      case "DatosFinalFormulario": {
        this.activarSubMenu(id);
        document.getElementById("DatosPricipalesHtml").style.display = "none";
        document.getElementById("DatosHistoriaPersonalHtml").style.display = "none";
        document.getElementById("DatosHistoriaFamiliarHtml").style.display = "none";
        document.getElementById("DatosCuestionarioHtml").style.display = "none";
        document.getElementById("DatosExamenFisicoHtml").style.display = "none";
        document.getElementById("DatosFinalFormularioHtml").style.display = "block";
        break;
      }
      default: {
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
    setTimeout(() => {
      Swal.fire({
        title: this.datosSingleton.mensajeBarProgress,
        timer: 10000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);
    setTimeout(() => {
      if (this.persona.historiaGym[0].aceptoCondiciones != null) {
        this.persona.historiaGym[0].aceptoCondiciones = "true";
        this.onCargarPreguntas();
        this.firmaMedico = this.firmaMedicohtml.imagenUsuario == null || this.firmaMedicohtml.imagenUsuario == undefined ? this.firmaMedico : this.firmaMedicohtml.imagenUsuario;
        this.firmaPaciente = this.firmaPacientehtml.imagenUsuario == null || this.firmaPacientehtml.imagenUsuario == undefined ? this.firmaPaciente : this.firmaPacientehtml.imagenUsuario;
        if (this.firmaMedico != null && this.firmaPaciente != null) {
          this.personaLogin.imagen = this.firmaMedico;
          this.actualizarFirmaMedico();
          this.persona.imagen = this.firmaPaciente;
          if (this.onValidarPreguntas() && this.guardado) {
            if (this.permiso.crearUsuario === 1) {
              this.persona.historiaGym[0].examenFisico = this.examenFisico;
              this.persona.historiaGym[0].personaMedico = this.personaLogin.seqPersona;
              if (this.onCargarTipoUsuario()) {
                if (this.buscoPerson) {
                  this.historiaUpdate = this.persona.historiaGym[0];
                  this.historiaUpdate.persona.seqPersona = this.seqPersona;
                  this.updatePersona();
                  this.createHistoria();
                } else {
                  this.persona.lugarDeResidencia.seqCuidad = 0;
                  this.actualizarPerson(this.Spersona);
                  console.log(this.persona);
                  this.personaService.create(this.persona, "1").subscribe(
                    response => {
                      console.log(response);
                      this.guardado = false;
                      Swal.fire('Exitoso', 'Persona Registrada', 'success');
                      this.router.navigate(['/menuPrincipal'])
                    }
                  );
                }
              } else {
                Swal.fire('Error', 'No selecciono Tipo usuario', 'error');
              }

            }
          } else {
            this.persona.historiaGym[0].historiaPreguntasGyms = new Array<HistoriaPreguntaGym>();
            Swal.fire('Error', 'Falta completar información necesaria en la sección HISTORIA PERSONAL verificar campos', 'error');
          }
        } else {
          Swal.fire('Error', 'Falta completar firmas', 'error');
        }
      } else {
        Swal.fire('Error', 'Debe aceptar las condicones', 'error');
      }


    }, 1000);
  }

  updatePersona(): void {
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
        //this.persona.lugarDeResidencia.seqCuidad = 0;
        this.actualizarPerson(this.Spersona);
        let personaup = new Persona();
        personaup = this.persona;
        personaup.historiaGym = new Array<HistoriaGym>();
        this.personaService.update(personaup).subscribe(
          response => {
            console.log(response);
            Swal.fire('Exitoso', 'Persona Actualizada', 'success');
          }
        );
      } else {
        Swal.fire('Error', 'No selecciono Tipo usuario', 'error');
      }
      this.persona.historiaGym = new Array<HistoriaGym>();
      this.persona.historiaGym.push(new HistoriaGym());
      this.persona.historiaGym[0].ciudadHistoria.seqCuidad = this.CODIGO_CIUDAD;
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

  createHistoria(): void {
    this.historiaUpdate.persona.seqPersona = this.Spersona.seqPersona;
    this.historiaService.createGym(this.historiaUpdate).subscribe(
      response => {
        console.log(response);
        Swal.fire('Exitoso', 'Persona Registrada', 'success');
        this.guardado = false;
        this.router.navigate(['/menuPrincipal']);
      }
    );
  }

  private onValidarPreguntas(): boolean {
    for (var i = 0; i < this.persona.historiaGym[0].historiaPreguntasGyms.length; i++) {
      switch (this.persona.historiaGym[0].historiaPreguntasGyms[i].tipoPreguntaHistoriaGymEntity.nomPregunta) {
        case "EMBARAZO": {
          if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta == null) {
            return false;
          }
          break;
        } case "FUMA": {
          if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "S") {
            if (this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad === null ||
              this.persona.historiaGym[0].historiaPreguntasGyms[i].tiempoFumando == null) {
              return false;
            }
          } else if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "N") {
            this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad = null;
            this.persona.historiaGym[0].historiaPreguntasGyms[i].tiempoFumando = null;
          }
          break;
        } case "LICOR": {
          if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "S") {
            if (this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad === null) {
              return false;
            }
          } else if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "N") {
            this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad = null;
          }
          break;
        } case "EJERCICIO": {
          if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "S") {
            if (this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad === null ||
              this.persona.historiaGym[0].historiaPreguntasGyms[i].despCuales === null) {
              return false;
            }
          } else if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "N") {
            this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad = null;
            this.persona.historiaGym[0].historiaPreguntasGyms[i].despCuales = null;
          }
          break;
        } case "ENERGIZANTES": {
          if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "S") {
            if (this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad === null) {
              return false;
            }
          } else if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "N") {
            this.persona.historiaGym[0].historiaPreguntasGyms[i].cantidad = null;
          }
          break;
        } case "PSICOACTIVAS": {
          if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "S") {
            if (this.persona.historiaGym[0].historiaPreguntasGyms[i].despCuales === null) {
              return false;
            }
          } else if (this.persona.historiaGym[0].historiaPreguntasGyms[i].estadoPregunta === "N") {
            this.persona.historiaGym[0].historiaPreguntasGyms[i].despCuales = null;
          }
          break;
        }
      }
    }
    return true;
  }

  private onCargarPreguntas(): void {
    this.EMBARAZO.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[0];
    this.persona.historiaGym[0].historiaPreguntasGyms.push(this.EMBARAZO);
    this.FUMA.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[1];
    this.persona.historiaGym[0].historiaPreguntasGyms.push(this.FUMA);
    this.LICOR.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[2];
    this.persona.historiaGym[0].historiaPreguntasGyms.push(this.LICOR);
    this.EJERCICIO.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[3];
    this.persona.historiaGym[0].historiaPreguntasGyms.push(this.EJERCICIO);
    this.ENERGIZANTES.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[4];
    this.persona.historiaGym[0].historiaPreguntasGyms.push(this.ENERGIZANTES);
    this.PSICOACTIVAS.tipoPreguntaHistoriaGymEntity = this.tipoPreguntaHistoriaGym[5];
    this.persona.historiaGym[0].historiaPreguntasGyms.push(this.PSICOACTIVAS);
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
      }
    );
  }
  private getTipoDocumento(): void {
    this.personaService.getTipoDocumento().subscribe(
      (respuesta) => {
        this.tipoDocumento = respuesta
      }
    )
  }

  private getCiudad(): void {
    this.personaService.getCiudad().subscribe(
      (respuesta) => {
        this.ciudad = respuesta
      }
    )
  }

  private getTipoUsuario(): void {
    this.historiaService.getTipoUsuario().subscribe(
      (respuesta) => {
        this.tipoUsuario = respuesta
      }
    )
  }

  private getTipoPreguntaHistoriaGym(): void {
    this.historiaService.getTipoPreguntaHistoriaGym().subscribe(
      (respuesta) => {
        this.tipoPreguntaHistoriaGym = respuesta
      }
    )
  }

  getAnosHabitosList(): void {
    for (let i = 1; i <= 40; i++) {
      this.listAnosHabito.push(i);
    }
  }

  getImpresionDiagnostica(): void {
    this.historiaService.getImpresionDiagnostica().subscribe(
      (respuesta) => {
        this.diagnostica = respuesta;
      }
    )
  }

  getTipoCuestionarioGym(): void {
    this.historiaService.getTipoCuestionarioGym().subscribe(
      (respuesta) => {
        this.tipoCuestionario = respuesta;
      }
    )
  }

  getCondicionGym(): void {
    this.historiaService.getCondicionGym().subscribe(
      (respuesta) => {
        this.condicionGym = respuesta;
      }
    )
  }

  getFamiliarGym(): void {
    this.historiaService.getFamiliarGym().subscribe(
      (respuesta) => {
        this.familiarsGym = respuesta;
      }
    )
  }

  private getPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos[0].crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos[0].crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos[0].gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos[0].descargar;
  }

}
