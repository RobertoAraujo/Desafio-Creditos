import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplateModule } from './template/template.module';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UsuariosModule } from './usuarios/usuarios.module';
import { CreditosModule } from './creditos/creditos.module';
import {ApirestService} from './apirest.service'
import {HttpClientModule} from '@angular/common/http'


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TemplateModule,
    UsuariosModule,
    CreditosModule,
    HttpClientModule
  ],
  providers: [
    ApirestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
