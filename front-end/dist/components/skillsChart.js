export function renderSkillsChart(container) {
    if (!container)
        return;
    const chartContainer = document.createElement("div");
    chartContainer.innerHTML = `
        <h3>Candidatos por Competência</h3>
        <canvas id="skillsChart"></canvas>
    `;
    container.appendChild(chartContainer);
    const skillsData = {
        Python: 12,
        Java: 19,
        JavaScript: 3,
        CSharp: 5,
        PHP: 2,
    };
    const canvas = document.getElementById("skillsChart");
    const ctx = canvas.getContext("2d");
    if (ctx) {
        const width = canvas.width;
        const height = canvas.height;
        const barWidth = width / Object.keys(skillsData).length;
        Object.entries(skillsData).forEach(([skill, count], index) => {
            const x = index * barWidth;
            const barHeight = (count / 20) * height;
            ctx.fillStyle = "rgba(75, 192, 192, 0.8)";
            ctx.fillRect(x, height - barHeight, barWidth - 5, barHeight);
            ctx.fillStyle = "#000";
            ctx.fillText(skill, x, height - barHeight - 5);
        });
    }
}
