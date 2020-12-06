// // validação do formulário de cadastro -----------------------------------------------

// /* enquanto o usuário digita um campo, uma validação (que está armazenada em uma função disparada por onkeyup) 
// será acionada, caso todas as variáveis globais sejam iguais à TRUE, o usuário será cadastrado com sucesso,
// caso contrário, será exibido uma mensagem de erro. */


// let validado_nome = false;
// let validado_email = false;
// let validado_senha = false;
// let validado_conf_senha = false;
// let validado_cnpj = false;
// let validado_tel = false;


// function validacao_nome() {
//     let nome_usuario = valida_nome.value.trim();
//     msg = document.getElementById('mensagem_nome');

//     msg.innerHTML = '';

//     if (nome_usuario) {
//         msg.innerHTML = 'Nome OK!';
//         msg.style.color = '#008000';
//         validado_nome = true;

//     } else {
//         msg.innerHTML = 'Digite seu nome.';
//         msg.style.color = '#0078d7';

//     }

// }

// function validacao_email() {
//     let email = valida_email.value.trim();
//     msg = document.getElementById('mensagem_email');

//     msg.innerHTML = '';

//     if (email) {
//         for (let i = 0; i <= email.length - 1; i++) {

//             if (email.indexOf('@') >= 0 && email.indexOf('.') >= 0 && email.indexOf(' ') == -1) {
//                 msg.innerHTML = 'Email OK!';
//                 msg.style.color = '#008000';
//                 validado_email = true;

//             } else {
//                 msg.innerHTML = 'Digite um email válido.';
//                 msg.style.color = '#0078d7';
//             }
//         }
//     }
// }

// function validacao_senha() {
//     let senha = valida_senha.value;
//     msg = document.getElementById('mensagem_senha');

//     msg.innerHTML = '';

//     if (senha) {
//         for (let i = 0; i <= senha.length - 1; i++) {

//             if (senha.length >= 8) {
//                 msg.innerHTML = 'Senha OK!';
//                 msg.style.color = '#008000';
//                 validado_senha = true;

//             } else {
//                 msg.innerHTML = 'Sua senha deve conter pelo menos 8 caracteres'
//                 msg.style.color = '#0078d7';
//             }
//         }
//     }
// }

// function validarCNPJ() {
//     let cnpj = input_cnpj_cad.value.trim();
//     let msg = document.getElementById('mensagem_cnpj');

//     msg.innerHTML = '';

//     if (cnpj) {
//         for (let i = 0; i <= cnpj.length - 1; i++) {

//             if (cnpj.length == 18) {
//                 msg.innerHTML = 'CNPJ OK!'
//                 msg.style.color = '#008000';
//                 validado_cnpj = true;
//             }
//             else {
//                 msg.innerHTML = 'Digite o CNPJ de sua empresa'
//                 msg.style.color = '#0078d7';
//             }
//         }
//     }
// }

// function validarTel() {
//     let telefone = input_telefone.value.trim();
//     let msg = document.getElementById('mensagem_tel');

//     if (telefone) {
//         msg.innerHTML = 'Telefone OK!';
//         msg.style.color = '#008000';
//         validado_tel = true;

//     } else {
//         msg.innerHTML = 'Digite seu telefone';
//         msg.style.color = '#0078d7';

//     }

// }


// // CADASTRO

// //function cadastrar(event) {
//    // event.preventDefault();

// //alert('teste')

//     // let name = validaNome.value;
//     // let email = validaEmail.value;
//     // let password = validaSenha.value;
//     // let conf_senha = confirmaSenha.value;
//     // let senha_valida = password == conf_senha;

//     // confirmação de senha

//     // if (conf_senha) {
//     //     if (senha_valida) {
//     //         validado_conf_senha = true;

//     //     } else {
//     //         confirma_senha.value = '';
//     //     }
//     // }

//     // // validação final dos dados

//     // if (validado_nome == false || valida_email == false || validado_senha == false || validado_conf_senha == false || validado_cnpj == false || validado_tel == false) {

//     //     mensagem_erro.innerHTML = 'Por favor, preencha os campos corretamente conforme orientações';

//     //     document.getElementById("modalCad").animate([
//     //         { transform: 'translateX(0px)'},
//     //         { transform: 'translateX(-20px)'},
//     //         { transform: 'translateX(20px)'},
//     //         { transform: 'translateX(0px)'},
//     //     ],{
//     //         duration: 150,
//     //     })

//     // } else {

//         // mensagem para o usuário
//         // sucesso.classList.add("fadeIn");
//         // sucesso.style.display = 'block'
//         // formulario_cad.style.display = 'none';


//         // CÓDIGO PARA ENVIO DE INFORMAÇÕES AO BANCO DE DADOS

//         //criando uma variavel para os parametros que serao enviados
//        // let params = "nome=" + name + "&email=" + email + "&senha=" + password;

//         //abrindo a conexão com a rota
//        // let ajax = new XMLHttpRequest();
//       //  ajax.open("POST", "http://localhost:3333/users");
//        // ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
//       //  ajax.send(params);
//     // }
// //}
// formularioCad.addEventListener("submit", cadastrar);

 // LOGIN 

let ouvir = document.getElementById('formularioLogin');
ouvir.addEventListener('submit', logar);
 
let emailx = document.getElementById('loginEmail');
let senhax = document.getElementById('exampleInputPassword1');

 function logar(event) {
     event.preventDefault();

     let ajax = new XMLHttpRequest();
     let emailV = emailx.value;
     let senhaV = senhax.velue;
     let params = "email=" + emailV + "&senha=" + senhaV;

     //abre conexao com a nossa rota de get
     ajax.open("POST", "http://localhost:3333/login");
     ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');




     //verifica se a nossa rota devolveu uma resposta
     ajax.onreadystatechange = function () {
         if (ajax.status == 200 && ajax.readyState == 4) {

             let usuarios = JSON.parse(ajax.responseText);
             //let email_digitado = loginEmail.value;
             //let nome_cadastrado = '';


             //for (let i = 0; i < usuarios.length; i++) {

                 if (usuarios.length == 0) {
                    mensagem_erro_login.innerHTML = 'Usuário não encontrado. Verifique se o email e a senha estão corretos.';
                    alert('erro');
                     //nome_cadastrado = usuarios[i].NomeCompleto;
                     

                     // sessionStorage.nomeUsuario = nome_cadastrado;
                     // sessionStorage.mudaMenu = 'none';
                     // sessionStorage.mudaMenuLogin = 'inline-block';
                 }else{
                    window.location.href = 'carregando.html';
                 }
             }

            // if (nome_cadastrado == '') {
                // mensagem_erro_login.innerHTML = 'Usuário não encontrado. Verifique se o email e a senha estão corretos.';
               //  alert('erro');
            // }

         }
     //Para a conexao funcionar, temos que colocar o ajax.send, porem como a rota é de get, não enviamos nada
     ajax.send();
 }
 // formularioLogin.addEventListener("submit", logar);

function enviarCadastro(event){
  event.preventDefault();

  cadastroOk();
}

function cadastroOk(){

       let nome_inserido = validaNome.value;
       let cargo_inserido = cargo.value;
       let email_inserido = validaEmail.velue;
       let telefone_inserido = fone.value;
       let foto_inserido = end.value;
       let senha_inserido = validaSenha.value;

       
       let params = "nome=" + nome_inserido + "&email=" + email_inserido + "&senha="+ senha_inserido + "&cargo=" + cargo_inserido + "&telefone" + telefone_inserido + "&foto" + foto_inserido;

       let ajax = new XMLHttpRequest();
       ajax.open("POST", "http://localhost:3333/users");
       ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
       ajax.send(params);

}
