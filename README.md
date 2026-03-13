# 📚 Sistema Web de Secretaria Escolar

Sistema web desenvolvido para simular o funcionamento de uma secretaria escolar, permitindo que professores lancem notas e observações, enquanto alunos podem visualizar seu boletim e desempenho acadêmico.

O projeto foi desenvolvido como parte de um desafio de desenvolvimento web, utilizando arquitetura full-stack.

## Tecnologias Utilizadas
### Back-end

- Spring Boot

- Java

- PostgreSQL

- Banco hospedado no Aiven

- Documentação da API com Swagger

### Front-end

- React

- Arquitetura do Sistema

## O sistema segue uma arquitetura cliente-servidor:
    
> React (Front-end)          
>        │  
>        │ HTTP REST API  
>        ▼  
> Spring Boot (Back-end)  
>        │  
>        ▼  
> PostgreSQL (Banco de Dados - Aiven)      


  - Front-end (React): interface para alunos e professores

  - Back-end (Spring Boot): regras de negócio, autenticação e APIs

  - Banco de dados (PostgreSQL): armazenamento das informações do sistema

## Tipos de Usuários
### Professores

Os professores já estão cadastrados no sistema e podem:

- Fazer login

- Buscar alunos pela matrícula

- Lançar notas da sua disciplina

- Enviar observações aos alunos

- Visualizar notas e observações

- ⚠️ Cada professor só pode editar notas da sua própria disciplina.

### Alunos

Os alunos devem realizar cadastro no sistema com:

- Nome completo

- Matrícula (única)

- E-mail

- Senha

- #### Após login, podem:

  - Visualizar notas em todas as disciplinas

  - Ver observações enviadas pelos professores

  - Acessar seu boletim escolar

### Administradores

Os administradores devem realizar cadastro no sistema com:

- CPF

- Senha

## Regras de Negócio

Cada disciplina possui:

- Nota 1

- Nota 2

A média é calculada automaticamente pelo sistema:

  > Média = (Nota 1 + Nota 2) / 2

***A média final aparece no boletim do aluno.***

## Documentação da API

A documentação da API foi gerada automaticamente com Swagger.

Após iniciar o backend, acesse:

*http://localhost:8080/swagger-ui.html*

ou

*http://localhost:8080/swagger-ui/index.html*

### Como Executar o Projeto
#### 1️⃣ Clonar o repositório
- git clone https://github.com/seu-usuario/seu-repositorio.git
#### 2️⃣ Executar o Back-end

- Entre na pasta do backend:

  `cd backend`

- Execute:

  `./mvnw spring-boot:run`

- ou

  `mvn spring-boot:run`

#### 3️⃣ Executar o Front-end

- Entre na pasta do frontend:

  `cd frontend`

- Instale as dependências:

  `npm install`

- Execute:

  `npm start`
## Estrutura do Banco de Dados

O banco de dados possui tabelas principais para:

- Usuários

- Disciplinas

- Notas

- Observações

O banco está hospedado na plataforma Aiven, utilizando PostgreSQL.

## Funcionalidades

- ✔ Cadastro de alunos
- ✔ Login para professores e alunos
- ✔ Lançamento de notas
- ✔ Envio de observações
- ✔ Visualização de boletim
- ✔ Cálculo automático de média
- ✔ Documentação da API

## Interface

O sistema possui uma interface simples e funcional, permitindo navegação intuitiva entre as funcionalidades de professores e alunos.

## Autores

Projeto desenvolvido como parte de um desafio de desenvolvimento web para simular um sistema real de secretaria escolar.

- Alisson Alves
- Carlos Perrud
- Cintya Rios
- Manuelli Flaviano
- Matheus Hideki
