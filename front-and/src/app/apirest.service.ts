import { Injectable } from '@angular/core';
import { Usuario } from './usuarios/usuario';
import { Credito } from './creditos/credito';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApirestService {

  constructor(private http: HttpClient) { }

  // endponts usuarios
  getListUsuarios(): Observable<Usuario[]> {
    const url = 'http://localhost:8080/api/usuarios/usuario/listar?pagina=0&tamanho=10';
    return this.http.get<Usuario[]>(url);
  }

  cadastrarUsuario(usuario: Usuario): Observable<Usuario> {
    const url = 'http://localhost:8080/api/usuario/cadastrar';
    return this.http.post<Usuario>(url, usuario);
  }

  getUsuarioEmail(email: string): Observable<Usuario> {
    const url = `http://localhost:8080/api/usuarios/usuario/${email}`;
    return this.http.get<Usuario>(url);
  }

  getUsuario(id: number): Observable<Usuario> {
    const url = `http://localhost:8080/api/usuarios/usuario/id/${id}`;
    return this.http.get<Usuario>(url);
  }

  updateUsuario(id: number, usuario: Usuario): Observable<Usuario> {
    const url = `http://localhost:8080/api/usuarios/update/${id}`;
    return this.http.put<Usuario>(url, usuario);
  }

  deleteUsuario(id: number): Observable<any> {
    const url = `http://localhost:8080/api/usuario/deletar/${id}`;
    return this.http.delete(url);
  }

  getAllCreditos(): Observable<Credito[]> {
    const url = 'http://localhost:8080/api/usuarios/usuario/listar?pagina=0&tamanho=10';
    return this.http.get<Credito[]>(url);
  }

  getCreditoPorNumeroSimples(numeroNfes: string): Observable<Credito[]> {
    const url = `http://localhost:8080/api/creditos/${numeroNfes}`;
    return this.http.get<Credito[]>(url);
  }
  
  getCreditoPorNumeroComCreditoNaURL(numeroNfes: string): Observable<Credito[]> {
    const url = `http://localhost:8080/api/creditos/credito/${numeroNfes}`;
    return this.http.get<Credito[]>(url);
  }
  
}
