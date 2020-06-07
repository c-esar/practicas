import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Servicios/login.service';
import { Login } from '../DatosBean/login';
import { UserIdleService } from 'angular-user-idle';
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
    private router: Router,
    private userIdle: UserIdleService) {
    this.login = new Login();
  }

  ngOnInit() {
    setTimeout(() => {
      Swal.fire({
        title: 'Buscando',
        timer: 1000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      if (this.loginService.isAutorization()) {
        this.router.navigate(['menuPrincipal'])
      }
    }, 500);
    //Start watching for user inactivity.
    this.userIdle.startWatching();

    // Start watching when user idle is starting.
    this.userIdle.onTimerStart().subscribe(count => console.log(count));

    // Start watch when time is up.
    this.userIdle.onTimeout().subscribe(() => {
      Swal.fire('Tiempo agotado', 'Inactivo', 'error');
      this.loginService.logOut();  
      this.router.navigate(['login']);
    });
  }

  public iniciarLogin(): void {
    setTimeout(() => {
      Swal.fire({
        title: 'Buscando',
        timer: 2000,
        timerProgressBar: true,
        showConfirmButton: false
      })
    }, 500);

    setTimeout(() => {
      console.log("Entre funcion " + this.loginService.isAutorization());
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
    }, 500);
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

}
