/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteSlack;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Memoria;
import oshi.SystemInfo;

import Coletores.CPU;
import Coletores.Disco;
import Coletores.Memoria;

import java.util.ArrayList;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author pc
 */
public class Erros {

    SystemInfo keyMestra = new SystemInfo();
    CPU cp = new CPU();
    Memoria mem = new Memoria();
    Disco disc = new Disco();

    public String ERRO_CPU = " Ola! Alguma de suas maquinas esta "
            + "apresentando problemas no processamento, verifique a sua Dashboard!";

    public String ERRO_MEMORIA = " Ola! Sua Memoria esta "
            + "apresentando problemas no processamento, verifique a sua Dashboard!";

    public String ALERTA_DISCO_15_PORCENTO = "Ola! seu Disco esta "
            + "sendo bem utilizado, voce tem 15% da capacidade livre agora. Fique atento!";
    
    public String ALERTA_DISCO_10_PORCENTO = " Ola! seu Disco esta "
            + " somente 10% da capacidade livre, isso atrapalha no seu desempenho. Tente fazer um Backup ou realizar a "
            + "manutenção do seu disco atual! ";
    
    public String ALERTA_DISCO_5_PORCENTO = " Ola! seu Disco esta "
            + " em 5%, voce precisa troca-lo urgentemente para evitar problemas";

}
