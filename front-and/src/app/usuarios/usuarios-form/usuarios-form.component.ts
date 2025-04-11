import { Component, OnInit } from '@angular/core';

import { Usuario } from '../usuario';
import {ApirestService} from '../../apirest.service';

@Component({
  selector: 'app-usuarios-form',
  templateUrl: './usuarios-form.component.html',
  styleUrls: ['./usuarios-form.component.css']
})
export class UsuariosFormComponent implements OnInit {

  usuario: Usuario;
  success: boolean = false;
  errors: String[];
  

  constructor( private service: ApirestService) {
    this.usuario = new Usuario();
   }

  ngOnInit(): void {
  }

  cadastroUsuario() {
    this.service.cadastrarUsuario(this.usuario).subscribe(response => {
      this.success = true; 
      this.errors = [];
    }, errorResponse => {
      this.errors = errorResponse.error.errors.map((err: any) => err.defaultMessage);
    });
  }

}

