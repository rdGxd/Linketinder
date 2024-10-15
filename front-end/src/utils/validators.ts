import {cep, cnpj, cpf, email, linkedin, nome, regex, telefone} from "./regex.js";

export const validators = {
    name: (value: string) => regex(nome, value),
    email: (value: string) => regex(email, value),
    skills: () => true,
    cpf: (value: string) => regex(cpf, value),
    telefone: (value: string) => regex(telefone, value),
    linkedin: (value: string) => regex(linkedin, value),
    education: () => true,
    cnpj: (value: string) => regex(cnpj, value),
    cep: (value: string) => regex(cep, value),
};