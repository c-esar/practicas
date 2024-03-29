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

@Component({
  selector: 'app-form-descarga-gym',
  templateUrl: './form-descarga-gym.component.html',
  styleUrls: ['./form-descarga-gym.component.css']
})
export class FormDescargaGymComponent implements OnInit {

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
          debugger
          if(respuesta.historiaGymEncriptacion.length > 0){
            this.dataSource = respuesta.historiaGymEncriptacion;
            document.getElementById("tablaDatos").style.display = "block";
            this.encontrado = true;
            Swal.fire('Exitoso', 'Persona Tiene Historias', 'success');
          }else{
            Swal.fire('Exitoso', 'Persona Tiene Historias', 'error');
          }

        }
      );
    }, 1000);
  }

}
