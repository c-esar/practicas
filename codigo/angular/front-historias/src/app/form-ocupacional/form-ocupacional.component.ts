import { ElementRef, TemplateRef, ViewChild, Component, OnInit, Input, Output } from '@angular/core';
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
import { Historias } from '../DatosBean/historias';
import { HistoriaLaboral } from '../DatosBean/historiaLaboral';
import { EmpresaLaboral } from '../DatosBean/empresaLaboral';
import { AntecedentesTrabajo } from '../DatosBean/antecedentesTrabajo';
import { AntecedentesHistoria } from '../DatosBean/antecedentesHistoria';
import { EnfermedadesLaboral } from '../DatosBean/enfermedadesLaboral';
import { FactoresRiesgo } from '../DatosBean/factoresRiesgo';
import { TipoAntecedente } from '../DatosBean/tipoAntecedente';
import { ExamenFisico } from '../DatosBean/examenFisico';
import { Paraclinicos } from '../DatosBean/paraclinicos';
import { Concepto } from '../DatosBean/concepto';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import { TipoHistoria } from '../DatosBean/tipoHistoria';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
//ng add ngx-bootstrap
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { PageSettingsModel } from '@syncfusion/ej2-angular-grids';
//npm install @syncfusion/ej2-angular-grids --save
import { DiagnosticoOcupacional } from '../DatosBean/diagnosticoOcupacional';
import Swal from 'sweetalert2';
import { FormControl } from '@angular/forms';
import { TipoEvaluacion } from '../DatosBean/tipoEvaluacion';
declare var jQuery: any;
declare var $: any;
@Component({
  selector: 'app-form-ocupacional',
  templateUrl: './form-ocupacional.component.html',
  styleUrls: ['./form-ocupacional.component.css']
})
export class FormOcupacionalComponent implements OnInit {

  //guardarDatosGrillas
  @ViewChild('gridTrabajosPrevios') public gridTrabajosPrevios: GridComponent;
  @ViewChild('gridAntecedentesTrabajo') public gridAntecedentesTrabajo: GridComponent;
  @ViewChild('gridEnfermedades') public gridEnfermedades: GridComponent;
  @ViewChild('gridFactoresRiesgo') public gridFactoresRiesgo: GridComponent;
  @ViewChild('gridParaclinicos') public gridParaclinicos: GridComponent;
  public pageSettings: PageSettingsModel;
  date = new FormControl(new Date());
  dateNacimiento = new FormControl(new Date());
  modalRef: BsModalRef;
  persona: Persona;
  Spersona: Persona;
  barProgres: boolean;
  buscoPerson: boolean;
  guardado: boolean;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];
  tipoUsuario: TipoUsuario[];
  medico: boolean;
  aux: boolean;
  examenFisico: ExamenFisico;
  //constantes
  private PERSONA_PACIENTE: string = "Paciente";

  //antecedentes historias
  patologicos: AntecedentesHistoria;
  quirurgicos: AntecedentesHistoria;
  farmacologicos: AntecedentesHistoria;
  alergicos: AntecedentesHistoria;
  traumaticos: AntecedentesHistoria;
  toxicos: AntecedentesHistoria;
  hospitalarios: AntecedentesHistoria;
  inmunologicos: AntecedentesHistoria;
  familiares: AntecedentesHistoria;
  tabaquismo: AntecedentesHistoria;
  consumoAlcohol: AntecedentesHistoria;
  actividadFisica: AntecedentesHistoria;
  actividadExtralaborales: AntecedentesHistoria;
  menarquia: AntecedentesHistoria;
  tipoAntecedente: TipoAntecedente[];
  concepto: Concepto[];
  conceptoIngreso: Concepto[];
  conceptoPeriodico: Concepto[];
  conceptoEgreso: Concepto[];
  diagnostica: DiagnosticoOcupacional[];
  tipoHistoria: TipoHistoria[];
  //lista elementos a bloquear
  listaElementosBLoquear: string[];
  sinAgregarLista: boolean;
  listAnosHabito: number[];
  //tipo evaluacion
  tipoEvaluacion: TipoEvaluacion[];
  tipoEvaluacionSelecionado: string;
  historiaUpdate = new Historias();
  seqPersona: any;

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService,
    private modalService: BsModalService) {
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
      this.pageSettings = { pageSize: 6 };
    }, 1000);
  }

  onCargarAtributos(): void {
    this.conceptoIngreso = new Array<Concepto>();
    this.conceptoPeriodico = new Array<Concepto>();
    this.conceptoEgreso = new Array<Concepto>();
    this.persona = new Persona();
    this.persona.historias.push(new Historias());
    this.permiso = new Permiso();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.examenFisico = new ExamenFisico();
    this.listaElementosBLoquear = new Array<string>();
    this.listAnosHabito = new Array<number>();
    this.sinAgregarLista = true;
    this.barProgres = false;
    $('#formOtroEvaluacion').hide();
    this.barProgres = false;
    this.buscoPerson = false;
    this.guardado = true;
    this.persona.historias[0].ciudadHistoria.seqCuidad = 0;
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getAuxOMedico();
    this.onLabels();
    this.onActivarSubMenu("DatosPricipales");
    this.getTipoDocumento();
    this.getCiudad();
    this.getAseguradora();
    this.getTipoAntecedente();
    this.getImpresionDiagnostica();
    this.getTipoEvaluacion();
    this.getAnosHabitosList();
    this.getTipoUsuario();
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
      this.cargarListas();
      debugger
      this.personaService.onBuscarDocumento(this.persona).subscribe(
        (respuesta) => {
          debugger
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

  public onValidarSelect(value: string, id: string): void {
    console.log("entre validar select");
    if (value == "si") {
      this.buscarElementoActivar(id);
      switch (id) {
        case "formlabelCualPatologicosEsOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsQuirurgicosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsFarmacologicosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsAlergicosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsTramauticosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsToxicosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsHospitalariosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlabelCualEsInmunologicosOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formlablemenarquiasOcupacional": {
          $('#' + id).show();
          $('#fromlabelCcv').show();
        }
        case "formlablefamiliarOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formfrecuenciaOcupacional": {
          $('#' + id).show();
          $('#formhabitoOcupacional').show();
          $('#formexfumadorOcupacional').show();
          break;
        }
        case "formfrecuenciaAlcoholOcupacional": {
          $('#' + id).show();
          break;
        }
        case "formfrecuenciafisicaOcupacional": {
          $('#' + id).show();
          $('#formtipofisicaOcupacional').show();
          break;
        }
      }
    } else if (value == "no") {
      if (this.sinAgregarLista) {
        this.listaElementosBLoquear.push(id);
      }
      switch (id) {
        case "formlabelCualPatologicosEsOcupacional": {
          this.patologicos.estadoAntecedente = "N";
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsQuirurgicosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsFarmacologicosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsAlergicosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsTramauticosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsToxicosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsHospitalariosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlabelCualEsInmunologicosOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formlablemenarquiasOcupacional": {
          $('#' + id).hide();
          $('#fromlabelCcv').hide();
        }
        case "formlablefamiliarOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formfrecuenciaOcupacional": {
          $('#' + id).hide();
          $('#formhabitoOcupacional').hide();
          $('#formexfumadorOcupacional').hide();
          break;
        }
        case "formfrecuenciaAlcoholOcupacional": {
          $('#' + id).hide();
          break;
        }
        case "formfrecuenciafisicaOcupacional": {
          $('#' + id).hide();
          $('#formtipofisicaOcupacional').hide();
          break;
        }
      }
    }
  }

  onOpcionEvaluacion($event): void {
    $('#formOtroEvaluacion').hide();
    $('#conceptoPeriodico').hide();
    $('#conceptoEgreso').hide();
    $('#conceptoIngreso').hide();
    $('#tituloConcepto').show();
    this.persona.historias[0].otroEvaluacion = null;
    switch ($event.value.nomEval) {
      case "INGRESO": {
        this.persona.historias[0].tipoEvaluacionEntity = $event.value;
        $('#conceptoIngreso').show();
        break;
      }
      case this.datosSingleton.labelPeriodico: {
        this.persona.historias[0].tipoEvaluacionEntity = $event.value;
        $('#conceptoPeriodico').show();
        break;
      }
      case "EGRESO": {
        this.persona.historias[0].tipoEvaluacionEntity = $event.value;
        $('#conceptoEgreso').show();
        break;
      }
      case "OTRO": {
        this.persona.historias[0].tipoEvaluacionEntity = $event.value;
        $('#tituloConcepto').hide();
        $('#formOtroEvaluacion').show();
        break;
      }
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
        } else if (this.permiso.crearUsuario == 1) {
          this.activarSubMenu(id);
        }
        document.getElementById("datosPersonales").style.display = "block";
        document.getElementById("datosHistoriaLaboral").style.display = "none";
        document.getElementById("datosTerceraFase").style.display = "none";
        document.getElementById("datosExamenFisico").style.display = "none";
        document.getElementById("datosFinalFormulario").style.display = "none";
        break;
      }
      case "DatosHistoriaLaboral": {
        this.activarSubMenu(id);
        document.getElementById("datosPersonales").style.display = "none";
        document.getElementById("datosHistoriaLaboral").style.display = "block";
        document.getElementById("datosTerceraFase").style.display = "none";
        document.getElementById("datosExamenFisico").style.display = "none";
        document.getElementById("datosFinalFormulario").style.display = "none";
        break;
      }
      case "DatosTerceraFase": {
        this.activarSubMenu(id);
        document.getElementById("datosPersonales").style.display = "none";
        document.getElementById("datosHistoriaLaboral").style.display = "none";
        document.getElementById("datosTerceraFase").style.display = "block";
        document.getElementById("datosExamenFisico").style.display = "none";
        document.getElementById("datosFinalFormulario").style.display = "none";
        this.activarElementosTerceraFase();
        break;
      }
      case "DatosExamenFisico": {
        this.activarSubMenu(id);
        document.getElementById("datosPersonales").style.display = "none";
        document.getElementById("datosHistoriaLaboral").style.display = "none";
        document.getElementById("datosTerceraFase").style.display = "none";
        document.getElementById("datosExamenFisico").style.display = "block";
        document.getElementById("datosFinalFormulario").style.display = "none";
        break;
      }
      case "DatosFinalFormulario": {
        this.activarSubMenu(id);
        document.getElementById("datosPersonales").style.display = "none";
        document.getElementById("datosHistoriaLaboral").style.display = "none";
        document.getElementById("datosTerceraFase").style.display = "none";
        document.getElementById("datosExamenFisico").style.display = "none";
        document.getElementById("datosFinalFormulario").style.display = "block";
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
    debugger
    setTimeout(() => {
      Swal.fire({
        title: this.datosSingleton.mensajeBarProgress,
        timer: 10000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      this.onBarProgress('inicio');
      this.actualizarPerson(this.Spersona);
      this.persona.localidad.seqLocalidad = 0;
      this.persona.lugarDeResidencia.seqCuidad = 0;
      this.persona.rolUsuario = this.tipoUsuario[1];
      this.barProgres = true;
      this.cargarDatosActededentesHistoria();
      if (this.onValidarAntecedentes() && this.guardado) {
        if (this.permiso.crearUsuario === 1) {
          this.persona.historias[0].examenFisico = this.examenFisico;
          if (this.buscoPerson) {
            debugger
            this.historiaUpdate = this.persona.historias[0];
            this.historiaUpdate.persona.seqPersona = this.seqPersona;
            this.createHistoria();
          } else {
            console.log(this.persona)
            this.personaService.create(this.persona).subscribe(
              response => {
                console.log(response);
                this.guardado = false;
                this.onBarProgress('salir');
                Swal.fire('Exitoso', 'Persona Registrada', 'success');
                this.router.navigate(['/menuPrincipal'])
              }
            );
          }
        }
      } else {
        this.persona.historias[0].antecedentesHistoriaEntity = new Array<AntecedentesHistoria>();
        this.onBarProgress('salir');
        Swal.fire('Error', 'Falta completar información necesaria en la sección MOTIVO CONSULTA verificar campos', 'error');
      }
      this.onBarProgress('salir');
    }, 1000);
  }

  updatePersona(): void {
    debugger
    this.persona.localidad.seqLocalidad = 0;
    this.persona.lugarDeResidencia.seqCuidad = 0;
    this.actualizarPerson(this.Spersona);
    this.persona.lugarNacimiento = null;
    let personaup = new Persona();
    personaup = this.persona;
    personaup.historias = new Array<Historias>();
    this.personaService.update(personaup).subscribe(
      response => {
        console.log(response);
        Swal.fire('Exitoso', 'Persona Actualizada', 'success');
      }
    );
  }

  createHistoria(): void {
    debugger
    this.historiaService.createHistoria(this.historiaUpdate).subscribe(
      response => {
        debugger
        console.log(response);
        Swal.fire('Exitoso', 'Persona Registrada', 'success');
        this.guardado = false;
        this.router.navigate(['/menuPrincipal']);
      }
    );
  }

  private onBarProgress(tmp: string): void {
    debugger
    switch (tmp) {
      case "inicio": {
        document.getElementById("container-fluid").style.opacity = "0.2";
        document.getElementById("container-fluid").style.pointerEvents = "none";
        document.getElementById("contenidoFormulario").style.pointerEvents = "none";
        document.getElementById("contenidoFormulario").style.opacity = "0.2";
        this.barProgres = true;
        break;
      }
      case "salir": {
        document.getElementById("container-fluid").style.opacity = "1";
        document.getElementById("container-fluid").style.pointerEvents = "all";
        document.getElementById("contenidoFormulario").style.pointerEvents = "all";
        document.getElementById("contenidoFormulario").style.opacity = "1";
        this.barProgres = false;
      }
    }
  }

  private onValidarAntecedentes(): boolean {

    for (let i = 0; i < this.persona.historias[0].antecedentesHistoriaEntity.length; i++) {
      if (this.persona.historias[0].antecedentesHistoriaEntity[i].tipoAntecedenteEntity.nomAntecedente === "TABAQUISMO" ||
        this.persona.historias[0].antecedentesHistoriaEntity[i].tipoAntecedenteEntity.nomAntecedente === "MENARQUIA" ||
        this.persona.historias[0].antecedentesHistoriaEntity[i].tipoAntecedenteEntity.nomAntecedente === "CONSUMO ALCOHOL" ||
        this.persona.historias[0].antecedentesHistoriaEntity[i].tipoAntecedenteEntity.nomAntecedente === this.datosSingleton.actividadFisica
        || this.persona.historias[0].antecedentesHistoriaEntity[i].tipoAntecedenteEntity.nomAntecedente === "ACTIVIDAD EXTRA LABORAL") {
        switch (this.persona.historias[0].antecedentesHistoriaEntity[i].tipoAntecedenteEntity.nomAntecedente) {
          case "TABAQUISMO": {
            if (this.persona.historias[0].antecedentesHistoriaEntity[i].estadoAntecedente === "S") {
              if (this.persona.historias[0].antecedentesHistoriaEntity[i].frecuencia != null &&
                this.persona.historias[0].antecedentesHistoriaEntity[i].anosHabito != null &&
                this.persona.historias[0].antecedentesHistoriaEntity[i].exFumador != null) {
              }
              else {
                return false;
              }
            } else {
              this.persona.historias[0].antecedentesHistoriaEntity[i].frecuencia = null;
              this.persona.historias[0].antecedentesHistoriaEntity[i].anosHabito = 0;
              this.persona.historias[0].antecedentesHistoriaEntity[i].exFumador = "N";
            }
            break;
          } case "MENARQUIA": {
            if (this.persona.historias[0].antecedentesHistoriaEntity[i].estadoAntecedente === "S") {
              if (this.persona.historias[0].antecedentesHistoriaEntity[i].fur != null &&
                this.persona.historias[0].antecedentesHistoriaEntity[i].menarquiaList != null &&
                this.persona.historias[0].antecedentesHistoriaEntity[i].planificacion != null &&
                this.persona.historias[0].antecedentesHistoriaEntity[i].ccv != null) {
              } else {
                return false;
              }
            } else {
              this.persona.historias[0].antecedentesHistoriaEntity[i].fur = null;
              this.persona.historias[0].antecedentesHistoriaEntity[i].menarquiaList = null;
              this.persona.historias[0].antecedentesHistoriaEntity[i].planificacion != null;
              this.persona.historias[0].antecedentesHistoriaEntity[i].ccv = null;
            }
            break;
          } case "CONSUMO ALCOHOL": {
            if (this.persona.historias[0].antecedentesHistoriaEntity[i].estadoAntecedente === "S") {
              if (this.persona.historias[0].antecedentesHistoriaEntity[i].frecuencia != null) {
              } else {
                return false;
              }
            } else {
              this.persona.historias[0].antecedentesHistoriaEntity[i].frecuencia = null;
            }
            break;
          } case this.datosSingleton.actividadFisica: {
            if (this.persona.historias[0].antecedentesHistoriaEntity[i].estadoAntecedente === "S") {
              if (this.persona.historias[0].antecedentesHistoriaEntity[i].frecuencia != null &&
                this.persona.historias[0].antecedentesHistoriaEntity[i].tipo != null) {
              } else {
                return false;
              }
            } else {
              this.persona.historias[0].antecedentesHistoriaEntity[i].frecuencia = null;
              this.persona.historias[0].antecedentesHistoriaEntity[i].tipo = null;
            }
            break;
          }
        }
      } else if (this.persona.historias[0].antecedentesHistoriaEntity[i].estadoAntecedente === "S"
        && this.persona.historias[0].antecedentesHistoriaEntity[i].despAntecedente === null) {
        return false;
      } else if (this.persona.historias[0].antecedentesHistoriaEntity[i].estadoAntecedente === "N") {
        this.persona.historias[0].antecedentesHistoriaEntity[i].despAntecedente = null
      }
    }
    return true;
  }

  private cargarListas(): void {
    this.persona.historias[0].conceptoConcepto.push(new Concepto());
    $('#conceptoIngreso').hide();
    $('#conceptoPeriodico').hide();
    $('#conceptoEgreso').hide();
    $('#formlablemenarquiasOcupacional').hide();
    $('#fromlabelCcv').hide();
    for (let i = 0; i < this.tipoAntecedente.length; i++) {
      console.log(this.tipoAntecedente[i].nomAntecedente);
      switch (this.tipoAntecedente[i].nomAntecedente) {
        case "PATOLOGICOS": {
          this.patologicos = new AntecedentesHistoria();
          this.patologicos.estadoAntecedente = "S";
          this.patologicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "QUIRURGICOS": {
          this.quirurgicos = new AntecedentesHistoria();
          this.quirurgicos.estadoAntecedente = "S";
          this.quirurgicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "ALERGICOS": {
          this.alergicos = new AntecedentesHistoria();
          this.alergicos.estadoAntecedente = "S";
          this.alergicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "FARMACOLOGICOS": {
          this.farmacologicos = new AntecedentesHistoria();
          this.farmacologicos.estadoAntecedente = "S";
          this.farmacologicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "TRAUMATICOS": {
          this.traumaticos = new AntecedentesHistoria();
          this.traumaticos.estadoAntecedente = "S";
          this.traumaticos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "TOXICOS": {
          this.toxicos = new AntecedentesHistoria();
          this.toxicos.estadoAntecedente = "S";
          this.toxicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "INMUNOLOGICOS": {
          this.inmunologicos = new AntecedentesHistoria();
          this.inmunologicos.estadoAntecedente = "S";
          this.inmunologicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "MENARQUIA": {
          this.menarquia = new AntecedentesHistoria();
          this.menarquia.estadoAntecedente = "N";
          this.menarquia.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "HOSPITALARIOS": {
          this.hospitalarios = new AntecedentesHistoria();
          this.hospitalarios.estadoAntecedente = "S";
          this.hospitalarios.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "FAMILIARES": {
          this.familiares = new AntecedentesHistoria();
          this.familiares.estadoAntecedente = "S";
          this.familiares.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "TABAQUISMO": {
          this.tabaquismo = new AntecedentesHistoria();
          this.tabaquismo.estadoAntecedente = "S";
          this.tabaquismo.tipoAntecedenteEntity = this.tipoAntecedente[i];
          this.tabaquismo.exFumador = "N";
          break;
        }
        case "CONSUMO ALCOHOL": {
          this.consumoAlcohol = new AntecedentesHistoria();
          this.consumoAlcohol.estadoAntecedente = "S";
          this.consumoAlcohol.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case this.datosSingleton.actividadFisica: {
          this.actividadFisica = new AntecedentesHistoria();
          this.actividadFisica.estadoAntecedente = "S";
          this.actividadFisica.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case "ACTIVIDAD EXTRA LABORAL": {
          this.actividadExtralaborales = new AntecedentesHistoria();
          this.actividadExtralaborales.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
      }
    }
  }

  private cargarDatosActededentesHistoria(): void {
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.patologicos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.quirurgicos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.alergicos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.farmacologicos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.traumaticos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.toxicos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.inmunologicos);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.menarquia);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.hospitalarios);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.familiares);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.tabaquismo);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.consumoAlcohol);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.actividadFisica);
    this.persona.historias[0].antecedentesHistoriaEntity.push(this.actividadExtralaborales);
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
    debugger
    this.persona.lugarNacimiento = (this.persona.lugarNacimiento == null || this.persona.lugarNacimiento.seqCuidad == null) ? per.lugarNacimiento : this.persona.lugarNacimiento;
    this.persona.lugarDeResidencia = (this.persona.lugarDeResidencia == null || this.persona.lugarDeResidencia.seqCuidad == null) ? per.lugarDeResidencia : this.persona.lugarDeResidencia;
    this.persona.escolaridad = this.persona.escolaridad == null ? per.escolaridad : this.persona.escolaridad;
    this.persona.nomCargoDep = this.persona.nomCargoDep == null ? per.nomCargoDep : this.persona.nomCargoDep;
    this.persona.afp = this.persona.afp == null ? per.afp : this.persona.afp;
    this.persona.arl = this.persona.arl == null ? per.arl : this.persona.arl;
    this.persona.aseguradora = (this.persona.aseguradora == null || this.persona.aseguradora.seqAseguradora == null) ? per.aseguradora : this.persona.aseguradora;
    debugger
    this.persona.rh = this.persona.rh == null ? per.rh : this.persona.rh;
    this.persona.nomEmergencia = this.persona.nomEmergencia == null ? per.nomEmergencia : this.persona.nomEmergencia;
    this.persona.telEmergencia = this.persona.telEmergencia == null ? per.telEmergencia : this.persona.telEmergencia;
    this.persona.parentescoEmergencia = this.persona.parentescoEmergencia == null ? per.parentescoEmergencia : this.persona.parentescoEmergencia;
    this.persona.codigo = this.persona.codigo == null ? per.codigo : this.persona.codigo;
    this.persona.grupoSanguineo = this.persona.grupoSanguineo == null ? per.grupoSanguineo : this.persona.grupoSanguineo;
    let nuevoRol = new TipoUsuario();
    nuevoRol.seqTipoUsuario = 2;
    this.persona.rolUsuario = (this.persona.rolUsuario.seqTipoUsuario == null || this.persona.rolUsuario == null) ? (per.rolUsuario == null || per.rolUsuario.seqTipoUsuario == null) ? nuevoRol : per.rolUsuario : this.persona.rolUsuario;
  }



  private buscarElementoActivar(id: string): void {
    for (let i = 0; i < this.listaElementosBLoquear.length; i++) {
      if (this.listaElementosBLoquear[i] == id) {
        this.listaElementosBLoquear.splice(i, 1);
        break;
      }
    }
  }

  private activarElementosTerceraFase(): void {
    this.sinAgregarLista = false;
    for (let i = 0; i < this.listaElementosBLoquear.length; i++) {
      this.onValidarSelect("no", this.listaElementosBLoquear[i]);
    }
    this.sinAgregarLista = true;
  }

  abrirModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  guardarDatosGrillas(grilla: string, $event): void {
    let number = 0;
    console.log($event);
    switch (grilla) {
      case "factoresRiesgo": {
        this.persona.historias[0].historiaLaboral.factoresRiesgo.push(new FactoresRiesgo());
        number = this.persona.historias[0].historiaLaboral.factoresRiesgo.length - 1;
        this.persona.historias[0].historiaLaboral.factoresRiesgo[number] = $event
        this.gridFactoresRiesgo.refresh();
        this.modalRef.hide();
        Swal.fire('Exitoso', 'Se agrego el dato en Factores Riesgo', 'success');
        break;
      }
      case "enfermedadesLaborales": {
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral());
        number = this.persona.historias[0].historiaLaboral.enfermedadesLaboral.length - 1;
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral[number] = $event;
        this.gridEnfermedades.refresh();
        this.modalRef.hide();
        Swal.fire('Exitoso', 'Se agrego el dato en Enfermedades Laborales', 'success');
        break;
      }
      case "accidentesTrabajo": {
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo());
        number = this.persona.historias[0].historiaLaboral.antecedentesTrabajo.length - 1;
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo[number] = $event;
        this.gridAntecedentesTrabajo.refresh();
        this.modalRef.hide();
        Swal.fire('Exitoso', 'Se agrego el dato en Accidentes Trabajo', 'success');
        break;
      }
      case "trabajosPrevios": {
        this.persona.historias[0].historiaLaboral.empresaLaboral.push(new EmpresaLaboral());
        number = this.persona.historias[0].historiaLaboral.empresaLaboral.length - 1;
        this.persona.historias[0].historiaLaboral.empresaLaboral[number] = $event;
        this.gridTrabajosPrevios.refresh();
        this.modalRef.hide();
        Swal.fire('Exitoso', 'Se agrego el dato en Trabajos Previos', 'success');
        break;
      }
      case "paraclinicos": {
        this.persona.historias[0].paraclinicosEntity.push(new Paraclinicos());
        number = this.persona.historias[0].paraclinicosEntity.length - 1;
        this.persona.historias[0].paraclinicosEntity[number] = $event;
        this.gridParaclinicos.refresh();
        this.modalRef.hide();
        Swal.fire('Exitoso', 'Se agrego el dato en Paraclinicos', 'success');
        break;
      }
      default:
        break;
    }
  }
  delete(id: string): void {
    switch (id) {
      case "trabajosPrevios": {
        const selectedRow: number = this.gridTrabajosPrevios.getSelectedRowIndexes()[0];
        console.log(selectedRow);
        if (this.gridTrabajosPrevios.getSelectedRowIndexes().length) {
          (this.gridTrabajosPrevios.dataSource as object[]).splice(selectedRow, 1);
          this.persona.historias[0].historiaLaboral.empresaLaboral.splice(selectedRow, 1);
        } else {
          alert('No selecciono ning�n dato para eliminar');
        }
        this.gridTrabajosPrevios.refresh();
        break;
      }
      case "accidentesTrabajo": {
        const selectedRow: number = this.gridAntecedentesTrabajo.getSelectedRowIndexes()[0];
        console.log(selectedRow);
        if (this.gridAntecedentesTrabajo.getSelectedRowIndexes().length) {
          (this.gridAntecedentesTrabajo.dataSource as object[]).splice(selectedRow, 1);
          this.persona.historias[0].historiaLaboral.antecedentesTrabajo.splice(selectedRow, 1);
        } else {
          alert('No selecciono ning�n dato para eliminar');
        }
        this.gridAntecedentesTrabajo.refresh();
        break;
      }
      case "enfermedadesLaborales": {
        const selectedRow: number = this.gridEnfermedades.getSelectedRowIndexes()[0];
        console.log(selectedRow);
        if (this.gridEnfermedades.getSelectedRowIndexes().length) {
          (this.gridEnfermedades.dataSource as object[]).splice(selectedRow, 1);
          this.persona.historias[0].historiaLaboral.enfermedadesLaboral.splice(selectedRow, 1);
        } else {
          alert('No selecciono ning�n dato para eliminar');
        }
        this.gridEnfermedades.refresh();
        break;
      }
      case "factoresRiesgo": {
        const selectedRow: number = this.gridFactoresRiesgo.getSelectedRowIndexes()[0];
        console.log(selectedRow);
        if (this.gridFactoresRiesgo.getSelectedRowIndexes().length) {
          (this.gridFactoresRiesgo.dataSource as object[]).splice(selectedRow, 1);
          this.persona.historias[0].historiaLaboral.factoresRiesgo.splice(selectedRow, 1);
        } else {
          alert('No selecciono ning�n dato para eliminar');
        }
        this.gridFactoresRiesgo.refresh();
        break;
      }
      case "paraclinicos": {
        const selectedRow: number = this.gridParaclinicos.getSelectedRowIndexes()[0];
        console.log(selectedRow);
        if (this.gridParaclinicos.getSelectedRowIndexes().length) {
          (this.gridParaclinicos.dataSource as object[]).splice(selectedRow, 1);
          this.persona.historias[0].paraclinicosEntity.splice(selectedRow, 1);
        } else {
          alert('No selecciono ning�n dato para eliminar');
        }
        this.gridParaclinicos.refresh();
        break;
      }
    }
  }

  onLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }

  getTipoDocumento(): void {
    this.personaService.getTipoDocumento().subscribe(
      (respuesta) => {
        this.tipoDocumento = respuesta
        console.log(respuesta)
      }
    )
  }

  getConcepto(): void {
    this.historiaService.getConcepto().subscribe(
      (respuesta) => {
        this.concepto = respuesta
        this.getListConcepto();
      }
    )
  }

  getImpresionDiagnostica(): void {
    this.historiaService.getImpresionDiagnostica().subscribe(
      (respuesta) => {
        this.diagnostica = respuesta;
      }
    )
  }

  private getListConcepto(): void {
    for (let i = 0; i < this.concepto.length; i++) {
      switch (this.concepto[i].tipoConcepto) {
        case "INGRESO": {
          this.conceptoIngreso.push(this.concepto[i]);
          break;
        }
        case "PERIODICOS": {
          this.conceptoPeriodico.push(this.concepto[i]);
          break;
        }
        case "EGRESO": {
          this.conceptoEgreso.push(this.concepto[i]);
          break;
        }
      }
    }
  }

  getCiudad(): void {
    this.personaService.getCiudad().subscribe(
      (respuesta) => {
        this.ciudad = respuesta
        console.log(respuesta)
      }
    )
  }

  getAseguradora(): void {
    this.personaService.getAseguradora().subscribe(
      (respuesta) => {
        this.aseguradora = respuesta
        console.log(respuesta)
      }
    )
  }

  getTipoAntecedente(): void {
    this.historiaService.getTipoAntecedente().subscribe(
      (respuesta) => {
        this.tipoAntecedente = respuesta;
        this.cargarListas();
        this.getConcepto();
      }
    )
  }

  getTipoEvaluacion(): void {
    this.historiaService.getTipoEvaluacion().subscribe(
      (respuesta) => {
        this.tipoEvaluacion = respuesta;
      }
    )
  }

  getTipoHistoria(): void {
    this.historiaService.getTipoHistorias().subscribe(
      (respuesta) => {
        this.tipoHistoria = respuesta;
      }
    )
    for (let i = 0; i < this.tipoHistoria.length; i++) {
      if (this.tipoHistoria[i].nomTipoHistoria === "OCUPACIONAL") {
        this.persona.historias[0].seqTipoHistoria = this.tipoHistoria[i];
      }
    }
  }

  getAnosHabitosList(): void {
    for (let i = 1; i <= 40; i++) {
      this.listAnosHabito.push(i);
    }
  }

  getPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos.crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos.crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos.gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos.descargar;
  }

  getTipoUsuario(): void {
    this.historiaService.getTipoUsuario().subscribe(
      (respuesta) => {
        this.tipoUsuario = respuesta
        console.log(respuesta)
      }
    )
  }

  getAuxOMedico(): void {
    if (this.permiso.crearUsuario === 0) {
      if (this.permiso.crearAux === 1) {
        this.aux = true;
        this.medico = false;
      }
    } else if (this.permiso.crearUsuario === 1) {
      this.medico = true;
    }
  }
}
