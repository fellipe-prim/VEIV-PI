document.addEventListener("DOMContentLoaded", () => {
  const lista = document.getElementById("listaVagas");
  const inputPesquisa = document.getElementById("pesquisaVaga");
  let vagasCarregadas = [];

  function normalizeToArray(payload) {
    if (Array.isArray(payload)) return payload;

    if (payload == null) return [];

    if (typeof payload === "object") {
      const keysToCheck = ["content", "data", "vagas", "items", "result", "rows"];
      for (const k of keysToCheck) {
        if (Array.isArray(payload[k])) return payload[k];
      }

      for (const k of Object.keys(payload)) {
        if (Array.isArray(payload[k])) return payload[k];
      }

      return [payload];
    }

    if (typeof payload === "string") {
      try {
        const parsed = JSON.parse(payload);
        return normalizeToArray(parsed);
      } catch (err) {
        console.warn("Resposta como string não-JSON:", payload);
        return [];
      }
    }

    return [];
  }

  function renderVagas(vagas) {
    lista.innerHTML = "";

    if (!vagas || vagas.length === 0) {
      lista.innerHTML = `<p>Nenhuma vaga encontrada.</p>`;
      return;
    }

    vagas.forEach(v => {
      const card = document.createElement("a");
      card.classList.add("card");
      card.href = `./detalheVagas.html?id=${v.id ?? ""}`;

      const titulo = v.tituloVaga ?? v.titulo ?? v.title ?? "Título não informado";
      const empresa = v.empresa ?? v.company ?? "Empresa não informada";
      const descricao = v.descricao ?? v.description ?? "";

      card.innerHTML = `
        <h3>${titulo}</h3>
        <p><strong>Empresa:</strong> ${empresa}</p>
        <p>${descricao}</p>

`;

      lista.appendChild(card);
    });
  }

  async function carregarVagas() {
    try {
      const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa");

      console.log("Status:", response.status, response.statusText);
      let json;
      try {
        json = await response.json();
      } catch (err) {
        const txt = await response.text();
        console.error("Resposta não é JSON. Texto recebido:", txt);
        lista.innerHTML = `<p>❌ Erro: resposta do servidor inválida.</p>`;
        return;
      }

      console.log("Payload recebido do GET /vagasEmpresa:", json);

      const vagas = normalizeToArray(json);
      vagasCarregadas = vagas;
      renderVagas(vagas);

    } catch (err) {
      console.error("Erro ao buscar vagas:", err);
      lista.innerHTML = `<p>❌ Erro ao carregar vagas do servidor.</p>`;
    }
  }

  if (inputPesquisa) {
    inputPesquisa.addEventListener("input", () => {
      const termo = inputPesquisa.value.trim().toLowerCase();
      const filtradas = vagasCarregadas.filter(v => {
        const titulo = (v.tituloVaga ?? v.titulo ?? v.title ?? "").toLowerCase();
        const descricao = (v.descricao ?? v.description ?? "").toLowerCase();
        const empresa = (v.empresa ?? v.company ?? "").toLowerCase();

        return titulo.includes(termo) || descricao.includes(termo) || empresa.includes(termo);
      });
      renderVagas(filtradas);
    });
  }

  carregarVagas();
});