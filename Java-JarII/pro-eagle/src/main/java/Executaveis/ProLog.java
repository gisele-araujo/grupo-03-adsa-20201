package Executaveis;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProLog  {

        private List<String> logs = new ArrayList();

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }

    public List<String> getLogs() {
        return logs;
    }
    
    public void logFunfa()throws IOException{
        
    
        
        Date data = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");

        Date agora = new Date();

        DateFormat f24h = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        FileWriter fw = new FileWriter("Teste.txt");
        fw.write(f24h.format(agora));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
