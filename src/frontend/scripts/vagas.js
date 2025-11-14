document.addEventListener("DOMContentLoaded", async () => {
  const lista = document.getElementById("listaVagas");
  const inputPesquisa = document.getElementById("pesquisaVaga");

  let vagasCarregadas = []; // armazenar para filtro

  async function carregarVagas() {
    try {
      const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa");

      if (!response.ok) throw new Error("Erro ao buscar vagas");

      const vagas = await response.json();
      vagasCarregadas = vagas;

      renderVagas(vagas);
    } catch (err) {
      console.error(err);
      lista.innerHTML = `<p>❌ Erro ao carregar vagas.</p>`;
    }
  }

  function renderVagas(vagas) {
    lista.innerHTML = "";

    if (vagas.length === 0) {
      lista.innerHTML = `<p>Nenhuma vaga encontrada.</p>`;
      return;
    }

    vagas.forEach(v => {
      const card = document.createElement("a");
      card.classList.add("card");


      card.href = `./detalheVagas.html?id=${v.id || ""}`;

      card.innerHTML = `
        <h3>${v.tituloVaga}</h3>
        <p><strong>Empresa:</strong> ${v.empresa}</p>
        <p>${v.descricao}</p>
      `;

      lista.appendChild(card);
    });
  }

  // filtro por texto digitado
  inputPesquisa.addEventListener("input", () => {
    const termo = inputPesquisa.value.toLowerCase();

    const filtradas = vagasCarregadas.filter(v =>
      v.tituloVaga.toLowerCase().includes(termo) ||
      v.descricao.toLowerCase().includes(termo) ||
      v.empresa.toLowerCase().includes(termo)
    );

    renderVagas(filtradas);
  });

  carregarVagas();
});
