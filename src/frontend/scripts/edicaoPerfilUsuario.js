document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");

  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    
    const formData = new FormData();
    formData.append("nome", form.querySelector('input[placeholder="Nome"]').value);
    formData.append("email", form.querySelector('input[placeholder="E-mail"]').value);
    formData.append("cpf", form.querySelector('input[placeholder="CPF"]').value);
    formData.append("telefone", form.querySelector('input[placeholder="Telefone"]').value);
    formData.append("endereco", form.querySelector('input[placeholder="Endereço"]').value);

    const fileInput = form.querySelector('input[type="file"]');
    if (fileInput.files.length > 0) {
      formData.append("foto", fileInput.files[0]);
    }

    try {
      const response = await fetch("http://localhost:8080/api/v1/alunos/1", {
        method: "PUT", 
        body: formData
      });

      if (response.ok) {
        alert("Perfil atualizado com sucesso!");
      } else {
        const error = await response.json();
        alert("Erro: " + (error.message || "Não foi possível atualizar o perfil."));
      }
    } catch (err) {
      console.error(err);
      alert("Erro de conexão com o servidor.");
    }
  });
});
