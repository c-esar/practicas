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
import { BodyAppComponent } from './body-app/body-app.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio'
import { ReactiveFormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { GridModule } from '@syncfusion/ej2-angular-grids';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox'
import { MatTableModule } from '@angular/material/table';
import { SignaturePadModule } from 'angular2-signaturepad';
import { UserIdleModule } from 'angular-user-idle';
import {MatMenuModule} from '@angular/material/menu';
//componentes
import { FormGymComponent } from './form-gym/form-gym.component';
import { ListUsuariosAppComponent } from './list-usuarios-app/list-usuarios-app.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { FormOcupacionalComponent } from './form-ocupacional/form-ocupacional.component';
//servicios
import { LoginService } from './Servicios/login.service';
import { PersonaService } from './Servicios/persona.service';
import { HistoriasService } from './Servicios/historias.service';
import { ReportesService } from './Servicios/reportes.service';
import { LabelService } from './Servicios/label.service';

import { TablesComponent } from './tables/tables.component';
import { FormAuxiliarComponent } from './form-ocupacional-auxiliar/form-auxiliar.component';
import { FactoresRiesgoComponent } from './form-factores-riesgo/factores-riesgo.component';
import { EnfermedadesLaboralesComponent } from './form-enfermedades-laborales/enfermedades-laborales.component';
import { AccidentesTrabajoComponent } from './form-accidentes-trabajo/accidentes-trabajo.component';
import { TrabajosPreviosComponent } from './form-trabajos-previos/trabajos-previos.component';
import { FormParaclinicosComponent } from './form-paraclinicos/form-paraclinicos.component';
import { FormGymAuxiliarComponent } from './form-gym-auxiliar/form-gym-auxiliar.component';
import { FormGestionComponent } from './form-gestionAdm/form-gestion.component';
import { FormHistoriasComponent } from './form-historias/form-historias.component';
import { FirmaIndividualComponent } from './firma-individual/firma-individual.component';
import { FormCertificadoComponent } from './form-certificado-ocupacional/form-certificado.component';
import { FormDescargaComponent } from './form-descarga-ocupacional/form-descarga.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormCertificadoGymComponent } from './form-certificado-gym/form-certificado-gym.component';
import { FormDescargaGymComponent } from './form-descarga-gym/form-descarga-gym.component';
import { NotFoundComponentComponent } from './not-found-component/not-found-component.component';
//rutas
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, //ruta principal de la aplicacion
  // rutas secundarias se hace referencia con el component de cada uno
  { path: 'login', component: LoginComponent },
  { path: 'menuPrincipal/form-ocupacional', component: FormOcupacionalComponent, canActivate: [LoginService], data: { animation: 'HomePage' } },
  { path: 'menuPrincipal', component: BodyAppComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/form-gym', component: FormGymComponent, canActivate: [LoginService], data: { animation: 'HomePage' } },
  { path: 'menuPrincipal/list-usuariosApp', component: ListUsuariosAppComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/list-usuariosApp/:id', component: FormHistoriasComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/form-ocupacional/auxiliar', component: FormAuxiliarComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/form-gym/auxiliar', component: FormGymAuxiliarComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/creacion-actualizacion', component: FormGestionComponent, canActivate: [LoginService] },
  { path: 'menuPrincipal/informes', component: TablesComponent, canActivate: [LoginService]},
  { path: 'menuPrincipal/crear/certificado/:id',  component: FormCertificadoComponent, canActivate: [LoginService]   },
  { path: 'menuPrincipal/crear/certificado',  component: FormDescargaComponent, canActivate: [LoginService]   },
  { path: 'menuPrincipal/crear/certificadoGym/:id',  component: FormCertificadoGymComponent, canActivate: [LoginService]   },
  { path: 'menuPrincipal/crear/certificadoGym',  component: FormDescargaGymComponent, canActivate: [LoginService]   },
  {path: '**', component: NotFoundComponentComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    HeaderComponent,
    FormOcupacionalComponent,
    BodyAppComponent,
    FormGymComponent,
    ListUsuariosAppComponent,
    TablesComponent,
    FormAuxiliarComponent,
    FactoresRiesgoComponent,
    EnfermedadesLaboralesComponent,
    AccidentesTrabajoComponent,
    TrabajosPreviosComponent,
    FormParaclinicosComponent,
    FormGymAuxiliarComponent,
    FormGestionComponent,
    FormHistoriasComponent,
    FirmaIndividualComponent,
    FormCertificadoComponent,
    FormDescargaComponent,
    FormCertificadoGymComponent,
    FormDescargaGymComponent,
    NotFoundComponentComponent
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
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatIconModule,
    MatCheckboxModule,
    MatTableModule,
    MatRadioModule,
    MatMenuModule,
    ModalModule.forRoot(),
    GridModule,
    SignaturePadModule,
    MatProgressSpinnerModule,
    NgSelectModule,
    UserIdleModule.forRoot({idle: 72000, timeout: 1, ping: 120})
  ],
  exports: [
  ],
  providers: [
    MatDatepickerModule,
    MatNativeDateModule,
    LoginService,
    PersonaService,
    LabelService,
    HistoriasService,
    ReportesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
