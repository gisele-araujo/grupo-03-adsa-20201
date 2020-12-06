let login_usuario;
let nome_usuario;
let nome2_usuario;
let telefone_usuario;
let foto_usuario;

function redirecionar_login(){
}

function verificar_autenticacao() {
    login_usuario = sessionStorage.login_usuario_meuapp;
    nome_usuario = sessionStorage.nome_usuario_meuapp;
    nome2_usuario = sessionStorage.nome2_usuario_meuapp;
    telefone_usuario = sessionStorage.telefone_usuario_meuapp;
    foto_usuario = sessionStorage.foto_usuario_meuapp;

    if (login_usuario == undefined)  {
        redirecionar_login();
    } else {
        b_usuario.innerHTML = login_usuario;
        b_nome.innerHTML = nome_usuario;
        b_nome2.innerHTML = nome_usuario;
        b_telefone.innerHTML = telefone_usuario;
        imagem_perfil.src = foto_usuario;
        validar_sessao();
    }
    
}

function logoff() {
    finalizar_sessao();
    sessionStorage.clear();
    redirecionar_login();
    window.location.href = 'index-proeagle.html';
}

function validar_sessao() {
    fetch(`/usuarios/sessao/${login_usuario}`, {cache:'no-store'})
    .then(resposta => {
        if (resposta.ok) {
            resposta.text().then(texto => {
                console.log('Sessão :) ', texto);    
            });
        } else {
            console.error('Sessão :.( ');
            logoff();
        } 
    });    
}

function finalizar_sessao() {
    fetch(`/usuarios/sair/${login_usuario}`, {cache:'no-store'}); 
}