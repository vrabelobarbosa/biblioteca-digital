const apiUrl = "http://localhost:8080/livros";
let editandoId = null;

// Lista todos os livros
function listarLivros() {
    const tabela = document.getElementById("tabelaLivros");
    tabela.innerHTML = "<tr><td colspan='6'>Carregando...</td></tr>";

    fetch(apiUrl)
        .then(res => res.json())
        .then(livros => {
            tabela.innerHTML = "";
            livros.forEach(livro => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td data-label="ID">${livro.id}</td>
                    <td data-label="Título">${livro.titulo}</td>
                    <td data-label="Autor">${livro.autor}</td>
                    <td data-label="Ano">${livro.anoPublicacao}</td>
                    <td data-label="ISBN">${livro.isbn}</td>
                    <td data-label="Ações">
                        <button class="edit" onclick="editarLivro(${livro.id})">Editar</button>
                        <button class="delete" onclick="deletarLivro(${livro.id})">Deletar</button>
                    </td>
                `;
                tabela.appendChild(tr);
            });
        })
        .catch(err => alert("Erro ao carregar livros: " + err));
}

// Salva novo livro ou atualiza existente
function salvarLivro(event) {
    event.preventDefault();

    const titulo = document.getElementById("titulo").value.trim();
    const autor = document.getElementById("autor").value.trim();
    const ano = parseInt(document.getElementById("anoPublicacao").value);
    const isbn = document.getElementById("isbn").value.trim();

    if (!titulo || !autor || isNaN(ano) || !isbn) {
        alert("Preencha todos os campos corretamente.");
        return;
    }

    const livro = { titulo, autor, anoPublicacao: ano, isbn };
    const metodo = editandoId ? "PUT" : "POST";
    const url = editandoId ? `${apiUrl}/${editandoId}` : apiUrl;

    fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(livro)
    })
    .then(res => {
        if (!res.ok) throw new Error("Erro na operação");
        return res.json();
    })
    .then(() => {
        alert(editandoId ? "Livro atualizado!" : "Livro cadastrado!");
        resetFormulario();
        listarLivros();
    })
    .catch(err => alert("Falha ao salvar: " + err));
}

// Carrega dados no formulário para edição
function editarLivro(id) {
    fetch(`${apiUrl}/${id}`)
        .then(res => res.json())
        .then(livro => {
            document.getElementById("titulo").value = livro.titulo;
            document.getElementById("autor").value = livro.autor;
            document.getElementById("anoPublicacao").value = livro.anoPublicacao;
            document.getElementById("isbn").value = livro.isbn;
            editandoId = livro.id;
            document.getElementById("submitButton").textContent = "Atualizar";
            document.getElementById("cancelarEdicao").style.display = "inline-block";
        })
        .catch(err => alert("Erro ao buscar livro: " + err));
}

// Deleta livro
function deletarLivro(id) {
    if (!confirm("Confirma exclusão deste livro?")) return;
    fetch(`${apiUrl}/${id}`, { method: "DELETE" })
        .then(() => {
            alert("Livro deletado!");
            listarLivros();
        })
        .catch(err => alert("Erro ao deletar: " + err));
}

// Cancela a edição em andamento
function resetFormulario() {
    editandoId = null;
    document.getElementById("livroForm").reset();
    document.getElementById("submitButton").textContent = "Cadastrar";
    document.getElementById("cancelarEdicao").style.display = "none";
}

// Eventos
document.getElementById("livroForm").addEventListener("submit", salvarLivro);
document.getElementById("cancelarEdicao").addEventListener("click", resetFormulario);

// Inicialização
listarLivros();