# Gtasks

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen.svg)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.1.0-brightgreen?logo=springsecurity)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.1.0-blue?logo=spring)
![JWT](https://img.shields.io/badge/JWT-Authorization-blueviolet?logo=json)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)
![Maven Central](https://img.shields.io/maven-central/v/org.springframework.boot/spring-boot-starter)

## Descrição

### O que faz?

Gtasks é uma API REST para gerenciamento de tarefas (To-Do), criada com o propósito de estudar e praticar o desenvolvimento com **Spring Boot**. A aplicação permite criar, buscar, atualizar, deletar e filtrar tarefas. Ela também possui autenticação baseada em JWT e controle de acesso por papéis (roles).

### Com o que foi construído?

- Java 17  
- Spring Boot 3  
- Spring Security  
- Spring Data JPA  
- JWT  
- PostgreSQL  
- Lombok  

### Por quê?

Esse projeto foi desenvolvido com foco **100% educacional**. Ele é dividido em sprints, cada uma abordando um tema chave do desenvolvimento backend moderno com Java e Spring Boot. O objetivo foi aprender fazendo: aplicar boas práticas, entender segurança com JWT, e montar uma estrutura de projeto limpa.

---

## 🔗 API Endpoints

> Autenticação:

- `POST /login` – Retorna JWT ao fornecer login e senha válidos.

> Tarefas:

- `GET /tasks` – Lista tarefas com suporte a paginação e filtros.
- `POST /tasks` – Cria uma nova tarefa.
- `GET /tasks/{id}` – Busca uma tarefa por ID.
- `PUT /tasks/{id}` – Atualiza uma tarefa existente.
- `DELETE /tasks/{id}` – Deleta uma tarefa.

> Acesso controlado:

Algumas rotas podem exigir um papel específico:

- `@PreAuthorize("hasRole('ADMIN')")` – Apenas usuários com role ADMIN podem acessar.

---

## ✅ Lições aprendidas

Durante o desenvolvimento do Gtasks, foram colocados em prática:

- Arquitetura organizada com DTOs, services e mappers
- Validações com Jakarta Validation (`@NotBlank`, `@Size`, etc.)
- Tratamento de exceções de forma centralizada
- Paginação e filtragem com `Pageable`
- Segurança com Spring Security + JWT
- Controle de acesso com roles (RBAC)
- Separação de camadas e boas práticas REST

---

## Próximos passos

Caso queira estender o projeto:

- [ ] Criar refresh token para renovar JWT
- [ ] Associar tarefas a usuários
- [ ] Permitir cadastro de usuários via endpoint
- [ ] Adicionar testes unitários e de integração
- [ ] Implementar reset de senha e verificação por e-mail
- [ ] Criar documentação via Swagger/OpenAPI

---

> **Nota:** Este projeto **não é para produção**. O foco é aprender os conceitos e entender como cada peça se encaixa no ecossistema Spring.
