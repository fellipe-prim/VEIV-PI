document.addEventListener("DOMContentLoaded", async () => {
  const container = document.querySelector(".container");

  try {
    const response = await fetch("http://localhost:8080/api/v1/curriculos");
    if (!response.ok) throw new Error("Erro ao carregar currículos");

    const page = await response.json();

    const curriculos = page.content; // 👈 pega a lista aqui!!

    if (!curriculos || curriculos.length === 0) {
      container.innerHTML = "<p>Nenhum currículo encontrado.</p>";
      return;
    }

    curriculos.forEach(c => {
      const card = document.createElement("div");
      card.classList.add("candidato-card");

      card.innerHTML = `
        <h3>${c.nome}</h3>
        <p><strong>Sobre:</strong> ${c.sobre}</p>
        <p><strong>Habilidades técnicas:</strong> ${c.habilidadesTecnicas}</p>
        <p><strong>Experiência profissional:</strong> ${c.experienciaProfissional}</p>
        <p><strong>Previsão de conclusão:</strong> ${c.previsaoDeConclusao}</p>
        <p><strong>Projetos:</strong> ${c.projetos || "Nenhum projeto informado"}</p>
      `;

      container.appendChild(card);
    });

  } catch (error) {
    console.error("Erro:", error);
    container.innerHTML = "<p>Não foi possível carregar os currículos.</p>";
  }
});
