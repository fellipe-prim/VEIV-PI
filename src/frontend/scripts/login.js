document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");

  form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.querySelector("#email").value;
    const senha = document.querySelector("#senha").value;

    const data = { email, senha };

    try {
      const response = await fetch("http://localhost:3000/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      });

      if (response.ok) {
        const result = await response.json();

        // salva token no localStorage para manter login
        localStorage.setItem("token", result.token);

        alert("Login realizado com sucesso!");
        window.location.href = "index.html"; // redireciona após login
      } else {
        const error = await response.json();
        alert("Erro: " + (error.message || "E-mail ou senha inválidos."));
      }
    } catch (err) {
      console.error(err);
      alert("Erro de conexão com o servidor.");
    }
  });
});
