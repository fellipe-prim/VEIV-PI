document.addEventListener("DOMContentLoaded", () => {
  const nomePerfil = document.querySelector(".nome_perfil");
  const fotoPerfil = document.querySelector(".foto_perfil");
  const options = document.querySelectorAll(".option");

  async function carregarPerfilEmpresa() {
    try {
      const response = await fetch("http://localhost:3000/empresa/perfil", {
        headers: {
          "Authorization": "Bearer " + localStorage.getItem("token") 
        }
      });

      if (!response.ok) throw new Error("Erro ao carregar perfil da empresa");

      const empresa = await response.json();
      nomePerfil.textContent = empresa.nome;
      fotoPerfil.src = empresa.logo || "empresa_default.png";
    } catch (err) {
      console.error(err);
      nomePerfil.textContent = "Empresa";
      fotoPerfil.src = "empresa_default.png";
    }
  }

  carregarPerfilEmpresa();


  options.forEach(option => {
    option.addEventListener("click", () => {
      const texto = option.querySelector("span").textContent;

      if (texto === "Vagas criadas") {
        window.location.href = "vagas_empresa.html";
      }
      if (texto === "Criar nova vaga") {
        window.location.href = "criar_vaga.html";
      }
      if (texto === "Candidatos") {
        window.location.href = "candidatos.html";
      }
    });
  });

  document.querySelector(".botao_retorno").addEventListener("click", (e) => {
    e.preventDefault();
    window.history.back();
  });
});