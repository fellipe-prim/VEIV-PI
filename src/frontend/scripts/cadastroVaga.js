document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".formulario form");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();


    const vaga = {
      titulo: form.querySelector('input[placeholder="Título"]').value,
      local: form.querySelector('input[placeholder="Local"]').value,
      tipo: form.querySelector('input[placeholder="Tipo de vaga"]').value,
      area: form.querySelector('input[placeholder="Área"]').value,
      nivel: form.querySelector('input[placeholder="Nível"]').value,
      descricao: form.querySelector('input[placeholder="Descrição da vaga"]').value
    };

    try {

      const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vaga)
      });

      if (response.ok) {
        alert("Vaga cadastrada com sucesso!");
        form.reset();
      } else {
        alert("Erro ao cadastrar vaga.");
      }
    } catch (error) {
      console.error("Erro:", error);
      alert("Falha na comunicação com o servidor.");
    }
  });
});
