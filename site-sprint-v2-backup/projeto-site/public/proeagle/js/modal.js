// MODAL DE AUTENTICAÇÃO-----------------------------------------------

function iniciaModal(modalID) {

    const modal = document.getElementById(modalID);
    modal.classList.add('mostrar'); //ativar classe .mostrar 
    modal.addEventListener('click', (event) => {
        if (event.target.id == modalID || event.target.className == 'fechar') {
            modal.classList.remove('mostrar'); //desativar classe .mostrar 
        }
    })
}

// login
const logar_menu = document.getElementById('loginAcesso'); // id do elemento clicável 
logar_menu.addEventListener('click', function () {
    iniciaModal('modal-login') // id do modal
})

// cadastro
const cadastrar_menu = document.getElementById('cadastroAcesso');
cadastrar_menu.addEventListener('click', function () {
    loginAcesso.classList.remove('mostrar')
    iniciaModal('modal-cadastro')
})

// MODAL DE PINTURAS-----------------------------------------------

function galeria() {
    let imagens_gallery = document.querySelectorAll('.small_img');
    let modal_gallery = document.querySelector('.modal-galeria');
    let modalImg = document.querySelector('#modal_img');
    let btClose = document.querySelector('#fechar_galeria');
    let srcVal = "";

    for (let i = 0; i < imagens_gallery.length; i++) {
        imagens_gallery[i].addEventListener('click', function () {

            srcVal = imagens_gallery[i].getAttribute('src');
            modalImg.setAttribute('src', srcVal);
            modal_gallery.classList.toggle('modal_active');
        });
    }

    btClose.addEventListener('click', function () {
        modal_gallery.classList.toggle('modal_active');
    });
}

// VER E ESCONDER A SENHA-----------------------------------------------

function versenha() {
    var mostrar = document.getElementById('login_senha');

    if (mostrar.type == 'password') {
        mostrar.type = 'text';
        img_senha.src = 'img/senha.jpeg';
    }
    else {
        mostrar.type = 'password';
        img_senha.src = 'img/ver_senha.jpeg';
    }
}

function versenha_cad() {
    var mostrar = document.getElementById('valida_senha');

    if (mostrar.type == 'password') {
        mostrar.type = 'text';
        img_senha.src = 'img/senha.jpeg';
    }
    else {
        mostrar.type = 'password';
        img_senha.src = 'img/ver_senha.jpeg';
    }
}

function versenha_conf() {
    var mostrar = document.getElementById('confirma_senha');

    if (mostrar.type == 'password') {
        mostrar.type = 'text';
        img_senha.src = '../public/img/senha.jpeg';
    }
    else {
        mostrar.type = 'password';
        img_senha.src = '../public/img/ver_senha.jpeg';
    }
}