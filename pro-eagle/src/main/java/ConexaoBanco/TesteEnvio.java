/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author adaias
 */
public class TesteEnvio {
    
    public static void main(String[] args) {
        
        SendDados env = new SendDados();
        
        env.sendDadosBD();
        
         DateTimeFormatter formaObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          LocalDateTime data = LocalDateTime.now();
          String dataFormatada = formaObj.format(data);
          
          System.out.println(dataFormatada);
        
    }
}
