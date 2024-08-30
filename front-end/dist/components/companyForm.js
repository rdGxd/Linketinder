export function renderCompanyForm(container) {
    if (!container)
        return;
    container.innerHTML = `
        <form id="companyForm">
            <div>
                <label for="companyName">Nome da Empresa:</label>
                <input type="text" id="companyName" name="companyName">
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email">
            </div>
            <div>
                <label for="sector">Setor:</label>
                <input type="text" id="sector" name="sector">
            </div>
            <div>
                <label for="description">Descrição:</label>
                <input type="text" id="description" name="description">
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    `;
    const form = document.getElementById("companyForm");
    form === null || form === void 0 ? void 0 : form.addEventListener("submit", (event) => {
        event.preventDefault();
        const formData = new FormData(form);
        console.log(Object.fromEntries(formData.entries()));
    });
}
