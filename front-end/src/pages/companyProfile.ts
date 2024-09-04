import { renderCandidateList } from "../components/candidateList.js";
import { renderCompanyForm } from "../components/companyForm.js";

export function renderCompanyProfile(container: HTMLElement | null) {
  if (!container) return;

  container.innerHTML = `<h2>Perfil da Empresa</h2>`;
  renderCompanyForm(container);
  renderCandidateList(container);
}
