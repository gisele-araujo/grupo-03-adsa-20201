/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConecxaoDoker;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Formatacao;
import Coletores.Memoria;
import ConexaoBanco.Conexao;
import Executaveis.ProLog;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class SendDadosDocker {

    public static void main(String[] args) {

        
        ProLog log = new ProLog();
        
        //        --> Conexão com BD
        ConexaoDocker connect = new ConexaoDocker();
        JdbcTemplate template = new JdbcTemplate(connect.getConectaBanco());
// ------------------------------------------------------------------------------------------------------------------------   
        //        --> Atributos para coletar dados do OSHI
        SystemInfo key = new SystemInfo();
        HardwareAbstractionLayer hard = key.getHardware();
        OperatingSystem os = key.getOperatingSystem();

//    --> enviando dados de Máquina
        String nomeMaquina = os.getNetworkParams().getHostName();
        String sistemaOperacional = String.valueOf(os);
        String insertMaquina = "INSERT INTO Maquina VALUES (null,?,?,?)";

        template.update(insertMaquina, nomeMaquina, sistemaOperacional, 1);

//    --> enviando dados dos componentes
        String compoCpu = hard.getProcessor().getProcessorIdentifier().getName();
//        String compoMem = String.format("%s - %s", hard.getMemory().getPhysicalMemory().get(0).getManufacturer(), hard.getMemory().getPhysicalMemory().get(1).getMemoryType());
        String compoDisc = os.getFileSystem().getFileStores().get(0).getName();
        String insertComponentes = "INSERT INTO Componentes VALUES (null,?,null,?)";

        template.update(insertComponentes, compoCpu, compoDisc);

//--------------------------------------------------------------------------------------------------------------------------
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
        String insert = "INSERT INTO DadosGerados VALUES (null,?,?,?,?,?,?,?,?)";

//        --> Captura dos dados para envio
        Formatacao sendFormat = new Formatacao();

       
//        --> Timer para Tarefa
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
                
                template.update(insert, 2, 1,sendCpu, sendMemU, sendMemT, sendDiscU, sendDiscT, dataFormatada);
                
                System.out.println("Inserindo");
            }
            
        }, delay, interval);
    }
}
