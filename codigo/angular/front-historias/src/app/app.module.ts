import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { MenuGeneralComponent } from './menu-general/menu-general.component';
import { HeaderComponent } from './header/header.component';

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

const routes: Routes = [
  {path: '', redirectTo: '/menuPrincipal/form-ocupacional', pathMatch: 'full'}, //ruta principal de la aplicacion
  // rutas secundarias se hace referencia con el component de cada uno
  {path:'login', component:LoginComponent,canActivate: [LoginService] },
  {path:'menuPrincipal/listPersonas', component:ListaPersonasComponent},
  {path:'menuPrincipal/form-ocupacional', component: FormOcupacionalComponent},
  {path:'menuPrincipal', component: BodyAppComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    MenuGeneralComponent,
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
    FormsModule
  ],
  providers: [
    LoginService,
    PersonaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
