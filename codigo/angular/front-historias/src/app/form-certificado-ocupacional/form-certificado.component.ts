import { Component, OnInit } from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { Persona } from '../DatosBean/persona';
import { Certificado } from '../DatosBean/certificado';
import { Historias } from '../DatosBean/historias';
import { Router, ActivatedRoute } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import { FormControl } from '@angular/forms';
import Swal from 'sweetalert2';
import { TipoEvaluacion } from '../DatosBean/tipoEvaluacion';
import { of, Observable, throwError } from 'rxjs';
import { UserIdleService } from 'angular-user-idle';
import { ReportesService } from '../Servicios/reportes.service';
declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-form-certificado',
  templateUrl: './form-certificado.component.html',
  styleUrls: ['./form-certificado.component.css']
})
export class FormCertificadoComponent implements OnInit {

  persona: Persona;
  date = new FormControl(new Date());
  date2 = new FormControl(new Date());
  Spersona: Persona;
  buscoPerson: boolean;
  permiso: Permiso;
  tipoEvaluacion: TipoEvaluacion[];
  certificado: Certificado;
  ruta: String;
  nombreArchivo: string;
  historia: Historias;
  entre: boolean;
  //constantes
  private PERSONA_PACIENTE: string = "Paciente";

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private router: Router,
    private historiaService: HistoriasService,
    private userIdle: UserIdleService,
    private activatedRoute: ActivatedRoute,
    private reportes: ReportesService
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
      this.verificarCertificado();
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

  verificarCertificado(): void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if (id) {
        this.onVerificarCertificado(id);
        this.certificado.seqHistoria.seqHistoria = id;
      }
    });
  }

  onVerificarCertificado(id): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Cargando Informacion',
        timer: 3000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);
    setTimeout(() => {
      this.historiaService.buscarCertificado(id).subscribe(
        (respuesta) => {
          if (respuesta.seqCertificado != null || respuesta.seqCertificado != undefined) {
            this.onReporteCertificado(respuesta.seqCertificado);
          } else {
            this.onObtenerDatospersonas(respuesta.seqHistoria);
            Swal.fire('Error', 'No se encuentra certificado guardado', 'error');
          }
        });
    }, 1000);
  }

  private onObtenerDatospersonas(id: Historias): void {
    this.certificado.nombre = id.persona.nomPrimerNombre + " " + id.persona.nomSegundoNombre + " " +
    id.persona.nomPrimerApellido + " " + id.persona.nomSegundoApellido;
    this.certificado.numero = id.persona.numeroDocumento;
    this.onOpcionEvaluacionPersona(id);
  }

  onOpcionEvaluacionPersona(historia: Historias): void {
    this.certificado.otroEvaluacion = null;
    $('#formOtroEvaluacion').hide();
    switch (historia.tipoEvaluacionEntity.nomEval) {
      case "INGRESO": {
        this.certificado.tipoEvaluacionEntity = historia.tipoEvaluacionEntity;
        break;
      }
      case "PERIÓDICO": {
        this.certificado.tipoEvaluacionEntity = historia.tipoEvaluacionEntity;
        break;
      }
      case "EGRESO": {
        this.certificado.tipoEvaluacionEntity = historia.tipoEvaluacionEntity;
        break;
      }
      case "OTRO": {
        this.certificado.tipoEvaluacionEntity = historia.tipoEvaluacionEntity;
        $('#formOtroEvaluacion').show();
        this.certificado.otroEvaluacion = historia.otroEvaluacion;
        break;
      }
    }
  }

  onReporteCertificado(seqCertificado: number): void {
    this.entre = false;
    this.reportes.onReporteHistoriasCertificado(seqCertificado).subscribe(
      (respuesta) => {
        this.ruta = respuesta;
        this.nombreArchivo = "certificado.pdf";
        const linkSource = 'data:application/pdf;base64,' + respuesta;
        const downloadLink = document.createElement("a");
        const fileName = this.nombreArchivo;
        downloadLink.href = linkSource;
        downloadLink.download = fileName;
        downloadLink.click();
      }
    )
    this.router.navigate(['menuPrincipal']);
  }
  onCargarAtributos(): void {
    this.certificado = new Certificado();
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.Spersona = new Persona();
    this.buscoPerson = false;
    this.entre = true;
    $('#formOtroEvaluacion').hide();
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getTipoEvaluacion();
  }

  getTipoEvaluacion(): void {
    this.historiaService.getTipoEvaluacion().subscribe(
      (respuesta) => {
        this.tipoEvaluacion = respuesta;
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

  guardar(): void {
    this.historiaService.createCertificado(this.certificado).subscribe(
      (respuesta) => {
        debugger
        if (respuesta == null) {
          Swal.fire('Error', 'Problemas al guardar', 'error');
        } else {
          Swal.fire('Exitoso', 'Certificado Creado Se puede Descargar', 'success');
          //this.onVerificarCertificado(respuesta);
          this.onReporteCertificado(respuesta);
        }
      });
  }
}