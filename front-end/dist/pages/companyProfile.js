import { renderCandidateList } from "../components/candidateList.js";
import { renderCompanyForm } from "../components/companyForm.js";
import { renderSkillsChart } from "../components/skillsChart.js";
export function renderCompanyProfile(container) {
    if (!container)
        return;
    container.innerHTML = `<h2>Perfil da Empresa</h2>`;
    renderCompanyForm(container);
    renderCandidateList(container);
    renderSkillsChart(container);
}
