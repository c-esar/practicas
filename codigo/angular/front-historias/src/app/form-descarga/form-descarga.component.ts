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
import { UserIdleService } from 'angular-user-idle';
import * as jsPDF from 'jspdf';
import * as html2canvas from 'html2canvas';

@Component({
  selector: 'app-form-descarga',
  templateUrl: './form-descarga.component.html',
  styleUrls: ['./form-descarga.component.css']
})
export class FormDescargaComponent implements OnInit {

  numeroDocumento: string;
  encontrado: boolean;
  displayedColumns: string[] = ['Numero Historia', 'Fecha', 'Certificado'];
  dataSource = null;
  persona: Persona;
  constructor(private labelService: LabelService,
    private loginService: LoginService,
    private personaService: PersonaService,
    private historiaService: HistoriasService,
    private filesService: FilessService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private reportes: ReportesService,
    private userIdle: UserIdleService) {
  }

  ngOnInit(): void {
    this.onCargarAtributos();
    
  }

  onCargarAtributos(): void {
    this.persona = new Persona();
    this.encontrado = false;
  }
  onBuscarHistoria() {
    setTimeout(() => {
      Swal.fire({
        title: 'Buscando Historias',
        timer: 10000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      this.persona.numeroDocumento = this.numeroDocumento;
      this.personaService.onBuscarDocumento(this.persona).subscribe(
        (respuesta) => {
          console.log(respuesta);
          debugger;
          this.dataSource = respuesta.historiasEncriptacion;
          this.encontrado = true;
          Swal.fire('Exitoso', 'Persona Tiene Historias', 'success');
        }
      );
    }, 1000);
  }




}
