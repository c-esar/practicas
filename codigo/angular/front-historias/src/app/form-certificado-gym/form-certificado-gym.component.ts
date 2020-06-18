import { Component, OnInit } from '@angular/core';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { Persona } from '../DatosBean/persona';
import { CertificadoGym } from '../DatosBean/certificadogym';
import { Router, ActivatedRoute } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import { FormControl } from '@angular/forms';
import Swal from 'sweetalert2';
import { TipoEvaluacion } from '../DatosBean/tipoEvaluacion';
import { of, Observable, throwError } from 'rxjs';
import { UserIdleService } from 'angular-user-idle';
import { ReportesService } from '../Servicios/reportes.service';
import { TipoEvaluacionFisica } from '../DatosBean/TipoEvaluacionFisicaEntity';
import { HistoriaGym } from '../DatosBean/historiaGym';
declare var jQuery: any;
declare var $: any;

@Component({
  selector: 'app-form-certificado-gym',
  templateUrl: './form-certificado-gym.component.html',
  styleUrls: ['./form-certificado-gym.component.css']
})
export class FormCertificadoGymComponent implements OnInit {

  persona: Persona;
  date = new FormControl(new Date());
  date2 = new FormControl(new Date());
  Spersona: Persona;
  buscoPerson: boolean;
  permiso: Permiso;
  tipoEvaluacion: TipoEvaluacionFisica[];
  certificado: CertificadoGym;
  ruta: String;
  nombreArchivo: string;
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
        this.certificado.seqHistoria.seqHistoriaGym = id;
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
      this.historiaService.buscarCertificadoGym(id).subscribe(
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

  private onObtenerDatospersonas(id: HistoriaGym): void {
    this.certificado.nombre = id.persona.nomPrimerNombre + " " + id.persona.nomSegundoNombre + " " +
    id.persona.nomPrimerApellido + " " + id.persona.nomSegundoApellido;
    this.certificado.numero = id.persona.numeroDocumento;
  }

  onOpcionEvaluacion($event): void {
    switch ($event.value.nomEval) {
      case this.tipoEvaluacion[0].nomEval: {
        this.certificado.tipoEvaluacionFisicaEntity = $event.value;
        break;
      }
      case this.tipoEvaluacion[1].nomEval: {
        this.certificado.tipoEvaluacionFisicaEntity = $event.value;
        break;
      }
      case this.tipoEvaluacion[2].nomEval: {
        this.certificado.tipoEvaluacionFisicaEntity = $event.value;
        break;
      }
      case this.tipoEvaluacion[3].nomEval: {
        this.certificado.tipoEvaluacionFisicaEntity = $event.value;
        break;
      }
    }
  }

  //creacion reporte gym
  onReporteCertificado(seqCertificado: number): void {
    this.reportes.onReporteHistoriasCertificadoGym(seqCertificado).subscribe(
      (respuesta) => {
        this.ruta = respuesta;
        this.nombreArchivo = "certificadoGym.pdf";
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
    this.certificado = new CertificadoGym();
    this.persona = new Persona();
    this.permiso = new Permiso();
    this.Spersona = new Persona();
    this.buscoPerson = false;
    $('#formOtroEvaluacion').hide();
  }

  onCargarFunciones(): void {
    this.getPermisos();
    this.getTipoEvaluacion();
  }

  getTipoEvaluacion(): void {
    this.historiaService.getTipoEvaluacionFisica().subscribe(
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
    this.historiaService.createCertificadoGym(this.certificado).subscribe(
      (respuesta) => {
        if (respuesta == null) {
          Swal.fire('Error', 'Problemas al guardar', 'error');
        } else {
          Swal.fire('Exitoso', 'Certificado Creado Se puede Descargar', 'success');
          //this.onVerificarCertificado(respuesta);
          this.onReporteCertificado(respuesta);
        }
      })
  }

}
