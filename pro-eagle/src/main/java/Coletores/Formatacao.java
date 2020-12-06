/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import oshi.SystemInfo;

/**
 *
 * @author adais
 */
public class Formatacao {

    SystemInfo si = new SystemInfo();

//    --> Formatação de dados da cpu, memoria e disco
    Disco disk = new Disco();
    CPU infoCpu = new CPU();
    Memoria mem = new Memoria();
    Date dateTime = new Date();
    DecimalFormat fmt = new DecimalFormat("0");

    String porcentagem = fmt.format(infoCpu.cpuPorcentagem());
    String transforMemT = String.format("%.1f", mem.memoriaTotal()).replace(",", ".");
    String transforMemU = String.format("%.1f", mem.memoriaUso()).replace(",", ".");
    String transforDisT = fmt.format(disk.discoTotal());
    String transforDisU = fmt.format(disk.discoUsado());

    Integer sendCpu = Integer.parseInt(porcentagem);
    Double sendMemT = Double.parseDouble(transforMemT);
    Double sendMemU = Double.parseDouble(transforMemU);
    Integer sendDiscT = Integer.parseInt(transforDisT);
    Integer sendDiscU = Integer.parseInt(transforDisU);

    public Integer getSendCpu() {
        return sendCpu;
    }

    public Double getSendMemT() {
        return sendMemT;
    }

    public Double getSendMemU() {
        return sendMemU;
    }

    public Integer getSendDiscT() {
        return sendDiscT;
    }

    public Integer getSendDiscU() {
        return sendDiscU;
    }

//   --> formaatação de Byts      
    // public static Double toGigab(Long bytes){
    //   return bytes / Math.pow(10, 9);
    // }
    
//    --> formatação de GB
    public static Double toGigah(Long hertz) {
        return hertz / Math.pow(10, 9);
    }

//    --> formatação de uso de máquina
    public static String formatElapsedSecs(long secs) {
        long eTime = secs;
        final long days = TimeUnit.SECONDS.toDays(eTime);
        eTime -= TimeUnit.DAYS.toSeconds(days);
        final long hr = TimeUnit.SECONDS.toHours(eTime);
        eTime -= TimeUnit.HOURS.toSeconds(hr);
        final long min = TimeUnit.SECONDS.toMinutes(eTime);
        eTime -= TimeUnit.MINUTES.toSeconds(min);
        final long sec = eTime;
        return String.format("%d dias, %02d:%02d:%02d", days, hr, min, sec);

    }

//        --> Função para executar algo num intervalo pré determinado de tempo
    
    
//        public void timerNow(){
//            //        --> Timer para Tarefa
//        int delay = 3000;   // delay de 5 seg.
//        int interval = 5000;  // intervalo de 1 seg.
//        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo
//
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//
//                
//            }
//        }, delay, interval);
//        }
}
