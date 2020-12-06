/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coletores;

import com.google.protobuf.Internal;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author adais
 */
public class CPU {

    //Criação das instâncias
    SystemInfo keyMestra = new SystemInfo();
    OperatingSystem os = keyMestra.getOperatingSystem();
    
//   --> criando atributos para coletar informações do OSHI ( no caso os processos)
    private final CentralProcessor cp;
    private long[] tickts; //keyMestra.getHardware().getProcessor().getSystemCpuLoadTicks();

//    --> Incialização dos atributos via Construtor
    public CPU() {
        this.cp = keyMestra.getHardware().getProcessor();
        this.tickts = new long[TickType.values().length];
    }

//    --> pegamos a frequencia máxima da Máquina (esta sendo convertida para GigaHertzs
    public Double freqMax() {
        return Formatacao.toGigah(cp.getMaxFreq());
        // lista.add();
    }
    
//    --> pegamos em (porcentagem) o uso da CPU
    public double cpuPorcentagem() {
        double por = cp.getSystemCpuLoadBetweenTicks(tickts);
        tickts = cp.getSystemCpuLoadTicks();
        return por * 100.000;
    }
   
}
