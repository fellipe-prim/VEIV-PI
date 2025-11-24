document.getElementById("supportForm").addEventListener("submit", async (e) => {
  e.preventDefault(); // ESSENCIAL para não abrir a página do Formspree

  const form = e.target;

  const response = await fetch(form.action, {
    method: "POST",
    body: new FormData(form),
    headers: { "Accept": "application/json" }
  });

  if (response.ok) {
    alert("Solicitação enviada com sucesso!");
    form.reset();
  } else {
    alert("Erro ao enviar. Tente novamente.");
  }
});
