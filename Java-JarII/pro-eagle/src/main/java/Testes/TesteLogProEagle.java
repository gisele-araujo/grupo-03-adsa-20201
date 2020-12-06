/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Coletores.ValidacaoLogin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class TesteLogProEagle {

    static List<String> listaLog;

    public TesteLogProEagle() {
        //ArquiteturaLog.listaLog = new ArrayList<>();
    }

    public List<String> getListaLog() {
        return listaLog;
    }

    public void setListaLog(List<String> listaLog) {
        //ArquiteturaLog.listaLog = listaLog;
    }
      
    

      
     
    public static void main(String[] args) throws Exception {
        File file = new File("logger/");
        file.mkdir();
       
        try {

            FileOutputStream arquivo = new FileOutputStream("logger/arquivo.txt");
            PrintWriter pr = new PrintWriter(arquivo);
            pr.println(listaLog.toString());
            pr.close();
            arquivo.close();

        } catch (Exception e) {
        }
    }
    
}
