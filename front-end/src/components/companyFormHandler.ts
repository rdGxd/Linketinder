import { validators } from "../utils/validators.js";

export function handleCompanyFormSubmit(event: Event) {
    event.preventDefault();
    const form = event.target as HTMLFormElement;
    const formData = new FormData(form);
    const empresa = Object.fromEntries(formData.entries());
    const empresas = JSON.parse(localStorage.getItem("empresas") || "[]");

    if (!validators.name(formData.get("companyName") as string)) {
        alert("Nome da empresa inválido");
        return;
    }
    if (!validators.cnpj(formData.get("cnpj") as string)) {
        alert("CNPJ inválido");
        return;
    }
    if (!validators.email(formData.get("email") as string)) {
        alert("Email inválido");
        return;
    }
    if (!validators.cep(formData.get("cep") as string)) {
        alert("CEP inválido");
        return;
    }

    empresas.push(empresa);
    localStorage.setItem("empresas", JSON.stringify(empresas));
    console.log("Empresa salva:", empresa);
}