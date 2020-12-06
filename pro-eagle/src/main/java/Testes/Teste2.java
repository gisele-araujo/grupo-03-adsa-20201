/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Memoria;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author adais
 */
public class Teste2 {
    
public void runNow(){
        Disco disc = new Disco();
        Memoria mem = new Memoria();
        CPU info = new CPU();
        
              int delay = 3000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

      timer.scheduleAtFixedRate(new TimerTask() {
          public void run() {
                System.out.println(info.cpuPorcentagem());
                System.out.println("Inserindo");
            }
       }, delay,interval); 
//       
}
}
     


    

