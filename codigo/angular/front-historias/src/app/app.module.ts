import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import {HttpClientModule} from '@angular/common/http';
import {LoginService} from './Servicios/login.service';
import { RouterModule, Routes} from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AccordionModule} from 'primeng/accordion';
import {MenuItem} from 'primeng/api';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { ListaPersonasComponent } from './lista-personas/lista-personas.component';
import { PersonaService } from './Servicios/persona.service';
import { FormOcupacionalComponent } from './form-ocupacional/form-ocupacional.component';
import { BodyAppComponent } from './body-app/body-app.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'}, //ruta principal de la aplicacion
  // rutas secundarias se hace referencia con el component de cada uno
  {path:'login', component:LoginComponent },
  {path:'menuPrincipal/listPersonas', component:ListaPersonasComponent,canActivate: [LoginService]},
  {path:'menuPrincipal/form-ocupacional', component: FormOcupacionalComponent,canActivate: [LoginService]},
  {path:'menuPrincipal', component: BodyAppComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    HeaderComponent,
    ListaPersonasComponent,
    FormOcupacionalComponent,
    BodyAppComponent
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
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
