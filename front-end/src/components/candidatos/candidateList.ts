export function renderCandidateList(container: HTMLElement | null) {
  if (!container) return;

  const candidates = JSON.parse(localStorage.getItem("candidatos") || "[]");

  const candidateListDiv = document.createElement("div");
  candidateListDiv.innerHTML = `<h3>Candidatos Anônimos</h3>`;

  const ul = document.createElement("ul");
  candidates.forEach((candidate: any) => {
    const li = document.createElement("li");
    li.innerHTML = `
            <strong>Competências:</strong> ${candidate.skills}<br>
            <strong>Formação:</strong> ${candidate.education}
        `;
    ul.appendChild(li);
  });

  candidateListDiv.appendChild(ul);
  container.appendChild(candidateListDiv);

  const skillCounts: { [key: string]: number } = {};
  candidates.forEach((candidate: any) => {
    const skills = candidate.skills.toUpperCase().trim().split(",");
    skills.forEach((skill: string) => {
      skill = skill.trim();
      if (skillCounts[skill]) {
        skillCounts[skill]++;
      } else {
        skillCounts[skill] = 1;
      }
    });
  });

  const skills = Object.keys(skillCounts);
  const counts = Object.values(skillCounts);

  const graphDiv = document.createElement("div");
  graphDiv.style.display = "flex";
  graphDiv.style.alignItems = "flex-end";
  graphDiv.style.marginTop = "20px";

  skills.forEach((skill, index) => {
    const barContainer = document.createElement("div");
    barContainer.style.display = "flex";
    barContainer.style.flexDirection = "column";
    barContainer.style.alignItems = "center";
    barContainer.style.marginRight = "10px";

    const barDiv = document.createElement("div");
    barDiv.style.width = "50px";
    barDiv.style.height = `${counts[index] * 20}px`;
    barDiv.style.backgroundColor = "rgba(75, 192, 192, 0.7)";
    barDiv.style.display = "flex";
    barDiv.style.alignItems = "flex-end";
    barDiv.style.justifyContent = "center";
    barDiv.style.position = "relative";

    const label = document.createElement("span");
    label.textContent = counts[index].toString();
    label.style.position = "absolute";
    label.style.bottom = "100%";
    label.style.color = "#000";
    label.style.fontWeight = "bold";

    const skillLabel = document.createElement("span");
    skillLabel.textContent = skill;
    skillLabel.style.marginTop = "5px";
    skillLabel.style.color = "#000";
    skillLabel.style.fontSize = "12px";
    skillLabel.style.textAlign = "center";

    barDiv.appendChild(label);
    barContainer.appendChild(barDiv);
    barContainer.appendChild(skillLabel);
    graphDiv.appendChild(barContainer);
  });

  candidateListDiv.appendChild(graphDiv);
}
