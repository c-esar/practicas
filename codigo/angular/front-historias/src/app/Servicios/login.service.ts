import { Injectable } from '@angular/core';
import { Login } from '../DatosBean/login';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class LoginService implements CanActivate {

  private localStorageService;
  private currentSession: Login = null;
  private url: string = 'http://localhost:8080/login/sesion';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  public isLogin: boolean;

  constructor(private httpClient: HttpClient, private router: Router) {
    this.localStorageService = localStorage;
    this.currentSession = this.loadSessionData();
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.log("Valor CanActivate" + this.isAutorization());
    if (!this.isAutorization()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

  getLoginSesion(login: Login): Observable<Login> {
    return this.httpClient.get<Login>(`${this.url}/${login.nomUsuario}/${login.password}`, { headers: this.httpHeaders });
  }


  private isNotAutorizado(e): boolean {
    if (e.status == 401 || e.status == 404) {
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }


  public logOut(): void {
    this.removeCurrentSession();
  }

  loadSessionData(): Login {
    var sessionStr = this.localStorageService.getItem('currentUser');
    return (sessionStr) ? <Login>JSON.parse(sessionStr) : null;
  }

  setCurrentSession(session: Login): void {
    this.currentSession = session;
    this.localStorageService.setItem('currentUser', JSON.stringify(session));
  }

  public isAutorization(): boolean {
    //console.log("valor autorizado " +this.getCurrentSession().nomUsuario )
    if (this.getCurrentSession() != null && this.getCurrentSession().nomUsuario != "" && this.getCurrentSession().nomUsuario != null) {
      return true;
    } else {
      return false;
    }
  }
  private getCurrentSession(): Login {
    return this.currentSession;
  }

  public correctLogin(data: Login) {
    this.setCurrentSession(data);
  }

  private removeCurrentSession(): void {
    console.log("remover entre")
    this.localStorageService.removeItem('currentUser');
    this.currentSession = null;
  }

}
