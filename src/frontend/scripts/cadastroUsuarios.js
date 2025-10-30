document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formCadastro");

  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const data = {
      nomeCompleto: form.querySelector('input[placeholder="Nome"]').value,
      email: form.querySelector('input[placeholder="E-mail"]').value,
      cpf: form.querySelector('input[placeholder="CPF"]').value,
      telefone: form.querySelector('input[placeholder="Telefone"]').value,
      endereco: form.querySelector('input[placeholder="Endereço"]').value,
      curso: document.getElementById('input[placeholder="Curso"]').value
    };

    try {
      const response = await fetch("http://localhost:8080/api/v1/alunos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        alert("Cadastro realizado com sucesso!");
        form.reset();
      } else {
        const error = await response.json();
        alert("Erro: " + (error.message || "Não foi possível cadastrar."));
      }
    } catch (err) {
      console.error(err);
      alert("Erro de conexão com o servidor.");
    }
  });
});
