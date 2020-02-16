import { Component, OnInit } from '@angular/core';
import {LoginService} from './login.service';
import { Login } from './login';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login;
  constructor(private loginService: LoginService) { }

  ngOnInit(){
    this.loginService.getLogin().subscribe(
      login => this.login = login
    );
  }

}
