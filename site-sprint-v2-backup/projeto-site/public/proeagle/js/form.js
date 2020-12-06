function logar(event) {
    event.preventDefault();

    let ajax = new XMLHttpRequest();

    //abre conexao com a nossa rota de get
    ajax.open("GET", "http://localhost:3333/users");

    //verifica se a nossa rota devolveu uma resposta
    ajax.onreadystatechange = function () {
        if (ajax.status == 200 && ajax.readyState == 4) {

            let usuarios = JSON.parse(ajax.responseText);
            let email_digitado = login_email.value;
            let nome_cadastrado = '';


            for (let i = 0; i < usuarios.length; i++) {

                if (email_digitado == usuarios[i].Email) {
                    nome_cadastrado = usuarios[i].Nome;
                    window.location.href = 'carregando.html';

                    sessionStorage.nomeUsuario = nome_cadastrado;
                }
            }

            if (nome_cadastrado == '') {
                alert('erro')
            }

        }
    }
    //Para a conexao funcionar, temos que colocar o ajax.send, porem como a rota é de get, não enviamos nada
    ajax.send();
}

let form_login = document.getElementById("formulario_login")
form_login.addEventListener("submit", logar);
