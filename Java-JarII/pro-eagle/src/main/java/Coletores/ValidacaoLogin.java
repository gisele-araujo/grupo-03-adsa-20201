/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import ConexaoBanco.Conexao;
import ConexaoBanco.DadosLogin;
import ConexaoBanco.SetSends;
import Executaveis.ScreenEagle;
import Testes.Teste1;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.font.TrueTypeFont;

/**
 *
 * @author Gabriel
 */
public class ValidacaoLogin {

    private String emailSetado;
    private String senhaSetada;
    private String alertaEmail;
    private String alertaSenha;
    private String validadar;

    private Boolean confirmar;
    private Boolean senhaOk;
    private Boolean emailOk;
    private Boolean start;

//    --> conexão com o Banco de dados Azure
    
    Conexao connecta = new Conexao();
    JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());
    
    
    
    
    public boolean verificaAcessoBD() {
        
        Boolean teste = false;
        
        List<DadosLogin> listaDadosLogin = template.query("SELECT email,senha FROM cadastro",
                new BeanPropertyRowMapper(DadosLogin.class));
        System.out.println("");

        for (int i = 0; i < listaDadosLogin.size(); i++) {
            if (listaDadosLogin.get(i).getEmail().equals(emailSetado) && listaDadosLogin.get(i).getSenha().equals(senhaSetada)) {
                this.validadar = "Parabéns! esta logado!";
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ScreenEagle().setVisible(true);
                    }
                });
                this.start = true;
                teste = true;
            }else{
                this.validadar = "Usuario não encontrado";
                teste = false;
            }
        } 
        return teste;
    }

//  --> validar email... previamente
    public void verificarLogin(String email) {

        if ((email.contains("@")) && (email.contains(".")) && (email.contains(".com"))) {
            this.alertaEmail = "Email Válido";
            this.emailSetado = email;
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
            this.senhaSetada = senha;
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

            verificaAcessoBD();

        } else {
            this.validadar = "Digite novamente!";
        }
    }

    public String getEmail() {
        return emailSetado;
    }

    public String getSenha() {
        return senhaSetada;
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

    public Boolean getStart() {
        return start;
    }
    
    

}
