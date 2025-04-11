import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = '';
  senha: string = '';

  constructor() { }
  
  ngOnInit(): void {
  }

  getUsuarioEmail(email: string) {
    
  }

  onRegister() {
    console.log('Redirecionando para a página de registro...');
    // Aqui você pode redirecionar para a página de registro
  }

  onForgotPassword() {
    console.log('Redirecionando para a página de recuperação de senha...');
    // Aqui você pode redirecionar para a página de recuperação de senha
  }
  
}
