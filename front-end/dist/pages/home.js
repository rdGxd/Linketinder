export function renderHome(container) {
    if (!container)
        return;
    container.innerHTML = `
        <h1>Bem-vindo ao Linketinder</h1>
        <p>Escolha uma opção para prosseguir:</p>
        <ul>
            <li><a href="/candidate">Perfil do Candidato</a></li>
            <li><a href="/company">Perfil da Empresa</a></li>
        </ul>
    `;
}
