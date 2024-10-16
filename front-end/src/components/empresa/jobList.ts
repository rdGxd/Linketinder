export function renderJobList(container: HTMLElement | null) {
  if (!container) return;
  const jobs = JSON.parse(localStorage.getItem("empresas") || "[]");

  const jobListDiv = document.createElement("div");
  jobListDiv.innerHTML = `<h3>Lista de vagas</h3>`;

  const ul = document.createElement("ul");
  jobs.forEach((job: any) => {
    const li = document.createElement("li");
    li.innerHTML = `
      <strong>${job.title}</strong> - ${job.companyName} (${job.location})
    `;
    ul.appendChild(li);
  });

  container.appendChild(ul);
}
