import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService} from '../Servicios/login.service';

@Injectable({
  providedIn: 'root'
})

export class AuthGuard implements CanActivate {
  constructor(private login: LoginService, private router: Router){}

  canActivate() {
    if (this.login.isUserLoggedIn())
      return true;

    this.router.navigate(['login']);
    return false;

  }
}
