/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import oshi.SystemInfo;
import oshi.software.os.FileSystem;

/**
 *
 * @author adais
 */
public class Disco {

    SystemInfo keyMestra = new SystemInfo();

//    --> atributos para dados do OSHI
    private final FileSystem fileSystem;
    //public List<String> disco = new ArrayList();

//    --> inicialização dos atributos via Construtor
    public Disco() {
        this.fileSystem = keyMestra.getOperatingSystem().getFileSystem();
    }

//    --> pegamos o nome do disco Principal que o Usuario está Usando 
    public String discoNome() {
        String resposta = fileSystem.getFileStores().get(0).getName();
        return resposta;

    }
    
//    --> pegamos o espaço total do disco principal (em byts), convertemos em GB --! estamos convertendo long em double 
    public Double discoTotal() {

        long calc = fileSystem.getFileStores().get(0).getTotalSpace();
        Double resposta = (double) calc / 1024 / 1024 / 1024;
        return resposta;
    }

    public Double discoLivre() {

        long calc = fileSystem.getFileStores().get(0).getFreeSpace();
        Double resposta = (double) calc / 1024 / 1024 / 1024;
        return resposta;
    }

    public Double discoUsado() {

        Double resposta = discoTotal() - discoLivre();
        return resposta;
    }

    public Double discoPorcentagem() {
        Double resposta = discoUsado() / (discoTotal() / 100);
        return resposta;
    }

}
