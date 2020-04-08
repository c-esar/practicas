import { ElementRef, ViewChild, Component, OnInit, Input } from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { Aseguradora } from '../DatosBean/aseguradora';
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
declare var jQuery: any;
declare var $: any;


@Component({
  selector: 'app-form-gym',
  templateUrl: './form-gym.component.html',
  styleUrls: ['./form-gym.component.css']
})
export class FormGymComponent implements OnInit {

  persona: Persona;
  date = new FormControl(new Date());
  date2 = new FormControl(new Date());
  Spersona: Persona;
  buscoPerson: boolean;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];
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
  //constantes
  private PERSONA_PACIENTE: string = "Paciente";

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService) {
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
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getAuxOMedico();
    this.onLabels();
    this.getTipoDocumento();
    this.getCiudad();
    this.getAseguradora();
    this.getTipoUsuario();
    this.getTipoPreguntaHistoriaGym();
    this.getImpresionDiagnostica();
    this.getAnosHabitosList();
    this.getTipoCuestionarioGym();
    this.getCondicionGym();
    this.getFamiliarGym();
    this.onActivarSubMenu("DatosPricipales");

  }


  public onValidatePersona(): void {
    let tmpDoc = this.persona.numeroDocumento;
    debugger
    this.Spersona = new Persona();
    this.personaService.onBuscarDocumento(this.persona).subscribe(
      (respuesta) => {
        if (respuesta == null) {
          this.Spersona = new Persona();
          this.persona = new Persona();
          this.persona.numeroDocumento = tmpDoc;
          Swal.fire('Error', 'Persona No Registrada', 'error');
        } else {
          this.Spersona = respuesta;
          this.persona.seqPersona = this.Spersona.seqPersona
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      }
    );
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
    debugger;
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
    debugger
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
    this.persona.localidad.seqLocalidad = 0;
    this.persona.lugarDeResidencia.seqCuidad = 0;
    if (this.permiso.crearAux === 1) {
      this.persona.historias = null;
    } else if (this.permiso.crearUsuario === 1) {
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

  private getAseguradora(): void {
    this.personaService.getAseguradora().subscribe(
      (respuesta) => {
        this.aseguradora = respuesta
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

  private getTipoPreguntaHistoriaGym(): void {
    this.historiaService.getTipoPreguntaHistoriaGym().subscribe(
      (respuesta) => {
        this.tipoPreguntaHistoriaGym = respuesta
        console.log(respuesta)
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
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos.crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos.crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos.gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos.descargar;
    console.log(this.permiso.crearAux);
  }

}
