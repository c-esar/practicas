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
import { Router } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import { FormControl } from '@angular/forms';
import Swal from 'sweetalert2';
import { HistoriaGym } from '../DatosBean/historiaGym';
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
  medico: boolean;
  aux: boolean;
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
    this.persona.historiaGym = new Array<HistoriaGym>();
    debugger
    this.permiso = new Permiso();
    this.tipoUsuario = new Array<TipoUsuario>();
    this.datosSingleton = new DatosSingleton();
    this.Spersona = new Persona();
    this.buscoPerson = false;
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getAuxOMedico();
    this.onLabels();
    this.getTipoDocumento();
    this.getCiudad();
    this.getAseguradora();
    this.getTipoUsuario();
    this.onActivarSubMenu("DatosPricipales");

  }


  public onValidatePersona(): void {
    let tmpDoc = this.persona.numeroDocumento;
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
    if (this.permiso.crearUsuario === 0) {
      if (this.permiso.crearAux === 1) {
        this.aux = true;
      }
    } else if (this.permiso.crearUsuario === 1) {
      this.medico = true;
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

  private getPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos.crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos.crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos.gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos.descargar;
    console.log(this.permiso.crearAux);
  }

}
