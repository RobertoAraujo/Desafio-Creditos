import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';

import { CreditosRoutingModule } from './creditos-routing.module';
import { CreditosListComponent } from './creditos-list/creditos-list.component';


@NgModule({
  declarations: [
    CreditosListComponent
  ],
  imports: [
    CommonModule,
    CreditosRoutingModule,
    FormsModule
  ], 
  exports: [
    CreditosListComponent
  ]
})
export class CreditosModule { }
