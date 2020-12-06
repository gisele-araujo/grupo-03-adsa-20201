/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adais
 */
public class Teste1 {
    
    public void tezNow(){
        
        List<String> testezin = new ArrayList();
        Scanner listen = new Scanner(System.in);
        Scanner listen2 = new Scanner(System.in);
        String okays = "";
        Date hoje = new Date();
        SimpleDateFormat ok = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        testezin.add("Glauber");
        testezin.add("Vanessa");
        testezin.add("Rose");
        testezin.add("Albertinho");
        testezin.add("Lodebelar");
        testezin.add("Bane");
        testezin.add("TonyStark");
        testezin.add("Nomber");
        testezin.add("Crazy");
        testezin.add("ElaSabe");
        
        
        
        System.out.println("Teste de lista");
        System.out.println("");
        System.out.println("Há algo na lista?");
        System.out.println(testezin.isEmpty());
        System.out.println("");
        System.out.println("Qual o tamanho da lista?");
        System.out.println(testezin.size());
        System.out.println("");
        System.out.println("-----------------Procurar algo!-----------------");
        System.out.println("");
        System.out.println("Por favor digite o nome procurado:");
        String compara = listen.nextLine();
        
        System.out.println("");
        
        for (int i = 0; i < testezin.size();i ++) {
            if(compara.equals(testezin.get(i))){
                okays = "Okays Da certo";
                break;
            }else{
                okays = "Deu ruim, ferro!";
            }
        }
        
        System.out.println("-------Temos Resposta---------");
        System.out.println("");
        System.out.println("Sua resposta é:");
        System.out.println(okays);
        
        System.out.println("Como achar a data");
        System.out.println(ok.format(hoje));
        System.out.println("");
        System.out.println("Deseja Excluir a lista?");
        String out = listen2.nextLine();
        
        if(out.equals("yes")){
            testezin.removeAll(testezin);
        }
        
        System.out.println("-----------------------------------------------------------");
        System.out.println(testezin.isEmpty()? "ZERADA" : "AINDA TEM");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
    }
    
}
