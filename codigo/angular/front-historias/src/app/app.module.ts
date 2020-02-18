import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { MenuGeneralComponent } from './menu-general/menu-general.component';
import { HeaderComponent } from './header/header.component';

import {HttpClientModule} from '@angular/common/http';
import {LoginService} from './login/login.service';
import { RouterModule, Routes} from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AccordionModule} from 'primeng/accordion';
import {MenuItem} from 'primeng/api';

const routes: Routes = [
  {path: '', redirectTo: '/menuPrincipal', pathMatch: 'full'}, //ruta principal de la aplicacion
  // rutas secundarias se hace referencia con el component de cada uno
  {path:'login', component:LoginComponent},
  {path:'menuPrincipal', component: MenuGeneralComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    MenuGeneralComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    AccordionModule
  ],
  providers: [
    LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
