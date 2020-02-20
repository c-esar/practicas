import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Servicios/login.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLogueado: boolean = true; //colocar flaso por defecto
  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    //this.isLogueado = this.loginService.isUserLoggedIn();
  }

}
