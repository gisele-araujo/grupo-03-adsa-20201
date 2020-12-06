/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

/**
 *
 * @author adaias
 */
public class DadosInfo {
    
    private String nomeMaquina;
    private String sistemaOperacional;

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    @Override
    public String toString() {
        return String.format("Nome da Maquina: %s \n Sistema Maquina: %s", nomeMaquina, sistemaOperacional);
                //"DadosInfo{" + "nomeMaquina=" + nomeMaquina + ", sistemaOperacional=" + sistemaOperacional + '}';
    }
    
    
    
}
