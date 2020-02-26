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
  public iniciarLogin(): void {
    console.log("Entre funcion " +this.loginService.isAutorization());
    console.log("Valor del login" + this.login);
    if (this.loginService.isAutorization()) {
      this.router.navigate(['menuPrincipal'])
    } else {
      this.loginService.getLoginSesion(this.login).subscribe(
        (respuesta) => {
          console.log("Respuesta:" + respuesta.permisos[0].gestionarUsuario);
          console.log("Respuesta:" + respuesta.persona.nomPrimerNombre);
          this.login.estado = respuesta['estado'];
          console.log("hola:" + this.login.estado);
          if (this.login.estado == "ACTIVO" || this.login.estado == "activo") {
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
