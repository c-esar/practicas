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
    console.log("Valor CanActivate" + this.login.isLogin);
    if (this.login.isLogin){
        return true;
    }else{
      this.router.navigate(['login']);
      return false;
    }
  }
}
