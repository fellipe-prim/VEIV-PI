document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".formulario form");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const vaga = {
      empresa: form.empresa.value.trim(),
      descricao: form.descricao.value.trim(),
      requisitos: form.requisitos.value.trim(),
      tituloVaga: form.tituloVaga.value.trim(),
      endereco: form.endereco.value.trim(),
    };

    try {
      const response = await fetch("http://localhost:8080/api/v1/vagasEmpresa", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vaga),
      });

      if (response.ok) {
        alert("✅ Vaga cadastrada com sucesso!");
        form.reset();
      } else {
        const errorText = await response.text();
        console.error("Erro ao cadastrar:", errorText);
        alert("❌ Erro ao cadastrar vaga.");
      }
    } catch (error) {
      console.error("Erro de rede:", error);
      alert("⚠️ Falha na comunicação com o servidor.");
    }
  });
});
