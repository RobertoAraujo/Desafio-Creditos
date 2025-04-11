import { Component, OnInit } from '@angular/core';
import { Credito } from '../credito';
import { ApirestService } from '../../apirest.service';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
  selector: 'app-creditos-list',
  templateUrl: './creditos-list.component.html',
  styleUrls: ['./creditos-list.component.css']
})
export class CreditosListComponent implements OnInit {
  creditos: Credito[] = [];
  filteredCreditos: Credito[] = [];
  errors: string[] = [];
  searchTerm: string = '';
  private searchSubject = new Subject<string>();

  // Variáveis de paginação
  page: number = 0;
  currentPage: number = 0;
  totalPages: number = 0;
  totalElements: number = 0;
  pageSize: number = 10;
  pages: number[] = [];

  constructor(private service: ApirestService, private route: Router) { }

  ngOnInit(): void { 
    this.getAllCreditos();
    
    // Configura o observable para a pesquisa
    this.searchSubject.pipe(
      debounceTime(300),
      distinctUntilChanged()
    ).subscribe(searchTerm => {
      this.filterCreditos(searchTerm);
    });
  }

  getAllCreditos() {
    this.service.getAllCreditos().subscribe(response => {
      if (response && response['content']) {
        const content = response['content'];
        this.creditos = content.flatMap((item: any) => item.creditos || []);
        this.filteredCreditos = [...this.creditos]; // Atualiza a lista filtrada
        
        this.currentPage = response['number'];
        this.totalPages = response['totalPages'];
        this.totalElements = response['totalElements'];
        this.updatePages();
        
        console.log('Dados carregados:', this.creditos);
      } else {
        this.errors.push('Resposta da API inválida');
      }
    }, error => {
      this.errors.push('Erro ao carregar créditos');
    });
  }

  onSearchInput(event: any): void {
    this.searchTerm = event.target.value;
    this.searchSubject.next(this.searchTerm);
  }

  filterCreditos(searchTerm: string): void {
    if (!searchTerm || searchTerm.trim() === '') {
      this.filteredCreditos = [...this.creditos];
      return;
    }

    const term = searchTerm.toLowerCase();
    this.filteredCreditos = this.creditos.filter(credito => 
      (credito.numeroNfse?.toString().toLowerCase().includes(term)) ||
      (credito.numeroCredito?.toString().toLowerCase().includes(term))
    );
    
    console.log('Dados filtrados:', this.filteredCreditos);
  }

  updatePages(): void {
    this.pages = Array.from({ length: this.totalPages }, (_, i) => i);
  }

  changePage(page: number): void {
    if (page < 0 || page >= this.totalPages) return;
    this.currentPage = page;
    this.getAllCreditos();
  }
}