/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class Conexao {

  
    private String acerto;
    private String erro;

    public String getAcerto() {
        return acerto;
    }

    public String getErro() {
        return erro;
    }

    public void setAcerto(String acerto) {
        this.acerto = acerto;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
    
    
    

//    --> propridedade para conexão com BD
    private final BasicDataSource conectaBanco;

    public Conexao() {
        this.conectaBanco = new BasicDataSource();
        try {
       
//        --> definindo o Drive a ser usado para conexão
                this.conectaBanco.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        --> Url do Banco de Dados --! caminho pelo qual as informações irão transitar
                this.conectaBanco.setUrl("jdbc:sqlserver://proeagle-oficial.database.windows.net:1433;database=PRO EAGLE;user=ProEagle-admin@proeagle-oficial;password={#Gfgrupo3a};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
//        --> Nosso Login (Usuário)
                this.conectaBanco.setUsername("ProEagle-admin");
//        --> Nossa Senha 
                this.conectaBanco.setPassword("#Gfgrupo3a");
               
                acerto = "banco conectado com sucesso";
                
                      
         } catch (Exception e) {
             erro = "erro ao conectar com banco";
        }

    }

    public BasicDataSource getConectaBanco() {
        return conectaBanco;

    }
}
