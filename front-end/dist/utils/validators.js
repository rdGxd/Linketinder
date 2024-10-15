import { cep, cnpj, cpf, email, linkedin, nome, regex, telefone } from "./regex.js";
export const validators = {
    name: (value) => regex(nome, value),
    email: (value) => regex(email, value),
    skills: () => true,
    cpf: (value) => regex(cpf, value),
    telefone: (value) => regex(telefone, value),
    linkedin: (value) => regex(linkedin, value),
    education: () => true,
    cnpj: (value) => regex(cnpj, value),
    cep: (value) => regex(cep, value),
};
