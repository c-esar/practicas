import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AccordionModule } from 'primeng/accordion';
import { MenuItem } from 'primeng/api';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { FormOcupacionalComponent } from './form-ocupacional/form-ocupacional.component';
import { BodyAppComponent } from './body-app/body-app.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
//componentes
import { ListaPersonasComponent } from './lista-personas/lista-personas.component';
import { CreacionUsuarioAppComponent } from './creacion-usuario-app/creacion-usuario-app.component';
import { FormCambioPassComponent } from './form-cambio-pass/form-cambio-pass.component';
import { FormGymComponent } from './form-gym/form-gym.component';
import { ListUsuariosAppComponent } from './list-usuarios-app/list-usuarios-app.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
//servicios
import { LoginService } from './Servicios/login.service';
import { PersonaService } from './Servicios/persona.service';
import { LabelService } from './Servicios/label.service';
import { TablesComponent } from './tables/tables.component';
import { FormAuxiliarComponent } from './form-auxiliar/form-auxiliar.component';
//rutas
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, //ruta principal de la aplicacion
  // rutas secundarias se hace referencia con el component de cada uno
  { path: 'login', component: LoginComponent },
  { path: 'menuPrincipal/listPersonas', component: ListaPersonasComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/form-ocupacional', component: FormOcupacionalComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal', component: BodyAppComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/creacionUsuario', component: CreacionUsuarioAppComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/cambioPass', component: FormCambioPassComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/form-gym', component: FormGymComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/list-usuariosApp', component: ListUsuariosAppComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/form-ocupacional/auxiliar', component: FormAuxiliarComponent, canActivate: [LoginService] }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    HeaderComponent,
    ListaPersonasComponent,
    FormOcupacionalComponent,
    BodyAppComponent,
    CreacionUsuarioAppComponent,
    FormCambioPassComponent,
    FormGymComponent,
    ListUsuariosAppComponent,
    TablesComponent,
    FormAuxiliarComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    AccordionModule,
    FormsModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule
  ],
  exports: [
    MatDatepickerModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  providers: [
    LoginService,
    PersonaService,
    LabelService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
