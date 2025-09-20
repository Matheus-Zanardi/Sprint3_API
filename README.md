# Projeto API - Sprint

## Descrição do Projeto
Este projeto é uma API desenvolvida em **Java** utilizando o **Spring Boot**, com persistência de dados em **Oracle Database**.
A API expõe endpoints HTTP para operações de criação, consulta, atualização e remoção de dados relacionados a clientes e investimentos.

---

## Passos de Configuração e Execução

1. **Pré-requisitos**
   - Java 17 ou superior
   - Maven
   - Oracle Database configurado e acessível
   - IntelliJ IDEA (ou outra IDE compatível)

2. **Clonar o projeto**
   ```bash
   git clone <url-do-repositorio>
   ```

3. **Configurar credenciais do banco de dados**
   No arquivo `src/main/resources/application.properties`, ajuste as propriedades de conexão conforme o seu ambiente:

   ```properties
   spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/xe
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   ```

   > **Importante**: Substitua `SEU_USUARIO` e `SUA_SENHA` pelas credenciais do seu banco Oracle.

4. **Executar a aplicação**
   No IntelliJ ou no terminal:
   ```bash
   mvn spring-boot:run
   ```

   A aplicação será iniciada em:
   ```
   http://localhost:8080
   ```

---

## Exemplos de Requisições e Respostas

### 1. Criar Cliente (POST)
**Requisição:**
```
POST http://localhost:8080/clientes
Body (JSON):
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "12345678900"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "12345678900"
}
```

---

### 2. Consultar Cliente (GET)
**Requisição:**
```
GET http://localhost:8080/clientes/1
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpf": "12345678900"
}
```

---
### 3. Editar Cliente (PUT)
**Requisição:**
```
GET http://localhost:8080/clientes?id="id"
```
**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva editado",
  "email": "joao@email.com",
  "cpf": "12345678900"
}
```

### 4. Deletar Cliente (DELETE)
**Requisição:**
```
GET http://localhost:8080/clientes/"id"
```
**Resposta (204 OK):**


"sem conteudo"
```



## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Maven**
- **Oracle Database**
- **Postman** (para testes de requisições HTTP)
- **IntelliJ IDEA** (ambiente de desenvolvimento)