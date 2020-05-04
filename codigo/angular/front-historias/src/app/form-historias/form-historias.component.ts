import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { LabelService } from '../Servicios/label.service';
import { FilessService } from '../Servicios/filess.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import { Persona } from '../DatosBean/persona';
import { ArchivosFileHistoria } from '../DatosBean/archivosfilehistoria';
import Swal from 'sweetalert2';
import { Permiso } from '../DatosBean/permiso';
import { ReportesService } from '../Servicios/reportes.service';
@Component({
  selector: 'app-form-historias',
  templateUrl: './form-historias.component.html',
  styleUrls: ['./form-historias.component.css']
})
export class FormHistoriasComponent implements OnInit {
  displayedColumns: string[] = ['Tipo Documento', 'No.', 'Nombre', 'Apellido', 'Tipo Historia', 'Fecha Historia', 'Detalle'];
  dataSource = new MatTableDataSource(null);
  datosSingleton: DatosSingleton;
  tmp: String[];
  Datos: Persona[];
  permiso: Permiso;
  filtro: boolean;
  archivoFile: ArchivosFileHistoria[];
  persona: Persona;
  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private historiaService: HistoriasService,
    private filesService: FilessService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private reportes: ReportesService) {
  }

  ngOnInit(): void {
    this.onCargarAtributos();
    this.onCargarFunciones();
    this.obtenerPermisos();
    this.cargarHisotrias();
  }

  onCargarHistorias(): void {

  }
  onCargarAtributos(): void {
    this.datosSingleton = new DatosSingleton();
    this.permiso = new Permiso();
    this.Datos = new Array<Persona>();
    this.filtro = false;
    this.archivoFile = new Array<ArchivosFileHistoria>();
    this.persona = new Persona();
  }

  applyFilter(event: Event) {
    this.filtro = true;
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onCargarFunciones(): void {
    this.onLabels();
  }



  exportAsXLSX(): void {
    if (this.filtro) {
      this.filesService.exportToExcel(this.dataSource.filteredData, 'my_export');
    } else {
      this.filesService.exportToExcel(this.dataSource.data, 'my_export');
    }
  }

  exportAsXLSXFilter(): void {
  }

  private obtenerPermisos(): void {
    debugger
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos[0].crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos[0].crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos[0].gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos[0].descargar;
    if (this.permiso.crearAux === 1 && this.permiso.crearUsuario === 1) {
      this.permiso.crearAux = 0;
    }
  }

  private onLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }

  cargarHisotrias(): void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if (id) {
        this.onValidatePersona(id);
      }
    });
  }

  private onValidatePersona(id: string): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Buscando',
        timer: 10000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      this.persona.numeroDocumento = id;
      this.personaService.onBuscarDocumento(this.persona).subscribe(
        (respuesta) => {
          debugger
          console.log(respuesta);
          this.persona = respuesta;
          let nombre = this.persona.nomPrimerNombre;
          let apellido = this.persona.nomPrimerApellido;
          let documento = this.persona.numeroDocumento;
          let tipoDocumento = this.persona.tipoDocumento.nomDocumento;

          if (this.persona.nomSegundoNombre === null) {
            nombre = nombre + "";
          } else {
            nombre = nombre + " " + this.persona.nomSegundoNombre;
          }
          if (this.persona.nomSegundoApellido === null) {
            apellido = apellido + "";
          } else {
            apellido = apellido + " " + this.persona.nomSegundoApellido;
          }
          if (this.persona.historias.length > 0) {
            for (let i = 0; i < this.persona.historias.length; i++) {
              this.archivoFile.push(new ArchivosFileHistoria(nombre, apellido,
                documento, tipoDocumento,
                this.persona.historias[i].seqTipoHistoria.nomTipoHistoria,
                this.persona.historias[i].diaHistoria));
            }
          }

          if (this.persona.historiasGym.length > 0) {
            for (let i = 0; i < this.persona.historiasGym.length; i++) {
              this.archivoFile.push(new ArchivosFileHistoria(nombre, apellido,
                documento, tipoDocumento,
                this.persona.historiasGym[i].seqTipoHistoria.nomTipoHistoria,
                this.persona.historiasGym[i].diaHistoriaGym));
            }
          }

          if (this.archivoFile.length > 0) {
            Swal.fire('Exitoso', 'Persona tiene Historias', 'success');
            this.dataSource = new MatTableDataSource(this.archivoFile);
          } else {
            Swal.fire('Error', 'Error No tiene Historias ', 'error');
            this.router.navigate(['menuPrincipal/list-usuariosApp'])
          }
        }
      );
    }, 1000);
  }

  public descargarDetalle(documento: string, tipo: string): void {
    debugger
    if (tipo === "OCUPACIONAL") {
      this.reportes.onReporteHistoriasOcupacional(documento).subscribe(
        (respuesta) => {
          Swal.fire('Exitoso', ""+respuesta, 'success');
        }
      )
    } else if (tipo === "GYM") {
      this.reportes.onReporteHistoriasGym(documento).subscribe(
        (respuesta) => {
          Swal.fire('Exitoso', ''+respuesta, 'success');
        }
      )
    }
  }
}
