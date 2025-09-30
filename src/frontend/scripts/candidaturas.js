document.addEventListener("DOMContentLoaded", async () => {
  const numCandidatosEl = document.querySelector(".num_candidatos");
  const container = document.querySelector(".container");

  try {
    
    const response = await fetch("http://localhost:8080/vagas/1/candidaturas"); 
    if (!response.ok) throw new Error("Erro ao carregar candidaturas");

    const candidatos = await response.json();


    numCandidatosEl.textContent = `${candidatos.length} candidaturas`;


    candidatos.forEach(c => {
      const card = document.createElement("div");
      card.classList.add("candidato-card");
      card.innerHTML = `
        <h3>${c.nome}</h3>
        <p><strong>Email:</strong> ${c.email}</p>
        <p><strong>Telefone:</strong> ${c.telefone}</p>
        <p><strong>Currículo:</strong> <a href="${c.curriculo}" target="_blank">Visualizar</a></p>
      `;
      container.appendChild(card);
    });

  } catch (error) {
    console.error("Erro:", error);
    numCandidatosEl.textContent = "Não foi possível carregar candidaturas.";
  }
});