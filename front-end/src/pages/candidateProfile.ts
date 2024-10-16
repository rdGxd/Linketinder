import { renderCandidateForm } from "../components/candidatos/candidateForm";
import { renderJobList } from "../components/empresa/jobList";

export function renderCandidateProfile(container: HTMLElement | null) {
  if (!container) return;

  container.innerHTML = `<h2>Perfil do Candidato</h2>`;
  renderCandidateForm(container);
  renderJobList(container);
}
