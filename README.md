# Spring Boot REST API com Relacionamentos 1:N e N:M

Este projeto é uma API REST desenvolvida com **Spring Boot** e **MySQL**, seguindo o padrão **MVC** e os princípios de **Clean Code** e **DRY**. A API implementa operações CRUD completas para três entidades: **User**, **Product** e **Order**, além de métodos adicionais para enriquecer o projeto.

## 📚 Funcionalidades

- Gerenciamento de usuários (**User**)
- Gerenciamento de produtos (**Product**)
- Gerenciamento de pedidos (**Order**) com:
  - Relacionamento **1:N** entre **User** e **Order**
  - Relacionamento **N:M** entre **Order** e **Product**

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **MySQL**
- **Spring Data JPA**
- **Maven**

## 📂 Estrutura do Projeto

```plaintext
src/main/java
├── com.example.project
│   ├── config         # Configurações globais (ex.: CORS, ModelMapper)
│   ├── controller     # Controladores (REST endpoints)
│   ├── dto            # Data Transfer Objects (Record)
│   ├── entity         # Entidades JPA
│   ├── exception      # Exceções customizadas e handlers globais
│   ├── repository     # Repositórios JPA
│   ├── service        # Lógica de negócios
│   └── utils          # Utilitários e funções auxiliares
└── resources
    ├── application.properties  # Configuração do banco de dados e outros
    └── schema.sql              # Criação inicial das tabelas (opcional)
```
## 🛤️ Endpoints Disponíveis
### User Endpoints
- **POST /api/users** - Criação de um usuário
- **GET /api/users** - Listar todos os usuários
- **GET /api/users/{id}** - Buscar usuário por ID
- **PUT /api/users/{id}** - Atualizar usuário
- **DELETE /api/users/{id}** - Remover usuário
### Product Endpoints
- **POST /api/products** - Criação de um produto
- **GET /api/products** - Listar todos os produtos
- **GET /api/products/{id}** - Buscar produto por ID
- **PUT /api/products/{id}** - Atualizar produto
- **DELETE /api/products/{id}** - Remover produto
### Order Endpoints
- **POST /api/orders** - Criação de um pedido
- **GET /api/orders** - Listar todos os pedidos
- **GET /api/orders/{id}** - Buscar pedido por ID
- **PUT /api/orders/{id}** - Atualizar pedido
- **DELETE /api/orders/{id}** - Remover pedido

## 🗂️ Exemplos de JSON
Criar Usuário:
```
{
  "name": "João Silva",
  "email": "joao.silva@example.com"
}
```
Criar Produto:
```
{
  "name": "Laptop Dell XPS 15",
  "price": 1500.00
}
```
Criar Pedido:
```
{
  "userId": "550e8400-e29b-41d4-a716-446655440000",
  "productIds": [
    "2",
    "1"
  ]
}
```
## 📑 Pré-requisitos
- **Java 17+**
- **MySQL configurado e em execução**
- **Ferramenta de gerenciamento de APIs (ex.: Postman ou Insomnia)**

## ⚙️ Configuração do Ambiente
1. Clone o repositório:
```
git clone https://github.com/osvaldofaachar/order-product-user-api.git
cd order-product-user-api
```
2. Configure o banco de dados no arquivo application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
3. Compile e execute o projeto:
```
./mvnw spring-boot:run
```
## 🖇️ Relacionamentos no Banco de Dados
- **User ↔ Order: 1:N**
- **Order ↔ Product: N:M**

# Desenvolvido por Osvaldo Achar.






