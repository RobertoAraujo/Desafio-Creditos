import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';

import { UsuariosRoutingModule } from './usuarios-routing.module';
import { UsuariosFormComponent } from './usuarios-form/usuarios-form.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { UsuariosUpdateComponent } from './usuarios-update/usuarios-update.component';


@NgModule({
  declarations: [
    UsuariosFormComponent,
    UsuariosListComponent,
    UsuariosUpdateComponent
  ],
  imports: [
    CommonModule,
    UsuariosRoutingModule,
    FormsModule
  ], 
  exports: [
    UsuariosFormComponent,
    UsuariosListComponent
  ]
})
export class UsuariosModule { }
