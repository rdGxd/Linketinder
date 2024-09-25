export function renderCandidateList(container) {
    if (!container)
        return;
    const candidates = JSON.parse(localStorage.getItem("candidatos") || "[]");
    // Exibir a lista de candidatos
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
    // Contar a quantidade de candidatos por competência
    const skillCounts = {};
    candidates.forEach((candidate) => {
        const skills = candidate.skills.toLowerCase().split(","); // Assume que as competências estão separadas por vírgulas
        skills.forEach((skill) => {
            skill = skill.trim(); // Remove espaços em branco
            if (skillCounts[skill]) {
                skillCounts[skill]++;
            }
            else {
                skillCounts[skill] = 1;
            }
        });
    });
    // Preparar os dados para o gráfico
    const skills = Object.keys(skillCounts);
    const counts = Object.values(skillCounts);
    // Criar gráfico de barras
    const graphDiv = document.createElement("div");
    graphDiv.style.display = "flex";
    graphDiv.style.alignItems = "flex-end";
    graphDiv.style.marginTop = "20px";
    // Adiciona cada barra ao gráfico
    skills.forEach((skill, index) => {
        const barDiv = document.createElement("div");
        barDiv.style.width = "50px"; // Largura da barra
        barDiv.style.height = `${counts[index] * 20}px`; // Altura da barra proporcional
        barDiv.style.backgroundColor = "rgba(75, 192, 192, 0.7)";
        barDiv.style.marginRight = "10px";
        barDiv.style.display = "flex";
        barDiv.style.alignItems = "flex-end";
        barDiv.style.justifyContent = "center";
        barDiv.style.position = "relative";
        // Adiciona o número de candidatos acima da barra
        const label = document.createElement("span");
        label.textContent = counts[index].toString();
        label.style.position = "absolute";
        label.style.bottom = "100%";
        label.style.color = "#000";
        label.style.fontWeight = "bold";
        barDiv.appendChild(label);
        graphDiv.appendChild(barDiv);
    });
    candidateListDiv.appendChild(graphDiv);
}
