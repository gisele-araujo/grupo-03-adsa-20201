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

//        --> Captura dos dados para envio
        Formatacao sendFormat = new Formatacao();

        Integer atualizadoCpu = sendFormat.getSendCpu();
        Double atualizadoMemT = sendFormat.getSendMemT();
        Double atualizadoMemU = sendFormat.getSendMemU();
        Integer atualizadoDiscT = sendFormat.getSendDiscT();
        Integer atualizadoDiscU = sendFormat.getSendDiscU();

//        --> Timer para Tarefa
        int delay = 3000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer(); // Instancia do próprio JAVA para "rodar" aplicações num periodo de tempo

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                template.update(insert, 2, 1, atualizadoCpu, atualizadoMemU, atualizadoMemT, atualizadoDiscU, atualizadoDiscT, dataFormatada);
                System.out.println("Inserindo");
            }
        }, delay, interval);
    }
}
