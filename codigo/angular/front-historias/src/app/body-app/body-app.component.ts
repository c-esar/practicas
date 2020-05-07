import { Component, OnInit } from '@angular/core';
import { UserIdleService } from 'angular-user-idle';
import { LoginService } from '../Servicios/login.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-body-app',
  templateUrl: './body-app.component.html',
  styleUrls: ['./body-app.component.css']
})
export class BodyAppComponent implements OnInit {

  constructor(private userIdle: UserIdleService,
    private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {
    this.userIdle.startWatching();

    // Start watching when user idle is starting.
    this.userIdle.onTimerStart().subscribe(count => console.log(count));

    // Start watch when time is up.
    this.userIdle.onTimeout().subscribe(() => {     
      this.loginService.logOut();  
      this.router.navigate(['login']);
      Swal.fire('Tiempo agotado', 'Inactivo', 'error');
    });
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
