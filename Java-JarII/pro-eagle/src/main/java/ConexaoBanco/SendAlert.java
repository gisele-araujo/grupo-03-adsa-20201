/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import Coletores.ColetaDadosAlert;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author adaias
 */
public class SendAlert {

    protected void sendAlertas() {
        
//        --> Classe para envio e sonda de todos os Alertas necessários
        ColetaDadosAlert alertSend = new ColetaDadosAlert();

        int delay = 3000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                alertSend.cpuAlert();

//                alertSend.memoriaAlert();
//
//                alertSend.discoAlert();

            }
        }, delay, interval);

    }

}
