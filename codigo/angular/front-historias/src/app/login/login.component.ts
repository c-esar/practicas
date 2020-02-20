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

  public login: Login;
  constructor(private loginService: LoginService,
    private router: Router) {
    this.login = new Login();
  }

  ngOnInit() {

  }

  iniciarLogin(): void {
    console.log(this.loginService.isUserLoggedIn);
    if (false) {
      this.router.navigate(['menuPrincipal'])
    } else {
      this.loginService.getLoginSesion(this.login).subscribe(
        (respuesta) => {
          this.login.estado = respuesta['estado']
          console.log(respuesta);
          console.log("hola:" + this.login.estado);
          if (this.login.estado == "ACTIVO" || this.login.estado == "activo") {
            this.loginService.isLogin = true;
            this.router.navigate(['menuPrincipal'])
          } else {
            Swal.fire('Error Login', 'Usuario o Password Incorrectos', 'error');
          }
        }
      );

    }

  }

}
