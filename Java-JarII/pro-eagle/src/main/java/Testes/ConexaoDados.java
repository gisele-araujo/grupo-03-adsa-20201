package Testes;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Memoria;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class ConexaoDados {

    public static void main(String[] args) {

//        Instanias --> nossos dados Capturados
        Memoria mem = new Memoria();
        DecimalFormat fmt = new DecimalFormat("0");

        String transforMemT = String.format("%.1f", mem.memoriaTotal()).replace(",", ".");
                //fmt.format(mem.memoriaTotal());
        String transforMemU = String.format("%.1f", mem.memoriaUso()).replace(",", ".");
                //fmt.format(mem.memoriaUso());

        Double atualizadoMemT = Double.parseDouble(transforMemT);
        Double atualizadoMemU = Double.parseDouble(transforMemU);

        int delay = 3000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // colocar tarefas aqui ...
                System.out.println("--------------------- E LÁ VAMOS NÓS----------------------------");
                System.out.println(atualizadoMemT);
                System.out.println("");
                System.out.println(atualizadoMemU);
            }
        }, delay, interval);
    }

}
