export function renderCandidateList(container: HTMLElement | null) {
  if (!container) return;

  const candidates = [
    {
      skills: ["Python", "JavaScript"],
      education: "Bacharel em Ciência da Computação",
    },
    { skills: ["Java", "C#"], education: "Engenharia de Software" },
    { skills: ["PHP", "MySQL"], education: "Tecnologia da Informação" },
  ];

  const candidateListDiv = document.createElement("div");
  candidateListDiv.innerHTML = `<h3>Candidatos Anônimos</h3>`;
  const ul = document.createElement("ul");

  candidates.forEach((candidate) => {
    const li = document.createElement("li");
    li.innerHTML = `
            <strong>Competências:</strong> ${candidate.skills.join(", ")}<br>
            <strong>Formação:</strong> ${candidate.education}
        `;
    ul.appendChild(li);
  });

  candidateListDiv.appendChild(ul);
  container.appendChild(candidateListDiv);
}
