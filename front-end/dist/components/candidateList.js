export function renderCandidateList(container) {
    if (!container)
        return;
    const candidates = JSON.parse(localStorage.getItem("candidatos") || "[]");
    const candidateListDiv = document.createElement("div");
    candidateListDiv.innerHTML = `<h3>Candidatos Anônimos</h3>`;
    const ul = document.createElement("ul");
    candidates.forEach((candidate) => {
        const li = document.createElement("li");
        li.innerHTML = `
      <strong>Competências:</strong> ${candidate.skills}<br>
      <strong>Formação:</strong> ${candidate.education}
    `;
        ul.appendChild(li);
    });
    candidateListDiv.appendChild(ul);
    container.appendChild(candidateListDiv);
}
