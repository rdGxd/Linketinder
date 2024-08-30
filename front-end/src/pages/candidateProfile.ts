import { renderCandidateForm } from "../components/candidateForm.js";
import { renderJobList } from "../components/jobList.js";

export function renderCandidateProfile(container: HTMLElement | null) {
  if (!container) return;

  container.innerHTML = `<h2>Perfil do Candidato</h2>`;
  renderCandidateForm(container);
  renderJobList(container);
}
