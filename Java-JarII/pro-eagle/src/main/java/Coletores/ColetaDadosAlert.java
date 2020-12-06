/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import ConexaoBanco.SendAlert;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author adaias
 */
public class ColetaDadosAlert {

    CPU infoCpu = new CPU();
    Disco disc = new Disco();
    Memoria mem = new Memoria();

    SendAlert key = new SendAlert();

    public void cpuAlert() {

        Disco disk = new Disco();
        CPU infoCpu = new CPU();
        Memoria mem = new Memoria();
        DecimalFormat fmt = new DecimalFormat("0");

        int delay = 3000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                String porcentagem = String.format("%.0f", infoCpu.cpuPorcentagem());
                String transforMemT = String.format("%.1f", mem.memoriaTotal()).replace(",", ".");
                String transforMemU = String.format("%.1f", mem.memoriaUso()).replace(",", ".");
                String transforDisT = fmt.format(disk.discoTotal());
                String transforDisU = fmt.format(disk.discoUsado());

                Integer sendCpu = Integer.parseInt(porcentagem);
                Double sendMemT = Double.parseDouble(transforMemT);
                Double sendMemU = Double.parseDouble(transforMemU);
                Integer sendDiscT = Integer.parseInt(transforDisT);
                Integer sendDiscU = Integer.parseInt(transforDisU);
                
                
                 //        --> captura de alert para CPU
        List<Integer> numberCpu = new ArrayList<>();
        Integer mediaCpu = 0;
        Integer armazenarDados = 0;

        while (numberCpu.size() < 5) {
            numberCpu.add(sendCpu);
        }

        for (Integer n : numberCpu) {
            armazenarDados += n.intValue();
            mediaCpu = armazenarDados / numberCpu.size();
        }

        if (mediaCpu > 90) {

//            add. Alert
            numberCpu.removeAll(numberCpu);

        } else {
            numberCpu.removeAll(numberCpu);
        }

   // public void memoriaAlert() {

        //        --> captura de alert na Memoria
        List<Double> numberMem = new ArrayList<>();

        Double mediaMem = 0.0;
        Double armazenaMem = 0.0;

        while (numberMem.size() < 5) {
            numberMem.add(sendMemU);
        }

        for (Double d : numberMem) {
            armazenaMem += d.doubleValue();
            mediaMem = armazenaMem / numberMem.size();
        }

        if (mediaMem > sendMemT * 0.05) {

//             add. Alert
            numberMem.removeAll(numberMem);
        } else {
            numberMem.removeAll(numberMem);
        }

    //}

    //public void discoAlert() {

        //       --> captura de alert no Disco
        Integer memLivre = sendDiscT - sendDiscU;

        if (memLivre < (sendDiscT * 0.15)) {

//             add. Alert
        } else if (memLivre < (sendMemT * 0.1)) {

//             add. Alert
        } else if (memLivre < (sendDiscT * 0.05)) {

//             add. Alert
        }
    //}
           }
        }, delay, interval);
       

}
}
