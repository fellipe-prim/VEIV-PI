document.addEventListener("DOMContentLoaded", async () => {
  const container = document.querySelector("body");

  try {
  
    const response = await fetch("http://localhost:8080/vagas-criadas");
    if (!response.ok) throw new Error("Erro ao buscar vagas criadas");

    const vagas = await response.json();

   
    const titulo = document.querySelector(".titulo");


    const vagasContainer = document.createElement("div");
    vagasContainer.classList.add("vagas-container");

  
    vagas.forEach(vaga => {
      const bloco = document.createElement("div");
      bloco.classList.add("bloco_vaga");

      bloco.innerHTML = `
        <h3>${vaga.titulo}</h3>
        <p><strong>Descrição da vaga:</strong> ${vaga.descricao}</p>
      `;

      vagasContainer.appendChild(bloco);
    });


    titulo.insertAdjacentElement("afterend", vagasContainer);

  } catch (error) {
    console.error("Erro:", error);
    container.insertAdjacentHTML("beforeend", "<p>Não foi possível carregar as vagas criadas.</p>");
  }
});
