import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { HistoriasService } from '../Servicios/historias.service';
import { PersonaService } from '../Servicios/persona.service';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import { Persona } from '../DatosBean/persona';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-usuarios-app',
  templateUrl: './list-usuarios-app.component.html',
  styleUrls: ['./list-usuarios-app.component.css']
})
export class ListUsuariosAppComponent implements OnInit {
  displayedColumns: string[] = ['No.', 'Nombre', 'Apellido', 'Celular'];
  dataSource = new MatTableDataSource(null);
  datosSingleton: DatosSingleton;
  tipoUsuario: TipoUsuario[];
  tipoUsuarioSelecionado: TipoUsuario[];
  tmp: String[];
  Datos: Persona[];

  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private historiaService: HistoriasService) {
  }

  ngOnInit(): void {
    this.onCargarAtributos();
    this.onCargarFunciones();
  }

  onCargarAtributos(): void {
    this.tipoUsuario = new Array<TipoUsuario>();
    this.datosSingleton = new DatosSingleton();
    this.tipoUsuarioSelecionado = new Array<TipoUsuario>();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onCargarFunciones(): void {
    this.onLabels();
    this.getTipoUsuario();
  }

  onBuscarTipo(): void {
    this.tmp = new Array<String>();
    if (this.tipoUsuarioSelecionado.length > 0) {
      for (let i = 0; i < this.tipoUsuarioSelecionado.length; i++) {
        this.tmp.push(this.tipoUsuarioSelecionado[i].seqTipoUsuario.toString());
      }
      debugger
      this.getDatosTabla();
    } else {
      Swal.fire('Error', 'Debe seleccionar un item de la lista', 'error');
      document.getElementById("tablaDatos").style.display = "none";
    }
  }

  private getDatosTabla(): void {
    debugger
    this.personaService.onInformePersonas(this.tmp).subscribe(
      (respuesta) => {
        debugger
        this.Datos = respuesta
        if (this.Datos.length > 0) {
          for (let i = 0; i < this.Datos.length; i++) {
            if (this.Datos[i].nomSegundoNombre === null) {
              this.Datos[i].nomSegundoNombre = "";
            }
            if (this.Datos[i].nomSegundoApellido === null) {
              this.Datos[i].nomSegundoApellido = "";
            }
          }
          document.getElementById("tablaDatos").style.display = "block";
          this.dataSource = new MatTableDataSource(this.Datos);
        } else {
          document.getElementById("tablaDatos").style.display = "none";
        }
        console.log(respuesta)
      });
    if (this.Datos != null || this.Datos.length > 0) {
      document.getElementById("tablaDatos").style.display = "block";
    } else {
      document.getElementById("tablaDatos").style.display = "none";
    }
  }

  private getTipoUsuario(): void {
    this.historiaService.getTipoUsuario().subscribe(
      (respuesta) => {
        this.tipoUsuario = respuesta
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
