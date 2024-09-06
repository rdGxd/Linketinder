export const telefone = /^\(?\d{2}\)?\s?9?\d{4}\-?\d{4}$/;
export const cnpj = /^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/;
export const cpf = /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/;
export const email = /^[a-z0-9.]+@[a-z0-9]+\.[a-z]+(\.[a-z]+)?$/;
export const cep = /^\d{5}\-\d{3}$/;
export const nome = /^[a-zA-Z]+$/;
export const linkedin = /^https:\/\/www\.linkedin\.com\/in\/[a-zA-Z]+$/;
export const regex = (regex, value) => regex.test(value);
