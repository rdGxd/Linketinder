import { validators } from "../utils/validators.js";

type FormFields = 'name' | 'email' | 'skills' | 'cpf' | 'telefone' | 'linkedin' | 'education';

export function handleFormSubmit(event: Event) {
    event.preventDefault();
    const form = event.target as HTMLFormElement;
    const formData = new FormData(form);
    const candidate = Object.fromEntries(formData.entries());
    const candidates = JSON.parse(localStorage.getItem("candidatos") || "[]");

    for (const [key, value] of formData.entries()) {
        const fieldKey = key as FormFields;
        if (validators[fieldKey] && !validators[fieldKey](value as string)) {
            alert(`${fieldKey.charAt(0).toUpperCase() + fieldKey.slice(1)} inválido`);
            return;
        }
    }

    candidates.push(candidate);
    localStorage.setItem("candidatos", JSON.stringify(candidates));
    console.log("Candidato salvo:", candidate);
}