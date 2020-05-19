import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { LabelService } from '../Servicios/label.service';
import { FilessService } from '../Servicios/filess.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import { Persona } from '../DatosBean/persona';
import { ArchivosFile } from '../DatosBean/archivosfile';
import Swal from 'sweetalert2';
import { Permiso } from '../DatosBean/permiso';
import { UserIdleService } from 'angular-user-idle';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-usuarios-app',
  templateUrl: './list-usuarios-app.component.html',
  styleUrls: ['./list-usuarios-app.component.css']
})
export class ListUsuariosAppComponent implements OnInit {
  displayedColumns: string[] = ['Tipo Documento', 'No.', 'Nombre', 'Apellido', 'Celular', 'boton'];
  dataSource = new MatTableDataSource(null);
  datosSingleton: DatosSingleton;
  tipoUsuario: TipoUsuario[];
  tipoUsuarioSelecionado: TipoUsuario[];
  tmp: String[];
  Datos: Persona[];
  permiso: Permiso;
  filtro: boolean;
  archivoFile: ArchivosFile[];
  u: boolean = false;

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private historiaService: HistoriasService,
    private filesService: FilessService,
    private userIdle: UserIdleService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.onCargarAtributos();
    this.onCargarFunciones();
    this.obtenerPermisos();
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
    this.tipoUsuario = new Array<TipoUsuario>();
    this.datosSingleton = new DatosSingleton();
    this.tipoUsuarioSelecionado = new Array<TipoUsuario>();
    this.permiso = new Permiso();
    this.Datos = new Array<Persona>();
    this.filtro = false;
    this.archivoFile = new Array<ArchivosFile>();
  }

  applyFilter(event: Event) {
    this.filtro = true;
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onCargarFunciones(): void {
    this.onLabels();
    this.getTipoUsuario();
  }

  onBuscarTipo(): void {
    this.tmp = new Array<String>();
    this.dataSource = new MatTableDataSource(null);
    this.archivoFile = new Array<ArchivosFile>();
    if (this.tipoUsuarioSelecionado.length > 0) {
      for (let i = 0; i < this.tipoUsuarioSelecionado.length; i++) {
        this.tmp.push(this.tipoUsuarioSelecionado[i].seqTipoUsuario.toString());
      }
      this.getDatosTabla();
    } else {
      Swal.fire('Error', 'Debe seleccionar un item de la lista', 'error');
      document.getElementById("tablaDatos").style.display = "none";
    }
  }

  private getDatosTabla(): void {
    this.personaService.onInformePersonas(this.tmp).subscribe(
      (respuesta) => {
        this.Datos = respuesta
        if (this.Datos.length > 0) {
          for (let i = 0; i < this.Datos.length; i++) {
            let file = new ArchivosFile();
            file.nombre = this.Datos[i].nomPrimerNombre;
            file.apellido = this.Datos[i].nomPrimerApellido;
            file.documento = this.Datos[i].numeroDocumento;
            file.tipoDocumento = this.Datos[i].tipoDocumento.nomDocumento;
            if (this.Datos[i].nomSegundoNombre === null) {
              file.nombre = file.nombre + "";
            } else {
              file.nombre = file.nombre + " " + this.Datos[i].nomSegundoNombre;
            }
            if (this.Datos[i].nomSegundoApellido === null) {
              file.apellido = file.apellido + "";
            } else {
              file.apellido = file.apellido + " " + this.Datos[i].nomSegundoApellido;
            }
            if (this.Datos[i].celular === null) {
              file.celular = "No registrado";
            } else {
              file.celular = this.Datos[i].celular;
            }
            this.archivoFile.push(file);
          }
          document.getElementById("tablaDatos").style.display = "block";
          this.dataSource = new MatTableDataSource(this.archivoFile);
          Swal.fire('Exitoso', 'Datos Encontrados', 'success');
        } else {
          document.getElementById("tablaDatos").style.display = "none";
          Swal.fire('Error', 'Ningún Dato Registrado', 'error');
        }
        console.log(respuesta)
      });
    // if (this.Datos != null || this.Datos.length > 0) {
    //   document.getElementById("tablaDatos").style.display = "block";
    // } else {
    //   document.getElementById("tablaDatos").style.display = "none";
    // }
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
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos[0].crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos[0].crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos[0].gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos[0].descargar;
    if (this.permiso.crearAux === 1 && this.permiso.crearUsuario === 1) {
      this.permiso.crearAux = 0;
    }
  }

  private getTipoUsuario(): void {
    this.historiaService.getTipoUsuario().subscribe(
      (respuesta) => {
        this.tipoUsuario = respuesta;
        this.tipoUsuario.splice(5, 1); 
        console.log(respuesta)
      }
    )
  }

  private onLabels(): void {
    this.labelService.getLabel().subscribe(
      (respuesta) => {
        this.datosSingleton = respuesta
        console.log(respuesta)
      }
    );
  }

}
