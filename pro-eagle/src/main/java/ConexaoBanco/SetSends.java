/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

/**
 *
 * @author adaias
 */
public class SetSends {
    
    public static void main(String[] args) {
        
//        --> Classe feita para enviar todos os dados necessários

        Boolean dadosEnv = true;
        Boolean infoEnv = false;
        Boolean alertEnv = true;
        
        SendDados envDados = new SendDados();
        SendInfo envInfo = new SendInfo();
        SendAlert envAlert = new SendAlert();
        
//        --> verificação de informações sobre a componentes. Caso haja as informações no correspondendes ele não envia de novo
        if(!infoEnv){
            envInfo.sendInformacoes();
            infoEnv = true;
        }
        
        
//        --> envio continuo dos dados de CPU, Disco, Memoria  && Os alertas caso necessários!
        if(alertEnv){
            envAlert.sendAlertas();
        }
        
        if(dadosEnv){
            envDados.sendDadosBD();
        }
        
        
        
        
        
    }
    
}
