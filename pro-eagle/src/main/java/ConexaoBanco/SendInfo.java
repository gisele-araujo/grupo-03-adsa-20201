/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author adaias
 */
public class SendInfo {
    
    protected void sendInformacoes(){
        
//        --> Atributos para coletar dados do OSHI
        SystemInfo key = new SystemInfo();
        HardwareAbstractionLayer hard = key.getHardware();
        OperatingSystem os = key.getOperatingSystem();
        
//        --> Conexão com o BD
        Conexao connecta = new Conexao();
        JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());

//    --> enviando dados de Máquina
        String nomeMaquina = os.getNetworkParams().getHostName();
        String sistemaOperacional = String.valueOf(os);
        String insertMaquina = "INSERT INTO Maquina VALUES (?,?,?)";

        template.update(insertMaquina, nomeMaquina, sistemaOperacional, 1);

//    --> enviando dados dos componentes
        String compoCpu = hard.getProcessor().getProcessorIdentifier().getName();
        String compoMem = String.format("%s - %s", hard.getMemory().getPhysicalMemory().get(1).getManufacturer(), hard.getMemory().getPhysicalMemory().get(1).getMemoryType());
        String compoDisc = os.getFileSystem().getFileStores().get(0).getName();
        String insertComponentes = "INSERT INTO componentes VALUES (?,?,?)";

        template.update(insertComponentes, compoCpu, compoMem, compoDisc);
        
    }
}
