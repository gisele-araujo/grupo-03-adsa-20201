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
public class DadosLogin {
  
//    --> classe para formatação das informações necessárias para validação no Login
    
    String email;
    String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return String.format("Email = %s \n Senha = %s", email, senha);
//                email=" + email + ", senha=" + senha + '}';
    }
    
    
    
}
