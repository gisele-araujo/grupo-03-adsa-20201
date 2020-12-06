/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import ConexaoBanco.Conexao;
import ConexaoBanco.DadosLogin;
import Excluir.ScreenEagle;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Gabriel
 */
public class ValidacaoLogin {

    private String email;
    private String senha;
    private String alertaEmail;
    private String alertaSenha;
    private String validadar;

    private Boolean confirmar;
    private Boolean senhaOk;
    private Boolean emailOk;
    
    
//    --> conexão com o Banco de dados Azure
    Conexao connecta = new Conexao();
    JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());
    List<DadosLogin> listaDadosLogin = template.query("SELECT email,senha FROM cadastro WHERE email= ? AND senha= ?",
                new BeanPropertyRowMapper(DadosLogin.class),
                email, senha);
   
    
//  --> validar email... previamente
    public void verificarLogin(String email) {

        if ((email.contains("@")) && (email.contains(".")) && (email.contains(".com"))) {
            this.alertaEmail = "Email Válido";
            this.email = email;
            this.emailOk = true;
        } else {
            this.alertaEmail = "Email Inválido";
            this.emailOk = false;
        }
    }
    
    
    
//    --> validar senha... previamente
    public void verificarSenha(String senha) {

        if ((senha.length()) >= 8) {
            this.alertaSenha = "Senha Válida";
            this.senha = senha;
            this.senhaOk = true;
        } else {
            this.alertaSenha = "Senha deve ter no mínimo 8 caracteres";
            this.senhaOk = false;
        }
    }

//    --> quando email e senha estão com as validações corretas... o sistema disponibiliza a conexão
    public void podemosConectar() {

        if ((emailOk.equals(true)) && (senhaOk.equals(true))) {
            this.confirmar = true;
        } else {
            this.confirmar = false;
        }
    }
    
    
    
//    --> conexão com o BD, e vericação da existencia dos email e senha inserido
    public void conecxaoSegura() {

        if (confirmar) {
                
                 if(this.email.equals("pedro.rocha@bandtec.com.br") && this.senha.equals("pedro123")){
                                      java.awt.EventQueue.invokeLater(new Runnable() {
                             public void run() {
                             new ScreenEagle().setVisible(true);
            }
        }); 
            
//                if (listaDadosLogin.isEmpty()) {
//                    this.validadar = "Usuario não encontrado";
//                } else {
//                    this.validadar = "Parabéns! esta logado!";
//                            java.awt.EventQueue.invokeLater(new Runnable() {
//                             public void run() {
//                             new ScreenEagle().setVisible(true);
//            }
//        });
//                    System.out.println("Achado");  
//                }
            
        } else {
            this.validadar = "Digite novamente!";
        }
    }
    }


    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getAlertaEmail() {
        return alertaEmail;
    }

    public String getAlertaSenha() {
        return alertaSenha;
    }

    public String getValidado() {
        return validadar;
    }

}
