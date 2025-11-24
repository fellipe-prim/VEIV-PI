document.addEventListener("DOMContentLoaded", carregarDetalhe);

async function carregarDetalhe() {
  const detalhe = document.getElementById("detalhe");

  const params = new URLSearchParams(window.location.search);
  const id = params.get("id");

  if (!id) {
    detalhe.innerHTML = "<p>ID da vaga não informado.</p>";
    return;
  }

  try {
    const resp = await fetch(`http://localhost:8080/api/v1/vagasEmpresa/${id}`);

    if (!resp.ok) {
      detalhe.innerHTML = "<p>Erro ao carregar detalhes da vaga.</p>";
      return;
    }

    const vaga = await resp.json();

    detalhe.innerHTML = `
      <div class="bloco_vaga">
        <h3>${vaga.tituloVaga}</h3>

        <p><strong>Empresa:</strong> ${vaga.empresa}</p>
        <p><strong>Endereço:</strong> ${vaga.endereco}</p>
        <p><strong>Requisitos:</strong> ${vaga.requisitos}</p>
        <p><strong>Descrição:</strong> ${vaga.descricao}</p>

        <button id="btnCandidatar" class="botao-candidatar">Candidatar-se</button>
      </div>
    `;

    const botao = document.getElementById("btnCandidatar");

        botao.addEventListener("click", () => {
        alert("Candidatado com sucesso!");
        });
        
  } catch (err) {
    console.error("Erro:", err);
    detalhe.innerHTML = "<p>Erro ao buscar vaga.</p>";
  }
}
