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
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
//ng add ngx-bootstrap
import { GridComponent } from '@syncfusion/ej2-angular-grids';
import { PageSettingsModel } from '@syncfusion/ej2-angular-grids';
import { DiagnosticoOcupacional } from '../DatosBean/diagnosticoOcupacional';
import Swal from 'sweetalert2';
import { FormControl } from '@angular/forms';
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
  buscoPerson: boolean;
  permiso: Permiso;
  datosSingleton: DatosSingleton;
  tipoDocumento: TipoDocumento[];
  ciudad: Ciudad[];
  aseguradora: Aseguradora[];
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
  tipoAntecedente: TipoAntecedente[];
  concepto: Concepto[];
  conceptoIngreso: Concepto[];
  conceptoPeriodico: Concepto[];
  conceptoEgreso: Concepto[];
  diagnostica: DiagnosticoOcupacional[];
  //lista elementos a bloquear
  listaElementosBLoquear: string[];
  sinAgregarLista: boolean;
  listAnosHabito: number[];
  //tipo evaluacion
  tipoEvaluacion: string[];
  tipoEvaluacionSelecionado: string;
  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService,
    private modalService: BsModalService) {
  }

  ngOnInit(): void {
    this.onCargarAtributos();
    this.onCargarFunciones();
    this.getAnosHabitosList();
    this.pageSettings = { pageSize: 6 };
  }

  onCargarAtributos(): void {
    this.conceptoIngreso = new Array<Concepto>();
    this.conceptoPeriodico = new Array<Concepto>();
    this.conceptoEgreso = new Array<Concepto>();
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.examenFisico = new ExamenFisico();
    this.buscoPerson = false;
    this.listaElementosBLoquear = new Array<string>();
    this.listAnosHabito = new Array<number>();
    this.sinAgregarLista = true;
    $('#formOtroEvaluacion').hide();
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getAuxOMedico();
    this.onLabels();
    this.tipoEvaluacion = ["INGRESO", "PERIÓDICO", "EGRESO", "OTRO"];
    this.onActivarSubMenu("DatosPricipales");
    this.getTipoDocumento();
    this.getCiudad();
    this.getAseguradora();
    this.getTipoAntecedente();
    this.getImpresionDiagnostica();
  }

  public onValidatePersona(): void {
    this.persona.rolUsuario = this.PERSONA_PACIENTE;
    this.Spersona = new Persona();
    debugger
    this.personaService.onBuscarDocumento(this.persona).subscribe(
      (respuesta) => {
        if (respuesta == null || respuesta.nomPrimerNombre == null) {
          this.Spersona = new Persona();
          this.persona = new Persona();
          this.cargarListas();
          this.buscoPerson = false;
          this.ActivarRequerido();
          Swal.fire('Error', 'Persona No Registrada', 'error');
        } else {
          this.Spersona = respuesta;
          this.persona.seqPersona = this.Spersona.seqPersona
          this.desactivarRequerido();
          this.buscoPerson = true;
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      }
    );
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
      debugger;
      if (this.sinAgregarLista) {
        this.listaElementosBLoquear.push(id);
      }
      switch (id) {
        case "formlabelCualPatologicosEsOcupacional": {
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
    console.log($event);
    $('#formOtroEvaluacion').hide();
    $('#conceptoPeriodico').hide();
    $('#conceptoEgreso').hide();
    this.persona.historias[0].otroEvaluacion = null;
    switch ($event.value) {
      case "INGRESO": {
        this.persona.historias[0].tipoEvaluacionEntity.seqEval = 1;
        $('#conceptoIngreso').show();
        break;
      }
      case this.datosSingleton.labelPeriodico: {
        this.persona.historias[0].tipoEvaluacionEntity.seqEval = 2;
        $('#conceptoPeriodico').show();
        break;
      }
      case "EGRESO": {
        this.persona.historias[0].tipoEvaluacionEntity.seqEval = 3;
        $('#conceptoEgreso').show();
        break;
      }
      case "OTRO": {
        this.persona.historias[0].tipoEvaluacionEntity.seqEval = 4;
        $('#formOtroEvaluacion').show();
        $('#formOtroEvaluacion').show();
        $('#conceptoPeriodico').show();
        $('#conceptoEgreso').show();
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
        if (this.permiso.crearUsuario == 0) {
          if (this.permiso.crearAux == 1) {
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
    this.persona.localidad.seqLocalidad = 0;
    this.persona.lugarDeResidencia.seqCuidad = 0;
    this.persona.rolUsuario = this.PERSONA_PACIENTE;
    debugger
    let validarfrom: string = this.onValidarFrom();
    if (validarfrom === "1") {
      if (this.permiso.crearUsuario == 1) {
        if (this.buscoPerson) {
          this.actualizarPerson(this.Spersona);
        }
        this.cargarDatosActededentesHistoria();
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
    } else {
      Swal.fire('Error', validarfrom, 'error');
    }
  }

  private cargarListas(): void {
    this.persona.historias.push(new Historias());
    this.persona.historias[0].concepto.push(new Concepto());
    $('#conceptoIngreso').hide();
    $('#conceptoPeriodico').hide();
    $('#conceptoEgreso').hide();
    for (let i = 0; i < this.tipoAntecedente.length; i++) {
      switch (this.tipoAntecedente[i].seqTipoAntecedente) {
        case 1: {
          this.patologicos = new AntecedentesHistoria();
          this.patologicos.estadoAntecedente = "S";
          this.patologicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 2: {
          this.quirurgicos = new AntecedentesHistoria();
          this.quirurgicos.estadoAntecedente = "S";
          this.quirurgicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 3: {
          this.alergicos = new AntecedentesHistoria();
          this.alergicos.estadoAntecedente = "S";
          this.alergicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 4: {
          this.farmacologicos = new AntecedentesHistoria();
          this.farmacologicos.estadoAntecedente = "S";
          this.farmacologicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 5: {
          this.traumaticos = new AntecedentesHistoria();
          this.traumaticos.estadoAntecedente = "S";
          this.traumaticos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 6: {
          this.toxicos = new AntecedentesHistoria();
          this.toxicos.estadoAntecedente = "S";
          this.toxicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 7: {
          this.inmunologicos = new AntecedentesHistoria();
          this.inmunologicos.estadoAntecedente = "S";
          this.inmunologicos.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 8: {
          this.hospitalarios = new AntecedentesHistoria();
          this.hospitalarios.estadoAntecedente = "S";
          this.hospitalarios.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 9: {
          this.familiares = new AntecedentesHistoria();
          this.familiares.estadoAntecedente = "S";
          this.familiares.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 10: {
          this.tabaquismo = new AntecedentesHistoria();
          this.tabaquismo.estadoAntecedente = "S";
          this.tabaquismo.tipoAntecedenteEntity = this.tipoAntecedente[i];
          this.tabaquismo.exFumador = "N";
          break;
        }
        case 11: {
          this.consumoAlcohol = new AntecedentesHistoria();
          this.consumoAlcohol.estadoAntecedente = "S";
          this.consumoAlcohol.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 12: {
          this.actividadFisica = new AntecedentesHistoria();
          this.actividadFisica.estadoAntecedente = "S";
          this.actividadFisica.tipoAntecedenteEntity = this.tipoAntecedente[i];
          break;
        }
        case 13: {
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

  public onValidarFrom(): string {
    if (!(this.persona.nomPrimerNombre != null &&
      this.persona.nomPrimerApellido != null &&
      this.persona.nomSegundoNombre != null &&
      this.persona.nomSegundoApellido != null)) {
      if (!(this.persona.tipoDocumento.seqTipoDocumento != null &&
        this.persona.numeroDocumento != null &&
        this.persona.edad != null &&
        this.persona.direccion != null &&
        this.persona.telefono != null &&
        this.persona.celular != null &&
        this.persona.genero != null &&
        this.persona.estadoCivil != null &&
        this.persona.lugarNacimiento.seqCuidad != null &&
        this.persona.lugarDeResidencia.seqCuidad != null &&
        this.persona.escolaridad != null &&
        this.persona.nomCargoDep != null &&
        this.persona.afp != null &&
        this.persona.arl != null &&
        this.persona.aseguradora.seqAseguradora != null)) {
        return "1";
      } else {
        return "FALTA COMPLETAR CAMPOS SECCION DATOS PRINCIPALES";
      }
    } else // NOMBRES
    {
      return "FALTA COMPLETAR NOMBRES O APELLIDOS";
    }
  }

  private desactivarRequerido(): void {
    //$('#formPrimerApellidoOcupacional').removeAttr("aria-required");
    document.getElementById("formPrimerApellidoOcupacional").removeAttribute("required");
  }

  private ActivarRequerido(): void {
    //$('#formPrimerApellidoOcupacional').prop("aria-required", true);
    document.getElementById("formPrimerApellidoOcupacional").setAttribute("required", "true");
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
        this.persona.historias[0].paraclinicos.push(new Paraclinicos());
        number = this.persona.historias[0].paraclinicos.length - 1;
        this.persona.historias[0].paraclinicos[number] = $event;
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
          this.persona.historias[0].paraclinicos.splice(selectedRow, 1);
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
