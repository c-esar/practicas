import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Servicios/login.service';
import { Permiso } from '../DatosBean/permiso';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLogueado: boolean = false; //colocar flaso por defecto
  perfil: string;
  nomUsuario: string;
  permiso: Permiso;
  constructor(private loginService: LoginService) {
    this.permiso = new Permiso();
   }

  ngOnInit(): void {
  this.isLogueado = this.loginService.isAutorization();
  this.perfil = this.loginService.obtenerPerfilSesion().nomPerfil;
  this.nomUsuario = this.loginService.obtenerPerfilSesion().nomUsuario;
  this.obtenerPermisos();
  }

  public salirApp():void{
    this.loginService.logOut();
  }

  private obtenerPermisos(): void {
    this.permiso.crearAux = this.loginService.obtenerPerfilSesion().permisos.crearAux;
    this.permiso.crearUsuario = this.loginService.obtenerPerfilSesion().permisos.crearUsuario;
    this.permiso.gestionarUsuario = this.loginService.obtenerPerfilSesion().permisos.gestionarUsuario;
    this.permiso.descargar = this.loginService.obtenerPerfilSesion().permisos.descargar;
  }
}
