document.addEventListener("DOMContentLoaded", async () => {
  const nomePerfil = document.querySelector(".nome_perfil");
  const fotoPerfil = document.querySelector(".foto_perfil");
  const options = document.querySelectorAll(".option");


  async function carregarPerfil() {
    try {
      const response = await fetch("http://localhost:3000/perfil", {
        headers: {
          "Authorization": "Bearer " + localStorage.getItem("token") 
        }
      });

      if (!response.ok) throw new Error("Não foi possível carregar perfil");

      const usuario = await response.json();

      nomePerfil.textContent = usuario.nome;
      fotoPerfil.src = usuario.foto || "default.png"; 
    } catch (err) {
      console.error(err);
      // nomePerfil.textContent = "Usuário Desconhecido";
      fotoPerfil.src = "default.png";
    }
  }

  carregarPerfil();


  options.forEach(option => {
    option.addEventListener("click", () => {
      const texto = option.querySelector("span").textContent;

      if (texto === "Currículo") {
        window.location.href = "curriculo.html";
      }
      if (texto === "Vagas aplicadas") {
        window.location.href = "candidaturas.html";
      }
      if (texto === "Editar perfil") {
        window.location.href = "editar-perfil.html";
      }
    });
  });


  document.querySelector(".botao_retorno").addEventListener("click", (e) => {
    e.preventDefault();
    window.history.back();
  });
});
