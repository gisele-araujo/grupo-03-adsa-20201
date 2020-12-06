/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConecxaoDoker;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author adaias
 */
public class ConexaoDocker {
    
    //    --> propridedade para conexão com BD
    private final BasicDataSource conectaBanco;

    public ConexaoDocker() {
        this.conectaBanco = new BasicDataSource();
        
//        --> definindo o Drive a ser usado para conexão
        this.conectaBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        --> Url do Banco de Dados --! caminho pelo qual as informações irão transitar
        this.conectaBanco.setUrl("jdbc:mysql://localhost:3306/pro_eagle");
//        --> Nosso Login (Usuário)
        this.conectaBanco.setUsername("root");
//        --> Nossa Senha 
        this.conectaBanco.setPassword("urubu100");
    }

    public BasicDataSource getConectaBanco() {
        return conectaBanco;
    }
}
