document.addEventListener("DOMContentLoaded", () => {
  carregarDados();
  document.getElementById("formEditar").addEventListener("submit", salvarEdicao);
});

const params = new URLSearchParams(window.location.search);
const id = params.get("id");

async function carregarDados() {
  if (!id) return;

  try {
    const resp = await fetch(`http://localhost:8080/api/v1/vagasEmpresa/${id}`);

    if (!resp.ok) return;

    const vaga = await resp.json();

    document.getElementById("tituloVaga").value = vaga.tituloVaga;
    document.getElementById("empresa").value = vaga.empresa;
    document.getElementById("endereco").value = vaga.endereco;
    document.getElementById("requisitos").value = vaga.requisitos;
    document.getElementById("descricao").value = vaga.descricao;

  } catch (err) {
    console.error("Erro ao carregar dados:", err);
  }
}

async function salvarEdicao(event) {
  event.preventDefault();

  const dadosAtualizados = {
    tituloVaga: document.getElementById("tituloVaga").value,
    empresa: document.getElementById("empresa").value,
    endereco: document.getElementById("endereco").value,
    requisitos: document.getElementById("requisitos").value,
    descricao: document.getElementById("descricao").value
  };

  try {
    const resp = await fetch(`http://localhost:8080/api/v1/vagasEmpresa/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(dadosAtualizados)
    });

    if (resp.ok) {
      alert("Vaga atualizada com sucesso!");
      window.location.href = "vagasCriadas.html";
    } else {
      alert("Erro ao atualizar vaga.");
    }

  } catch (err) {
    console.error("Erro ao editar:", err);
    alert("Erro ao atualizar a vaga.");
  }
}
