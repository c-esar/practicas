import { Injectable } from '@angular/core';
import { Login } from '../DatosBean/login';
import { of, Observable} from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {map } from 'rxjs/operators';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

private url:string = 'http://localhost:';
  constructor(private httpClient: HttpClient, private router: Router) { }

  getLogin(): Observable<Login> {
    return this.httpClient.get(this.url).pipe(
      map( response => response as Login)
    );
  }


  private isNotAutorizado(e): boolean{
    if(e.status == 401 || e.status == 404){
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }

  authenticate(username, password) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log(headers);
    return this.httpClient.get<Login>('http://localhost:8080/login/validateLogin',{headers}).pipe(
     map(
       userData => {
        sessionStorage.setItem('username',username);
        return userData;
       }
     )

    );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
