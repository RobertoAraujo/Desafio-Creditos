import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosFormComponent } from './usuarios-form/usuarios-form.component';
import { UsuariosListComponent } from './usuarios-list/usuarios-list.component';
import { UsuariosUpdateComponent } from './usuarios-update/usuarios-update.component';


const routes: Routes = [
  {path: 'usuarios-form', component: UsuariosFormComponent},
  {path: 'usuarios-list', component: UsuariosListComponent},
  {path: 'usuario-update/:id', component: UsuariosUpdateComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class UsuariosRoutingModule { }
