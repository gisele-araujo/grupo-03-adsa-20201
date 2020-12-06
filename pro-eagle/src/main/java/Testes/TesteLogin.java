/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import ConexaoBanco.Conexao;
import ConexaoBanco.DadosLogin;
import Excluir.ScreenEagle;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author adaias
 */
public class TesteLogin {
    
    public static void main(String[] args) {
        
        
        Conexao connecta = new Conexao();
        JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());
        Teste1 posha = new Teste1();
        
        
        
        List<DadosLogin> listaDadosNhe = template.query("SELECT email,senha FROM cadastro WHERE email= ? AND senha= ?",
                new BeanPropertyRowMapper(DadosLogin.class),
                "adaias.santos@bandtec.com.br", "adaias123");
        
       // System.out.println(listaDadosNhe.isEmpty());
        
        if(listaDadosNhe.isEmpty()){
            System.out.println("HACKER!");
            
        }else{
            System.out.println("CONSEGUIMOS SANTOS! SOMOS ZIKA");
            
        }
        
        
        
    }
//    
//    public static void runNow(){
//            Teste1 posha = new Teste1();
//            
//            
//        }
    
}
