package TesteSlack;
import ConexaoBanco.Conexao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SlackUtils {
    
        Conexao connecta = new Conexao();
        JdbcTemplate template = new JdbcTemplate(connecta.getConectaBanco());
        
        List<DadosSlack> listaDadosSlack = template.query("SELECT nome,webhook FROM empresa",
                new BeanPropertyRowMapper());
                
        
          static String urlWebhook;              
          String empresa1 = "escoar-frutas";
        
          public void recuperarURL(){
                      for(int i = 0; i < listaDadosSlack.size(); i++){
                          if(listaDadosSlack.get(i).getNome().equals(empresa1)){
                              this.urlWebhook = listaDadosSlack.get(i).getWebhook();
                          }
                      }
          }
    
    
//private static String slackWebhookUrl = "https://hooks.slack.com/services/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";
          //https://hooks.slack.com/services/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
          //https://hooks.slack.com/services/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

    private static String slackWebhookUrl = "https://hooks.slack.com/services/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" ;

    
      public static void sendMessage(SlackMsg message) {
          CloseableHttpClient client = HttpClients.createDefault();
          HttpPost httpPost = new HttpPost(slackWebhookUrl);

          try {
              ObjectMapper objectMapper = new ObjectMapper();
              String json = objectMapper.writeValueAsString(message);

              StringEntity entity = new StringEntity(json);
              httpPost.setEntity(entity);
              httpPost.setHeader("Accept", "application/json");
              httpPost.setHeader("Content-type", "application/json");

              client.execute(httpPost);
              client.close();
          } catch (IOException e) {
             e.printStackTrace();
          }
      }
}
