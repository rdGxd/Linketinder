export function renderJobList(container: HTMLElement | null) {
  if (!container) return;

  const jobs = [
    {
      title: "Desenvolvedor Full Stack",
      company: "Tech Corp",
      location: "São Paulo",
    },
    {
      title: "Engenheiro de Software",
      company: "Innova",
      location: "Rio de Janeiro",
    },
    {
      title: "Analista de Dados",
      company: "Data Insights",
      location: "Curitiba",
    },
  ];

  const jobListDiv = document.createElement("div");
  jobListDiv.innerHTML = `<h3>Vagas Disponíveis</h3>`;
  const ul = document.createElement("ul");

  jobs.forEach((job) => {
    const li = document.createElement("li");
    li.innerHTML = `
            <strong>${job.title}</strong> - ${job.company} (${job.location})
        `;
    ul.appendChild(li);
  });

  jobListDiv.appendChild(ul);
  container.appendChild(jobListDiv);
}
