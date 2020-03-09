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
import { Router } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import { Historias } from '../DatosBean/historias';
import { HistoriaLaboral } from '../DatosBean/historiaLaboral';
import { EmpresaLaboral } from '../DatosBean/empresaLaboral';
import { AntecedentesTrabajo } from '../DatosBean/antecedentesTrabajo';
import { AntecedentesHistoria } from '../DatosBean/antecedentesHistoria';
import { EnfermedadesLaboral } from '../DatosBean/enfermedadesLaboral';
import { FactoresRiesgo } from '../DatosBean/factoresRiesgo';

import Swal from 'sweetalert2';
declare var jQuery: any;
declare var $: any;


@Component({
  selector: 'app-form-gym',
  templateUrl: './form-gym.component.html',
  styleUrls: ['./form-gym.component.css']
})
export class FormGymComponent implements OnInit {

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
  datosExamenFisico: boolean;
  datosFinalFormulario: boolean;
  medico: boolean;
  aux: boolean;
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
    this.persona.rolUsuario = this.PERSONA_PACIENTE;
    this.personaService.onBuscarDocumento(this.persona).subscribe(
      respuesta => {
        debugger
        if (respuesta == null || respuesta.nomPrimerNombre == null) {
          this.Spersona = new Persona();
          this.buscoPerson = false;
          Swal.fire('Error', 'Persona No Registrada', 'error');
        } else {
          this.Spersona = respuesta;
          if (this.permiso.crearAux == 1) {
            this.Spersona.historias = null;
          }
          this.buscoPerson = true;
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
      }
    );
  }

  public onValidarSelect(value: string, id: string): void {
    console.log("entre validar select");
    if (value == "si") {
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
    //$("#formlabelCualPatologicosEsOcupacional").attr("disabled", "disabled");
    //$('#formlabelCualPatologicosEsOcupacional').removeAttr('required');​​​​​
    //$('#formlabelCualPatologicosEsOcupacional').prop('required', false);
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
        this.datosExamenFisico = false;
        this.datosFinalFormulario = false;
        break;
      }
      case "DatosHistoriaLaboral": {
        this.activarSubMenu(id);
        this.datosPersonales = false;
        this.datosHistoriaLaboral = true;
        this.datosTerceraFase = false;
        this.datosExamenFisico = false;
        this.datosFinalFormulario = false;
        break;
      }
      case "DatosTerceraFase": {
        this.activarSubMenu(id);
        this.datosPersonales = false;
        this.datosHistoriaLaboral = false;
        this.datosTerceraFase = true;
        this.datosExamenFisico = false;
        this.datosFinalFormulario = false;
        break;
      }
      case "DatosExamenFisico": {
        this.activarSubMenu(id);
        this.datosPersonales = false;
        this.datosHistoriaLaboral = false;
        this.datosTerceraFase = false;
        this.datosExamenFisico = true;
        this.datosFinalFormulario = false;
        break;
      }
      case "DatosFinalFormulario": {
        this.activarSubMenu(id);
        this.datosPersonales = false;
        this.datosHistoriaLaboral = false;
        this.datosTerceraFase = false;
        this.datosExamenFisico = false;
        this.datosFinalFormulario = true;
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
    this.persona.rolUsuario = this.PERSONA_PACIENTE;
    if (this.permiso.crearAux == 1) {
      this.persona.historias = null;
    } else if (this.permiso.crearUsuario == 1) {
      this.verificarEntityHistoriaLaboral();
    }
    console.log(this.persona)
    this.personaService.create(this.persona).subscribe(
      response => {
        console.log(response);
        if(response == null){
          Swal.fire('Error', 'Persona No Registrada', 'error');
        }else{
          Swal.fire('Exitoso', 'Persona Registrada', 'success');
        }
        this.router.navigate(['/menuPrincipal'])
      }
    );
  }

  private verificarEntityHistoriaLaboral(): void {
    this.createEmpresa();
    this.createAntecedentes();
    this.createEnfermedades();
    this.createFactoresRiesgo();
  }

  private createEmpresa(): void {
    for (let i = 0; i < this.persona.historias[0].historiaLaboral.empresaLaboral.length; i++) {
      if (!(this.persona.historias[0].historiaLaboral.empresaLaboral[i].cargo != null &&
        this.persona.historias[0].historiaLaboral.empresaLaboral[i].nomEmpresa != null &&
        this.persona.historias[0].historiaLaboral.empresaLaboral[i].tiempo != null)) {
        this.persona.historias[0].historiaLaboral.empresaLaboral.splice(i, 1);
        //this.historiaService.createEmpresa(this.persona.historias[0].historiaLaboral.empresaLaboral[i]).subscribe(
        //  (respuesta) => {
        //    this.persona.historias[0].historiaLaboral.empresaLaboral[i] = respuesta;
        //    console.log(respuesta);
        //  }
        //);
      }
    }

  }

  private createAntecedentes(): void {
    debugger
    for (let i = 0; i < this.persona.historias[0].historiaLaboral.antecedentesTrabajo.length; i++) {
      if (!(this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i].despCaus != null &&
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i].despIncapacidad != null &&
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i].despSecuelas != null &&
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i].fechaAnt != null &&
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i].nomEmpresa != null &&
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i].tipoLesion != null)) {
        this.persona.historias[0].historiaLaboral.antecedentesTrabajo.splice(i, 1);
        //this.historiaService.createAntecedentes(this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i]).subscribe(
        //  (respuesta) => {
        //    this.persona.historias[0].historiaLaboral.antecedentesTrabajo[i] = respuesta;
        //    console.log(respuesta);
        //  }
        //);
      }
    }
  }

  private createEnfermedades(): void {
    for (let i = 0; i < this.persona.historias[0].historiaLaboral.enfermedadesLaboral.length; i++) {
      if (!(this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i].despDiagnostico != null &&
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i].despIndemnizar != null &&
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i].despRecomendaciones != null &&
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i].fechaAnt != null &&
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i].nomEmpresa != null)) {
        this.persona.historias[0].historiaLaboral.enfermedadesLaboral.splice(i, 1);
        //this.historiaService.createEnfermedades(this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i]).subscribe(
        //  (respuesta) => {
        //    this.persona.historias[0].historiaLaboral.enfermedadesLaboral[i] = respuesta;
        //    console.log(respuesta);
        //  }
        //);

      }
    }
  }

  private createFactoresRiesgo(): void {
    for (let i = 0; i < this.persona.historias[0].historiaLaboral.factoresRiesgo.length; i++) {
      if (!(this.persona.historias[0].historiaLaboral.factoresRiesgo[i].despFactores != null &&
        this.persona.historias[0].historiaLaboral.factoresRiesgo[i].despMedidasControl != null &&
        this.persona.historias[0].historiaLaboral.factoresRiesgo[i].nomEmpresa != null &&
        this.persona.historias[0].historiaLaboral.factoresRiesgo[i].tiempo != null)) {
        this.persona.historias[0].historiaLaboral.factoresRiesgo.splice(i, 1);
        //this.historiaService.createFactoresRiesgo(this.persona.historias[0].historiaLaboral.factoresRiesgo[i]).subscribe(
        //  (respuesta) => {
        //    this.persona.historias[0].historiaLaboral.factoresRiesgo[i] = respuesta;
        //    console.log(respuesta);
        //  }
        //);
      }
    }
  }

  private cargarListas(): void {
    this.persona.historias.push(new Historias);
    this.persona.historias[0].historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias[0].historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias[0].historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias[0].historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias[0].historiaLaboral.empresaLaboral.push(new EmpresaLaboral);
    this.persona.historias[0].historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias[0].historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias[0].historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias[0].historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias[0].historiaLaboral.antecedentesTrabajo.push(new AntecedentesTrabajo);
    this.persona.historias[0].historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias[0].historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias[0].historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias[0].historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias[0].historiaLaboral.enfermedadesLaboral.push(new EnfermedadesLaboral);
    this.persona.historias[0].historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias[0].historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias[0].historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias[0].historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.persona.historias[0].historiaLaboral.factoresRiesgo.push(new FactoresRiesgo);
    this.patologicos = new AntecedentesHistoria();
    this.quirurgicos= new AntecedentesHistoria();
    this.alergicos= new AntecedentesHistoria();
    this.farmacologicos= new AntecedentesHistoria();
    this.traumaticos= new AntecedentesHistoria();
    this.toxicos= new AntecedentesHistoria();
    this.inmunologicos= new AntecedentesHistoria();
    this.hospitalarios= new AntecedentesHistoria();
    this.familiares= new AntecedentesHistoria();
    this.tabaquismo= new AntecedentesHistoria();
    this.consumoAlcohol= new AntecedentesHistoria();
    this.actividadFisica= new AntecedentesHistoria();
    this.actividadExtralaborales= new AntecedentesHistoria();
  }

}
