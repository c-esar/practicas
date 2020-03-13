import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Servicios/login.service';
import { Login } from '../DatosBean/login';

import Swal from 'sweetalert2';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login
  constructor(private loginService: LoginService,
    private router: Router) {
    this.login = new Login();
  }

  ngOnInit() {
    if (this.loginService.isAutorization()) {
      this.router.navigate(['menuPrincipal'])
    }
  }

  public iniciarLogin(): void {
    console.log("Entre funcion " +this.loginService.isAutorization());
    console.log("Valor del login" + this.login.nomUsuario);
    if (this.loginService.isAutorization()) {
      this.router.navigate(['menuPrincipal'])
    } else {
      this.loginService.getLoginSesion(this.login).subscribe(
        (respuesta) => {
          console.log("Estado:" + respuesta['estado']);
          console.log(respuesta.permisos);
          if (respuesta['estado'] == "ACTIVO" || respuesta['estado'] == "activo") {
            this.loginService.isLogin = true;
            this.loginService.correctLogin(respuesta);
            this.router.navigate(['menuPrincipal'])
          } else {
            Swal.fire('Error de Ingreso', 'Usuario o Contraseña Incorrectos', 'error');
          }
        }
      );
    }
  }


}
