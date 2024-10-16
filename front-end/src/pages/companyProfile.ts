import { renderCandidateList } from "../components/candidatos/candidateList";
import { renderCompanyForm } from "../components/empresa/companyForm";

export function renderCompanyProfile(container: HTMLElement | null) {
  if (!container) return;

  container.innerHTML = `<h2>Perfil da Empresa</h2>`;
  renderCompanyForm(container);
  renderCandidateList(container);
}
