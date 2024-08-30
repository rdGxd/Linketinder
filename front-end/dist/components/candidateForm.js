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
                <label for="education">Formação:</label>
                <input type="text" id="education" name="education">
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    `;
    const form = document.getElementById("candidateForm");
    form === null || form === void 0 ? void 0 : form.addEventListener("submit", (event) => {
        event.preventDefault();
        const formData = new FormData(form);
        console.log(Object.fromEntries(formData.entries()));
    });
}
