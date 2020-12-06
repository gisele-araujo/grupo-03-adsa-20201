package Testes;

import Coletores.ValidacaoLogin;
import ConexaoBanco.Conexao;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class ArquiteturaLog {

    public static void main(String[] args) throws Exception {
        File file = new File("logger/");
        file.mkdir();

        try {

            FileOutputStream arquivo = new FileOutputStream("logger/arquivo.txt");
            PrintWriter pr = new PrintWriter(arquivo);
            pr.println("Hello! Welcome to the ProEagle");
            pr.println("-----------------------------------");
            pr.println(logInicializacao());
            pr.println("-----------------------------------");
            pr.println(logIConexaoComBd());
            pr.println("-----------------------------------");
            pr.println(logFinalizarBd());
            pr.close();
            arquivo.close();

        } catch (Exception e) {
        }
    }
//      Imports do OSHI 
//    CPU cp = new CPU();
//    Memoria mem = new Memoria();
//    Disco disc = new Disco();

//      Imports de conexão
//      Imports de Data
    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String agora = formatador.format(data);
//      Imports para criação dos arquivos .txt
//      Se atentar ao disco referenciado, se não possuir o disco mostrado na função 
//      abaixo, verifique qual você possui no seu computador
//    FileWriter fw = new FileWriter("aqr.txt");
//    BufferedWriter preencher = new BufferedWriter(fw);
//    PrintWriter print = new PrintWriter(preencher);
    //FileOutputStream arquivo = new FileOutputStream("F:\\ALURA\\proEagle" + agora + ".txt");
    //DataOutputStream gravarArquivo = new DataOutputStream(arquivo);
//      Geração de status de conexão do usuário
//      Aqui você irá chamar a função de quando o usuário fizer login, irá gerar o status no log
//      Será necessário colocar os parentes e estabelecer uma função no "try"  
//      Geração dos dados no .txt
//        try {
//            print.write("Inserindo dados...\n");
//            print.write(String.format("%s  %.1f %% de CPU em uso\n", agora, cp.cpuPorcentagem()));
//            print.write(String.format("%s  %.1f memória em uso\n", agora, mem.memoriaUso()));
//            print.write(String.format("%s  %.0f disco em uso\n", agora, disc.discoUsado()));
//
//        } catch (RuntimeException setDados) {
//            System.out.println("Erro na criação do arquivo, verifique os comandos inseridos");
//        }
//      Geração de status de desconexão do usuário
//      Aqui você irá chamar a função de quando o usuário encerrar a conexão, irá gerar o status no log
//      Será necessário colocar os parentes e estabelecer uma função no "try"  

    public static String logInicializacao() {

        ValidacaoLogin ts = new ValidacaoLogin();
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String agora = formatador.format(data);
        String resposta = " ";

        try {
            if (ts.getStart()) {
                resposta = "Sistema iniciado com sucesso! - " + agora + "\n";
            }

        } catch (Exception e) {
            resposta = "Erro ao iniciar sessão. - " + agora + "\n";
        }
        return resposta;

    }

    public static String logIConexaoComBd() throws Exception{
        
       
        Conexao conct = new Conexao();
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String agora = formatador.format(data);
        String resposta = " ";

        try {
           
                resposta = conct.getAcerto() + " - " + agora + "\n";
            
        } catch (Exception e) {
            resposta = conct.getErro() + " - " + agora + "\n";
        }
        
        return resposta;

    }

    public static String logFinalizarBd() {

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String agora = formatador.format(data);
        String resposta = " ";

        try {
            resposta = "Sessão finalizada. - " + agora + "\n";
        } catch (Exception e) {
            resposta = "Erro ao finalizar a sessão. - " + agora + "\n";
        }
        return resposta;
    }
    
    
//    
//        public void TesteConexao(){
//      ValidacaoLogin vl = new ValidacaoLogin();
//      
//        try {
//            vl.verificaAcessoBD();
//            
//            
//        } catch (Exception e) {
//        }
//    
//    }
//    
}
