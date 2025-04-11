import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuario';
import { ApirestService } from '../../apirest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.css']
})
export class UsuariosListComponent implements OnInit {

  usuarios: Usuario[] = [];
  success: boolean = false;
  errors: string[] = [];
  page: number = 0;
  currentPage: number = 0;
  totalPages: number = 0;
  totalElements: number = 0;
  pageSize: number = 10;
  pages: number[] = [];

  constructor(private service: ApirestService, private route: Router) { }

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    this.service.getListUsuarios().subscribe(resposta => {
      if (resposta && resposta['content']) {
        this.usuarios = resposta['content'];
        this.currentPage = resposta['number'];
        this.totalPages = resposta['totalPages'];
        this.totalElements = resposta['totalElements'];
        this.success = true;
        this.errors = [];
        this.updatePages();
      } else {
        this.errors.push('A resposta não contém o campo "content" da paginação.');
      }
    });
  }

  updatePages(): void {
    this.pages = Array.from({ length: this.totalPages }, (_, i) => i); // Create an array of page numbers
  }

  changePage(page: number): void {
    if (page < 0 || page >= this.totalPages) return;
    this.currentPage = page;
    this.loadUsuarios();
  }

  updateUsuario(id: number): void {
    this.route.navigate(['/usuario-update',id]);
  }

  deleteUsuario(id: number): void {
    if (confirm('Tem certeza que deseja deletar este usuário?')) {
      this.service.deleteUsuario(id).subscribe(response => {
        this.success = true;
        this.errors = [];
        this.loadUsuarios();
      }, errorResponse => {
        this.errors = errorResponse.error.errors.map((err: any) => err.defaultMessage);
      });
    }
  }

}
