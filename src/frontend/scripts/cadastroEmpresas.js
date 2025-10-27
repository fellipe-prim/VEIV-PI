document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".formulario");

  form.addEventListener("submit", async (e) => {
    e.preventDefault(); 


    const dados = {
      nome: form.querySelector('input[placeholder="Nome da empresa"]').value,
      email: form.querySelector('input[placeholder="E-mail"]').value,
      telefone: form.querySelector('input[placeholder="Telefone"]').value,
      endereco: form.querySelector('input[placeholder="Endereço"]').value,
      cnpj: form.querySelector('input[placeholder="CNPJ"]').value
    };

    try {
     
      const response = await fetch("http://localhost:8080/api/v1/empresas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
      });

      if (response.ok) {
        alert("Empresa cadastrada com sucesso!");
        form.reset();
      } else {
        alert("Erro ao cadastrar empresa.");
      }
    } catch (error) {
      console.error("Erro na requisição:", error);
      alert("Falha na comunicação com o servidor.");
    }
  });
});
