document.addEventListener("DOMContentLoaded", async () => {
  const listaVagas = document.getElementById("listaVagas");

  function normalizeToArray(payload) {
    if (Array.isArray(payload)) return payload;
    if (payload == null) return [];

    if (typeof payload === "object") {
      for (const key of ["content", "data", "items", "vagas", "rows", "result"]) {
        if (Array.isArray(payload[key])) return payload[key];
      }
      return [payload];
    }

    if (typeof payload === "string") {
      try {
        return normalizeToArray(JSON.parse(payload));
      } catch {
        return [];
      }
    }

    return [];
  }

  async function carregarVagas() {
    try {
      const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa");

      if (!response.ok) throw new Error("Erro ao buscar vagas");

      let json = await response.json();
      const vagas = normalizeToArray(json);

      if (vagas.length === 0) {
        listaVagas.innerHTML = `<p>Nenhuma vaga aplicada ainda.</p>`;
        return;
      }

      renderVagas(vagas);

    } catch (error) {
      console.error("Erro ao carregar vagas:", error);
      listaVagas.innerHTML = `<p>❌ Erro ao carregar vagas do servidor.</p>`;
    }
  }

    function renderVagasIndex(vagas) {
    listaVagas.innerHTML = "";

    vagas.forEach(vaga => {
        const card = document.createElement("a");
        card.classList.add("card");       
        card.href = `detalheVagas2.html?id=${vaga.id}`;

        card.innerHTML = `
            <h3>${vaga.tituloVaga ?? "Sem título"}</h3>
            <p><strong>Empresa:</strong> ${vaga.empresa ?? "Não informado"}</p>
            <p><strong>Local:</strong> ${vaga.endereco ?? "Não informado"}</p>
            <p><strong>Descrição:</strong> ${vaga.descricao ?? "Sem descrição"}</p>
        `;

        listaVagas.appendChild(card);
    });
  }

    async function carregarVagasRecentes() {
      try {
        const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa");
        if (!response.ok) throw new Error("Erro ao buscar vagas");

        let json = await response.json();
        let vagas = normalizeToArray(json);

        // Ordena da mais nova (id maior) para a mais antiga
        vagas.sort((a, b) => b.id - a.id);

        // Pega só as 4 mais novas (troca o número se quiser)
        const vagasRecentes = vagas.slice(0, 1);

        renderVagasIndex(vagasRecentes);

      } catch (error) {
        console.error("Erro ao carregar vagas:", error);
      }
  }

  carregarVagasRecentes();
});


