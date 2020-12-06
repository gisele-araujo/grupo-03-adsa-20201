/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import ConexaoBanco.SendAlert;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adaias
 */
public class ColetaDadosAlert {

    CPU infoCpu = new CPU();
    Disco disc = new Disco();
    Memoria mem = new Memoria();

    Formatacao sendFormat = new Formatacao();

    SendAlert key = new SendAlert();

    public void cpuAlert() {

        //        --> captura de alert para CPU
        List<Integer> numberCpu = new ArrayList<>();
        Integer mediaCpu = 0;
        Integer armazenarDados = 0;

        while (numberCpu.size() < 5) {
            numberCpu.add(sendFormat.sendCpu);
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

    }

    public void memoriaAlert() {

        //        --> captura de alert na Memoria
        List<Double> numberMem = new ArrayList<>();

        Double mediaMem = 0.0;
        Double armazenaMem = 0.0;

        while (numberMem.size() < 5) {
            numberMem.add(sendFormat.sendMemU);
        }

        for (Double d : numberMem) {
            armazenaMem += d.doubleValue();
            mediaMem = armazenaMem / numberMem.size();
        }

        if (mediaMem > sendFormat.getSendMemT() * 0.05) {

//             add. Alert
            numberMem.removeAll(numberMem);
        } else {
            numberMem.removeAll(numberMem);
        }

    }

    public void discoAlert() {

        //       --> captura de alert no Disco
        Integer memLivre = sendFormat.getSendDiscT() - sendFormat.getSendDiscU();

        if (memLivre < (sendFormat.getSendDiscT() * 0.15)) {

//             add. Alert
        } else if (memLivre < (sendFormat.getSendMemT() * 0.1)) {

//             add. Alert
        } else if (memLivre < (sendFormat.getSendDiscT() * 0.05)) {

//             add. Alert
        }
    }

}
