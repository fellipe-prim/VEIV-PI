document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");

    form.addEventListener("submit", async (event) => {
      event.preventDefault(); 

      const data = {
        nome: form.querySelector('input[placeholder="Nome"]').value,
        dataNascimento: form.querySelector('input[type="date"]').value,
        endereco: form.querySelector('input[placeholder="Endereço"]').value,
        telefone: form.querySelector('input[placeholder="Telefone"]').value,
        email: form.querySelector('input[placeholder="E-mail"]').value,
        links: form.querySelector('input[placeholder^="Links"]').value,
        formacao: form.querySelector('textarea[placeholder="Formação acadêmica"]').value,
        experiencia: form.querySelector('textarea[placeholder="Experiência profissional"]').value
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
        alert("Erro de conexão com o servidor.");
        console.error(err);
      }
    });
  });

