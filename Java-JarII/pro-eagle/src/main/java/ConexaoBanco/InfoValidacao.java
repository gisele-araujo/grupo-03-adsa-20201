/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author adaias
 */
public class InfoValidacao {
   
//    --> conexão com o BD
    Conexao connecta = new Conexao();
    JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());

//    --> informações
    SystemInfo key = new SystemInfo();
    OperatingSystem os = key.getOperatingSystem();

//    --> Atributos para Coletas
    private final String nomeMaquina = os.getNetworkParams().getHostName();
    private final String sistemaOperacional = String.valueOf(os);

//    --> método para comparação
    public Boolean infoValidado() {
        
//        --> Lista do tipo dadosInfo --! Faz selct no banco e loga após compara , se já existir retorna um boolean
        List<DadosInfo> listaInfo = template.query("SELECT nomeMaquina,sistemaOperacional FROM Maquina WHERE nomeMaquina= ? AND SistemaOperacional= ?",
                new BeanPropertyRowMapper(DadosLogin.class),
                nomeMaquina, sistemaOperacional);

        return this.nomeMaquina.equals(nomeMaquina) && this.sistemaOperacional.equals(sistemaOperacional);
    }
}
