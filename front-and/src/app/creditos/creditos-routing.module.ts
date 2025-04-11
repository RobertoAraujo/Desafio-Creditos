import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreditosListComponent } from './creditos-list/creditos-list.component';

const routes: Routes = [
  {path: 'creditos-list', component: CreditosListComponent},
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class CreditosRoutingModule { }
