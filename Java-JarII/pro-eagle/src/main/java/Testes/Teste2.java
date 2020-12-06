/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Coletores.CPU;
import TesteSlack.Erros;
import TesteSlack.SlackMsg;
import TesteSlack.SlackUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author adais
 */
public class Teste2 {

    public static void main(String[] args) {        
        
        Erros exceptions = new Erros();

        if (5 > 2) {

            SlackMsg slackMessage = SlackMsg.builder()
                    .text(String.format("%s", exceptions.ERRO_CPU))
                    .build();
            SlackUtils.sendMessage(slackMessage);

        } else {
            System.out.println("Deu ruim");;

        }
    }

}
