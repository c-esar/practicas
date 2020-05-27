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
  anchoPantalla : any;
  constructor(private loginService: LoginService) {
    this.permiso = new Permiso();
  }

  ngOnInit(): void {
    debugger
    this.funtionResize();
    this.perfil = this.loginService.obtenerPerfilSesion().persona[0].rolUsuario[0].nomTipoUsuario;
    //this.nomUsuario = this.loginService.obtenerPerfilSesion().nomUsuario;
    this.isLogueado = this.loginService.isAutorization();
    this.obtenerPermisos();
  }

  public salirApp(): void {
    this.loginService.logOut();
  }

  public funtionResize(): void {
    var widthBrowser = window.outerWidth;
    this.anchoPantalla = window.outerWidth;
    var heightBrowser = window.outerHeight;
    console.log("Tamaño de la pantalla del navegador: width=" + widthBrowser + ", height=" + heightBrowser);
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
}
