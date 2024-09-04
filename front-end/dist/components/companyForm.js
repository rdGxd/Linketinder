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
                <label for="title">Titulo da vaga:</label>
                <input type="text" id="title" name="title">
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
                <label for="cnpj">CNPJ:</label>
                <input type="text" id="cnpj" name="cnpj">
            </div>
            <div>
                <label for="telefone">Telefone:</label>
                <input type="text" id="telefone" name="telefone">
            </div>
            <div>
                <label for="cep">CEP:</label>
                <input type="text" id="cep" name="cep">
            </div>
            <div>
                <label for="skills">Location:</label>
                <input type="text" id="location" name="location">
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
        const empresa = Object.fromEntries(formData.entries());
        const empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
        empresas.push(empresa);
        localStorage.setItem("empresas", JSON.stringify(empresas));
        console.log("Empresa salva:", empresa);
    });
    const verifyTelefone = (telefone) => {
        const telefoneRegex = /^\(?\d{2}\)?\s?9?\d{4}\-?\d{4}$/;
        return telefoneRegex.test(telefone);
    };
}
