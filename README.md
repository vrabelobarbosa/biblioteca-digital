# Biblioteca Digital: Sistema Integrado de Gestão de Livros

Projeto desenvolvido para a disciplina de **Object Oriented Programming** do curso de **Análise e Desenvolvimento de Sistemas** da faculdade **UniFECAF**.\
Aluno: **Vinicius Rabelo Barbosa**.

## 📚 Sobre o Projeto

O projeto consiste em um sistema de gerenciamento de livros para uma biblioteca municipal.\
Permite cadastrar, listar, atualizar e excluir livros, tanto no back-end (Spring Boot + PostgreSQL) quanto no front-end (HTML + CSS + JavaScript).

## 🎯 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.5**
- **PostgreSQL**
- **pgAdmin4**
- **HTML5**
- **CSS3**
- **JavaScript**
- **Maven**
- **IntelliJ IDEA**

## 🚰 Funcionalidades Implementadas

- Cadastro de novos livros
- Listagem de livros
- Atualização de informações dos livros
- Exclusão de livros
- Integração front-end e back-end via API REST
- Banco de dados relacional (PostgreSQL) integrado

## 🧹 Estrutura do Projeto

- **Back-end (Spring Boot)**: lógica de negócio e acesso ao banco.
- **Front-end (HTML/CSS/JS)**: interação com o usuário.
- **Banco de dados (PostgreSQL)**: persistência dos dados.

## 🗄️ Diagrama de Classes

```
+---------------------------+
|          Livro            |
+---------------------------+
| - id: Long                |
| - titulo: String          |
| - autor: String           |
| - anoPublicacao: Integer  |
| - isbn: String            |
+---------------------------+
| + getters e setters       |
+---------------------------+
         ▲
         |
+----------------------------------+
| <<interface>> LivroRepository   |
+----------------------------------+
| + save(Livro): Livro             |
| + findById(Long): Optional<Livro>|
| + findAll(): List<Livro>         |
| + deleteById(Long): void         |
+----------------------------------+
         ▲
         |
+-----------------------------------+
|        LivroService               |
+-----------------------------------+
| - repo: LivroRepository           |
+-----------------------------------+
| + salvar(Livro): Livro            |
| + listarLivros(): List<Livro>     |
| + buscarPorId(Long): Optional<Livro> |
| + atualizar(Long, Livro): Livro   |
| + deletar(Long): void             |
+-----------------------------------+
         ▲
         |
+-----------------------------------+
|         LivroController          |
+-----------------------------------+
| - service: LivroService           |
+-----------------------------------+
| + cadastrar(Livro): ResponseEntity<Livro> |
| + listarTodos(): ResponseEntity<List<Livro>> |
| + buscarPorId(Long): ResponseEntity<Livro> |
| + atualizar(Long, Livro): ResponseEntity<Livro> |
| + deletar(Long): ResponseEntity<Void> |
+-----------------------------------+
```

## 📄 Como Executar o Projeto

### Backend

1. Clonar o repositório:

```bash
git clone https://github.com/vrabelobarbosa/biblioteca-digital.git
```

2. Importar o projeto no IntelliJ IDEA como projeto Maven.

3. Configurar o banco de dados PostgreSQL no arquivo `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

4. Rodar o projeto:

```bash
mvn spring-boot:run
```

Ou pela IDE, clicando em `GestorlivrosApplication`.

### Frontend

1. Navegar até a pasta onde está o arquivo `index.html`.
2. Abrir o arquivo `index.html` diretamente no navegador.

## 🚧 Observações Finais

- O projeto segue os princípios da Programação Orientada a Objetos (POO).
- Utiliza o padrão RESTful para comunicação entre o front-end e back-end.
- Arquitetura MVC aplicada.
- Front-end responsivo básico para operações CRUD.

---

## 📌 Conclusão

Projeto desenvolvido para consolidar conhecimentos em:

- Spring Boot
- APIs REST
- Banco de dados relacional
- Integração front-end e back-end
- Programacão Orientada a Objetos (POO)

---

💌 Muito obrigado pela oportunidade de aprendizado! 🚀