📘 Diagrama de Classes
A seguir é apresentado o Diagrama de Classes utilizado para modelar a aplicação Biblioteca Digital: Sistema Integrado de Gestão de Livros.

O diagrama representa as classes fundamentais e as relações entre elas, com breve descrição da responsabilidade de cada classe:

+-----------------+
|     Livro       |
+-----------------+
| - id: Long      |
| - titulo: String|
| - autor: String |
| - anoPub: Int   |
| - isbn: String  |
+-----------------+
| + getters/setter|
+-----------------+
▲
| (usa)
|
+----------------------+           +------------------------+
|    LivroRepository   | ◄───────► |     LivroService       |
+----------------------+           +------------------------+
| + save()             |           | - repo: LivroRepository|
| + findById()         |           +------------------------+
| + findAll()          |           | + salvar()             |
| + deleteById()       |           | + listarLivros()       |
+----------------------+           | + buscarPorId()        |
| + atualizar()          |
| + deletar()            |
+------------------------+
▲
| (usa)
|
+------------------------+
|     LivroController    |
+------------------------+
| - service:LivroService |
+------------------------+
| + cadastrar()          |
| + listarTodos()        |
| + buscarPorId()        |
| + atualizar()          |
| + deletar()            |
+------------------------+