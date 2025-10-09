document.addEventListener("DOMContentLoaded", () => {
  const cardsContainer = document.querySelector(".cards-container");
  const searchInput = document.querySelector(".search-container input");

  
  function renderVagas(vagas) {
    cardsContainer.innerHTML = ""; 
    vagas.forEach(vaga => {
      const card = document.createElement("div");
      card.classList.add("card");

      card.innerHTML = `
        <h3>${vaga.titulo}</h3>
        <p>${vaga.descricao}</p>
      `;

      cardsContainer.appendChild(card);
    });
  }

 
  async function fetchVagas() {
    try {
      const response = await fetch("http://localhost:3000/vagas"); 
      //if (!response.ok) throw new Error("Erro ao carregar vagas");

      const vagas = await response.json();
      renderVagas(vagas);

   
      searchInput.addEventListener("input", () => {
        const termo = searchInput.value.toLowerCase();
        const vagasFiltradas = vagas.filter(vaga =>
          vaga.titulo.toLowerCase().includes(termo) ||
          vaga.descricao.toLowerCase().includes(termo)
        );
        renderVagas(vagasFiltradas);
      });

    } catch (err) {
      console.error(err);
     // cardsContainer.innerHTML = "<p>Erro ao carregar vagas.</p>";
    }
  }

  fetchVagas();
});
