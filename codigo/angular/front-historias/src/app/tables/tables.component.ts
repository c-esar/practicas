import { Component, OnInit } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { PersonaService } from '../Servicios/persona.service';
import { LabelService } from '../Servicios/label.service';
import { LoginService } from '../Servicios/login.service';
import { Permiso } from '../DatosBean/permiso';



@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {
  permiso: Permiso;
  medico: boolean;
  aux: boolean;
  administrador: boolean;

  constructor(private personaService: PersonaService,
    private labelService: LabelService,
      private loginService: LoginService) { }

  ngOnInit(): void {
    this.permiso = new Permiso();
    this.obtenerPermisos();
    this.getAuxOMedico();
  }

  private obtenerPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos[0].crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos[0].crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos[0].gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos[0].descargar;
    console.log(this.permiso.crearAux);
  }

  private getAuxOMedico(): void {
    if (this.permiso.crearUsuario == 0) {
      if (this.permiso.crearAux == 1) {
        this.aux = true;
      }
    } else if (this.permiso.crearUsuario == 1) {
      if(this.permiso.gestionarUsuario == 1){
        this.administrador = true;
      }
      this.medico = true;
    } else if(this.permiso.gestionarUsuario == 1){
      this.administrador = true;
    }
  }

}
