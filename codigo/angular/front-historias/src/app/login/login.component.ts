import { Component, OnInit } from '@angular/core';
import {LoginService} from '../Servicios/login.service';
import { Login } from '../DatosBean/login';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login;
  username = 'javainuse'
  password = ''
  invalidLogin = false
  constructor(private loginService: LoginService,
  private router: Router) {
    this.login = new Login();
  }

  ngOnInit(){
    this.loginService.getLogin().subscribe(
      login => this.login = login
    );
  }

  loginSesion(): void{
    console.log(this.login);
    if(this.login.usuario == null || this.login.pass == null){
      Swal.fire('Error Login', 'Usuario o Password Incorrectos', 'error');
      return;
    }
  }

  checkLogin() {
    console.log(this.login.usuario + " "+this.login.pass);
   if (this.loginService.authenticate(this.login.usuario, this.login.pass)
   ) {
     this.router.navigate([''])
     this.invalidLogin = false
   } else
     this.invalidLogin = true
 }

}
