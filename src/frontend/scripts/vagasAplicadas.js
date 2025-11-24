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

    function renderVagas(vagas) {
        listaVagas.innerHTML = "";

        vagas.forEach(vaga => {
            const div = document.createElement("div");
            div.classList.add("bloco_vaga");

            div.innerHTML = `
                <h3>${vaga.tituloVaga ?? "Sem título"}</h3>
                <p><strong>Empresa:</strong> ${vaga.empresa ?? "Não informado"}</p>
                <p><strong>Endereço:</strong> ${vaga.endereco ?? "Não informado"}</p>
                <p><strong>Requisitos:</strong> ${vaga.requisitos ?? "Não informado"}</p>
                <p><strong>Descrição:</strong> ${vaga.descricao ?? "Sem descrição"}</p>

                <div class="acoes">
                    <button class="ver" data-id="${vaga.id}">
                    <i class="fa-solid fa-eye"></i> Ver
                    </button>
                </div>
                `;

            listaVagas.appendChild(div);
        });
        }

  carregarVagas();
});
