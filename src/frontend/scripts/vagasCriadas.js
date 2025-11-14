document.addEventListener("DOMContentLoaded", async () => {
  const listaVagas = document.getElementById("listaVagas");

  try {
    const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa");
    
    if (!response.ok) {
      throw new Error("Erro ao buscar vagas");
    }

    const vagas = await response.json();

    if (vagas.length === 0) {
      listaVagas.innerHTML = `<p>Nenhuma vaga cadastrada ainda.</p>`;
      return;
    }

    vagas.forEach(vaga => {
      const div = document.createElement("div");
      div.classList.add("bloco_vaga");

      div.innerHTML = `
        <h3>${vaga.tituloVaga}</h3>
        <p><strong>Empresa:</strong> ${vaga.empresa}</p>
        <p><strong>Endereço:</strong> ${vaga.endereco}</p>
        <p><strong>Requisitos:</strong> ${vaga.requisitos}</p>
        <p><strong>Descrição:</strong> ${vaga.descricao}</p>
      `;

      listaVagas.appendChild(div);
    });

  } catch (error) {
    console.error("Erro ao carregar vagas:", error);
    listaVagas.innerHTML = `<p>❌ Erro ao carregar vagas do servidor.</p>`;
  }
});
