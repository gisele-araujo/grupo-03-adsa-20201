/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

/**
 *
 * @author adais
 */
public class Memoria {
    
    SystemInfo keyMestra = new SystemInfo();
    
//    --> Atributo para acesso a dados no OSHI
    private final GlobalMemory memory;

//    --> inicialização via Construtor
    public Memoria() {
        this.memory = keyMestra.getHardware().getMemory();
    }
    
//    --> Recebemos a memoria RAM (em byts) e convertemos para GB --! recebemos em long e convertemos para double
     public Double memoriaTotal(){
           Long calc = memory.getTotal();
           Double resposta = (double)calc /1024 /1024 /1024;
        return resposta;  
    }
     
     
    public Double memoriaLivre(){
           Long calc = memory.getAvailable();
           Double resposta = (double)calc /1024 /1024/1024 ;
        return resposta;
    }
    
       public Double memoriaUso(){
           Double resposta = memoriaTotal() - memoriaLivre();
        return resposta;
    }
    
    public Double memoriaPorcentagem(){
        Double resposta = memoriaUso() / (memoriaTotal() / 100);
        return resposta;
    }
}
