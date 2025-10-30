document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formCurriculo");

  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const data = {
      nome: form.querySelector('input[placeholder="Nome"]').value,
      sobre: form.querySelector('textarea[placeholder="Sobre você"]').value,
      habilidadesTecnicas: form.querySelector('textarea[placeholder^="Habilidades"]').value,
      experienciaProfissional: form.querySelector('textarea[placeholder="Experiência profissional"]').value,
      previsaoDeConclusao: form.querySelector('input[placeholder^="Previsão"]').value,
      projetos: form.querySelector('textarea[placeholder^="Projetos"]').value
    };

    try {
      const response = await fetch("http://localhost:8080/api/v1/curriculos", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert("Currículo enviado com sucesso!");
        form.reset();
      } else {
        const error = await response.json();
        alert("Erro: " + (error.message || "Não foi possível enviar."));
      }
    } catch (err) {
      console.error("Erro na requisição:", err);
      alert("Erro de conexão com o servidor.");
    }
  });
});
