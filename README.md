# Desafio: CRUD de Clientes

Este projeto é a resolução do **Desafio: CRUD de clientes**, proposto no módulo Back-end (Capítulo: API REST, camadas, CRUD, exceções, validações) da **Formação Desenvolvedor Moderno** da [DevSuperior](https://devsuperior.com.br).

A aplicação consiste em uma API REST completa para o gerenciamento de clientes (`Client`), utilizando boas práticas de desenvolvimento em camadas, tratamento de exceções customizado e validações de dados.

## 🚀 Tecnologias Utilizadas

*   **Java 17** 
*   **Spring Boot** (Web, Data JPA, Validation)
*   **Banco de Dados H2** (Ambiente de testes/Instância em memória)
*   **Maven** (Gerenciador de dependências)

## 📐 Modelo de Domínio (Entidade Client)

A classe `Client` mapeia as informações do cliente com os seguintes atributos:
*   `id` (Long)
*   `name` (String)
*   `cpf` (String)
*   `income` (Double)
*   `birthDate` (LocalDate)
*   `children` (Integer)

*Nota: O script de sementes SQL (`import.sql`) respeita a conversão do padrão CamelCase da JPA para SnakeCase no banco de dados (ex: `birth_date`).*

## 🛠️ Funcionalidades Implementadas

O projeto implementa as 5 operações básicas de um CRUD:
1. **Busca paginada de recursos**: `GET /clients`
2. **Busca de recurso por ID**: `GET /clients/{id}`
3. **Inserir novo recurso**: `POST /clients`
4. **Atualizar recurso**: `PUT /clients/{id}`
5. **Deletar recurso**: `DELETE /clients/{id}`

### 🛡️ Validações e Tratamento de Exceções

*   **Id não encontrado:** Retorna o código de status `404 Not Found` caso o recurso solicitado via `GET`, `PUT` ou `DELETE` não exista.
*   **Erros de Validação:** Retorna o código de status `422 Unprocessable Entity` com mensagens customizadas para cada campo inválido.
    *   `name`: Não pode ser vazio ou em branco.
    *   `birthDate`: Não pode ser uma data futura (`@PastOrPresent`).

## 📊 Carga de Dados (Seed)
O banco de dados H2 é inicializado automaticamente com um seed de **10 clientes cadastrados** contendo dados significativos para testes imediatos.

## 🏁 Como Executar o Projeto

### Pré-requisitos
*   Java JDK instalado
*   Git instalado

### Passos para execução
1. Clone este repositório em sua máquina local:
   ```bash
   git clone https://github.com/k3vinrich4rd/desafio-devsuperior-crud-clientes.git
   ```
2. Abra a sua IDE de preferência (Eclipse, IntelliJ, VS Code) e importe o projeto como um projeto Maven existente.
3. Aguarde a baixa das dependências e execute a classe principal da aplicação (`Application.java`).
4. A API estará disponível em `http://localhost:8080`.
5. O console do banco de dados H2 pode ser acessado em `http://localhost:8080/h2-console` (verifique as credenciais no arquivo `application.properties`).

## 🧪 Testes no Postman

As rotas foram estruturadas para responder exatamente às requisições do checklist de correção:

*   **Busca por ID:** `GET http://localhost:8080/clients/1`
*   **Busca Paginada:** `GET http://localhost:8080/clients?page=0&size=6&sort=name`
*   **Inserção (POST):** `POST http://localhost:8080/clients`
*   **Atualização (PUT):** `PUT http://localhost:8080/clients/1`
*   **Exclusão (DELETE):** `DELETE http://localhost:8080/clients/1`

## ✅ Checklist de Avaliação (10/10)

- [x] 1. Busca por id retorna cliente existente
- [x] 2. Busca por id retorna 404 para cliente inexistente
- [x] 3. Busca paginada retorna listagem paginada corretamente
- [x] 4. Inserção de cliente insere cliente com dados válidos
- [x] 5. Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos
- [x] 6. Atualização de cliente atualiza cliente com dados válidos
- [x] 7. Atualização de cliente retorna 404 para cliente inexistente
- [x] 8. Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos
- [x] 9. Deleção de cliente deleta cliente existente
- [x] 10. Deleção de cliente retorna 404 para cliente inexistente