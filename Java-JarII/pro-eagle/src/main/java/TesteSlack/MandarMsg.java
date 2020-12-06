package TesteSlack;

import ConexaoBanco.SendAlert;
import java.util.ArrayList;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OperatingSystem;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Memoria;

import TesteSlack.Erros;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class MandarMsg {

    public static void main(String[] args) {

        SystemInfo keyMestra = new SystemInfo();
        CPU cp = new CPU();
        Memoria mem = new Memoria();
        Disco disc = new Disco();
        Erros exceptions = new Erros();
        

        DecimalFormat fmt = new DecimalFormat("0");

        int delay = 3000;   // delay de 5 seg.
        int interval = 20000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                String porcentagem = String.format("%.0f", cp.cpuPorcentagem());
                String transforMemT = String.format("%.1f", mem.memoriaTotal()).replace(",", ".");
                String transforMemU = String.format("%.1f", mem.memoriaUso()).replace(",", ".");
                String transforDisT = fmt.format(disc.discoTotal());
                String transforDisU = fmt.format(disc.discoUsado());

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

                if (mediaCpu > 5) {

                        SlackMsg slackMessage = SlackMsg.builder()
                                .text(String.format("%s", exceptions.ERRO_CPU))
                                .build();
                        SlackUtils.sendMessage(slackMessage);
                        
                        numberCpu.removeAll(numberCpu);
                    }else {
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

                if (mediaMem > sendMemT * 0.9) {

                    
                        SlackMsg slackMessage = SlackMsg.builder()
                                .text(String.format("%s", exceptions.ERRO_MEMORIA))
                                .build();
                        SlackUtils.sendMessage(slackMessage);
                        
                        numberMem.removeAll(numberMem);
                    }else {
                    numberMem.removeAll(numberMem);
                }

                //}
                //public void discoAlert() {
                //       --> captura de alert no Disco
                Integer memLivre = sendDiscT - sendDiscU;

                if (memLivre < (sendDiscT * 0.15)) {

                    
                        SlackMsg slackMessage = SlackMsg.builder()
                                .text(String.format("%s", exceptions))
                                .build();
                        SlackUtils.sendMessage(slackMessage);
                    

                } else if (memLivre < (sendMemT * 0.1)) {

                   
                        SlackMsg slackMessage = SlackMsg.builder()
                                .text(String.format("%s", exceptions))
                                .build();
                        SlackUtils.sendMessage(slackMessage);
                    

                } else if (memLivre < (sendDiscT * 0.05)) {

                    
                        SlackMsg slackMessage = SlackMsg.builder()
                                .text(String.format("%s", exceptions))
                                .build();
                        SlackUtils.sendMessage(slackMessage);
                    

                }
                //}
            }
        }, delay, interval);

    }

}
