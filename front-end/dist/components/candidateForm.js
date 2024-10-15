import { handleFormSubmit } from "./candidateFormHandler.js";
export function renderCandidateForm(container) {
    if (!container)
        return;
    container.innerHTML = `
    <form id="candidateForm">
      <div>
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name">
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
      </div>
      <div>
        <label for="skills">Competências:</label>
        <input type="text" id="skills" name="skills">
      </div>
      <div>
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf">
      </div>
      <div>
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone">
      </div>
      <div>
        <label for="linkedin">Linkedin:</label>
        <input type="text" id="linkedin" name="linkedin">
      </div>
      <div>
        <label for="education">Formação:</label>
        <input type="text" id="education" name="education">
      </div>
      <button type="submit">Cadastrar</button>
    </form>
  `;
    const form = document.getElementById("candidateForm");
    form === null || form === void 0 ? void 0 : form.addEventListener("submit", handleFormSubmit);
}
