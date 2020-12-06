/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Formatacao;
import Coletores.Memoria;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

public class SendDados {

    protected void sendDadosBD() {

//        --> Conexão com BD
        Conexao connecta = new Conexao();
        JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());
// ------------------------------------------------------------------------------------------------------------------------   

//        --> instancias de nossos coletores de dados  
        Disco disk = new Disco();
        CPU infoCpu = new CPU();
        Memoria mem = new Memoria();
        DecimalFormat fmt = new DecimalFormat("0");

//        --> Captura da data atual
        // função que retorna data e hora atual no formato aaaa-mm-dd HH:mm:ss
        DateTimeFormatter formaObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime data = LocalDateTime.now();
        String dataFormatada = formaObj.format(data);

//    --> enviando dados de CPU, Memória, Disco
        String insert = "INSERT INTO dadosgerados VALUES (?,?,?,?,?,?,?,?)";


//        --> Timer para Tarefa
        int delay = 3000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                
//        --> Captura dos dados para envio
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

                template.update(insert, 2, 1, sendCpu, sendMemU, sendMemT, sendDiscU, sendDiscT, dataFormatada);
                System.out.println("Inserindo");
                //System.out.println(sendCpu + "%");
            }
        }, delay, interval);
    }
}
