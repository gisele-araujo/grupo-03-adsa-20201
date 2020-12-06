/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteSlack;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pc
 */

@Getter
@Setter
public class DadosSlack {
    
    String nome;
    String webhook;

    @Override
    public String toString() {
        return "DadosSlack{" + "empresa=" + nome + ", webhook=" + webhook + '}';
    }
    
    
    
}
