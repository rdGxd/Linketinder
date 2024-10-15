import { validators } from "../utils/validators.js";
export function handleFormSubmit(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);
    const candidate = Object.fromEntries(formData.entries());
    const candidates = JSON.parse(localStorage.getItem("candidatos") || "[]");
    for (const [key, value] of formData.entries()) {
        const fieldKey = key;
        if (validators[fieldKey] && !validators[fieldKey](value)) {
            alert(`${fieldKey.charAt(0).toUpperCase() + fieldKey.slice(1)} inválido`);
            return;
        }
    }
    candidates.push(candidate);
    localStorage.setItem("candidatos", JSON.stringify(candidates));
    console.log("Candidato salvo:", candidate);
}
