# Projeto Java - Maven

Este é um projeto Java desenvolvido com Java 8 e Maven.

## ✅ Tecnologias Utilizadas

- Java 8
- Maven
- JUnit (para testes)
- Spring Boot (se aplicável)
- docker (para containerização)
- postman (para testes de API)
- postgresql (para banco de dados)

## ▶️ Requisitos

- Java 8 instalado
- Maven 3.x instalado

## ⚙️ Como Rodar o Projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
📡 Endpoints da API de Créditos
🔍 Buscar um crédito pelo número da nota fiscal eletrônica (NFSe)
GET http://localhost:8080/api/creditos/credito/7891011

Retorno:
```json
{
    "id": 9,
    "numeroCredito": "123456",
    "numeroNfse": "7891011",
    "dataConstituicao": "2024-02-25",
    "valorIssqn": 1500.75,
    "tipoCredito": "ISSQN",
    "simplesNacional": true,
    "aliquota": 5.00,
    "valorFaturado": 30000.00,
    "valorDeducao": 5000.00,
    "baseCalculo": 25000.00
}
```

📄 Listar todos os créditos relacionados a uma NFSe
GET http://localhost:8080/api/creditos/7891011

Retorno:
```json
[
    {
        "id": 9,
        "numeroCredito": "123456",
        "numeroNfse": "7891011",
        "dataConstituicao": "2024-02-25",
        "valorIssqn": 1500.75,
        "tipoCredito": "ISSQN",
        "simplesNacional": true,
        "aliquota": 5.00,
        "valorFaturado": 30000.00,
        "valorDeducao": 5000.00,
        "baseCalculo": 25000.00
    },
    {
        "id": 10,
        "numeroCredito": "789012",
        "numeroNfse": "7891011",
        "dataConstituicao": "2024-02-26",
        "valorIssqn": 1200.50,
        "tipoCredito": "ISSQN",
        "simplesNacional": false,
        "aliquota": 4.50,
        "valorFaturado": 25000.00,
        "valorDeducao": 4000.00,
        "baseCalculo": 21000.00
    }
]
```
📝 Criar um novo crédito
POST http://localhost:8080/api/creditos/credito/criar

Retorno:
```json
{
    "numeroCredito": "123456",
    "numeroNfse": "7891013",
    "dataConstituicao": "16-01-2025",
    "valorIssqn": 1500.75,
    "tipoCredito": "ISSQN",
    "simplesNacional": "true",
    "aliquota": 5.0,
    "valorFaturado": 30000.00,
    "valorDeducao": 5000.00,
    "baseCalculo": 25000.00,
    "usuario_id": 1
}
```

2. **Compile o projeto:**

```bash
mvn clean install
```