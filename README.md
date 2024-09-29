# 🐾 PetTracker

**Status do projeto**: 🚧 Em desenvolvimento

## Descrição

O **PetTracker** é um aplicativo desenvolvido em **Java com Spring Boot** para ajudar tutores a gerenciar a saúde de seus animais de estimação. O sistema permite o cadastro de usuários e animais, possibilitando o acompanhamento de vacinas e medicamentos, incluindo lembretes para reaplicação de vacinas e remédios. O objetivo é fornecer uma maneira prática e eficiente de monitorar o histórico médico de pets, garantindo que eles recebam os cuidados necessários no momento certo.

### Funcionalidades planejadas:

- 📋 **Cadastro de usuários**: Um usuário poderá cadastrar seus dados (neste primeiro momento sem autenticação).
- 🐕 **Cadastro de animais**: Cada usuário poderá adicionar vários animais ao sistema.
- 💉 **Gerenciamento de vacinas e remédios**: Os tutores poderão cadastrar vacinas e remédios, associando uma data para reaplicação ou renovação.
- 🔔 **Lembretes automáticos**: O sistema notificará o usuário quando estiver próximo de um prazo para reaplicação de uma vacina ou medicamento.
- 📅 **Histórico de vacinas**: Consulta do histórico completo de vacinas e medicamentos de cada animal.

## Tecnologias Utilizadas

- **Java** (Spring Boot)
- **Spring Data JPA** (para interações com o banco de dados)
- **PostgreSQL** (banco de dados relacional)
- **Maven** (gerenciamento de dependências)
- **Lombok** (redução de código boilerplate)

## Rotas da API (em desenvolvimento)

1. **Usuários**
   - `POST /usuarios` - Cadastrar um novo usuário.
   - `GET /usuarios/{id}` - Obter informações de um usuário específico.

2. **Animais**
   - `POST /animais` - Cadastrar um novo animal.
   - `GET /animais/{id}` - Obter detalhes de um animal específico.
   - `PUT /animais/{id}` - Atualizar informações de um animal.
   - `DELETE /animais/{id}` - Excluir um animal.

3. **Tratamentos**
   - `POST /tratamento` - Cadastrar uma vacina ou medicamento para um animal.
   - `GET /tratamento/{id_animal}` - Listar vacinas e medicamentos de um animal.
   - `PUT /tratamento/{id}` - Atualizar uma vacina ou medicamento.
   - `DELETE /tratamento/{id}` - Excluir uma vacina ou medicamento.

## Como rodar o projeto localmente

### Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ou superior
- [Maven](https://maven.apache.org/install.html)
- [PostgreSQL](https://www.postgresql.org/download/)

### Configuração do banco de dados

1. Instale e configure o PostgreSQL.
2. Crie um banco de dados para o projeto:
   ```sql
   CREATE DATABASE pettracker;
 🚧 Em desenvolvimento 🚧
