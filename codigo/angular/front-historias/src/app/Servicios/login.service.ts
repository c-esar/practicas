import { Injectable } from '@angular/core';
import { Login } from '../DatosBean/login';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url: string = 'http://localhost:8080/login/sesion';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  public isLogin: boolean = false;
  constructor(private httpClient: HttpClient, private router: Router) {
    this.isLogin = false;
   }

  getLoginSesion(login: Login): Observable<Login> {
    return this.httpClient.get<Login>(`${this.url}/${login.nomUsuario}/${login.password}`);
  }


  private isNotAutorizado(e): boolean {
    if (e.status == 401 || e.status == 404) {
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }

  public isUserLoggedIn():boolean {
    if (this.isLogin) {
      return true;
    } else {
      return false;
    }
  }

  logOut():void {
    this.isLogin = false;
  }
}
