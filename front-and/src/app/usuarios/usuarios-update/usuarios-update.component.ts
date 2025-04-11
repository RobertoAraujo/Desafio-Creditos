import { Component, OnInit } from '@angular/core';
import { ApirestService } from '../../apirest.service';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-usuarios-update',
  templateUrl: './usuarios-update.component.html',
  styleUrls: ['./usuarios-update.component.css']
})
export class UsuariosUpdateComponent implements OnInit {

  usuario: Usuario;
  success: boolean = false;
  errors: String[];

  constructor(private service: ApirestService) {
    this.usuario = new Usuario();
  }

  ngOnInit(): void {
    const id = window.location.pathname.split('/')[2];
    this.service.getUsuario(Number(id)).subscribe(response => {
      this.usuario = response;
    });

  }

  updateUsuario(id: number, usuario: Usuario): void {
    this.service.updateUsuario(id, usuario).subscribe(response => {
      this.success = true;
      this.errors = [];

    }, errorResponse => {
      this.errors = errorResponse.error.errors.map((err: any) => err.defaultMessage);
    });
  }

}
