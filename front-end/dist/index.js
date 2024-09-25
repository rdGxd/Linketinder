import { initApp } from "./app.js";
document.addEventListener("DOMContentLoaded", () => {
    initApp();
    localStorage.setItem("candidatos", JSON.stringify([
        {
            name: "teste1",
            email: "teste1@1",
            skills: "JAVA, PYTHON, JAVASCRIPT",
            cpf: "0000123123",
            telefone: "123123",
            linkedin: "12312",
            education: "123123",
        },
        {
            name: "teste23232323",
            email: "teste1@232323232323233",
            skills: "Java",
            cpf: "0aaaaaaaaaaaaaaaaa",
            telefone: "aaaaaaaaaaaaaaaa",
            linkedin: "aaaaaaaaaaaaaaa",
            education: "aaaaaaaaaaaaaaa",
        },
        {
            name: "teste23232323",
            email: "teste1@232323232323233",
            skills: "JA FUI E VOLTEI",
            cpf: "0aaaaaaaaaaaaaaaaa",
            telefone: "aaaaaaaaaaaaaaaa",
            linkedin: "aaaaaaaaaaaaaaa",
            education: "aaaaaaaaaaaaaaa",
        },
    ]));
    localStorage.setItem("empresas", JSON.stringify([
        {
            title: "Desenvolvedor Full Stack",
            companyName: "Tech Corp",
            location: "São Paulo",
        },
        {
            title: "Engenheiro de Software",
            companyName: "Innova",
            location: "Rio de Janeiro",
        },
        {
            title: "Analista de Dados",
            companyName: "Data Insights",
            location: "Curitiba",
        },
    ]));
});
