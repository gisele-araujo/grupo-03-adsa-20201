package TesteSlack;
import lombok.*;

  import java.io.Serializable;

  @AllArgsConstructor
  @Builder(builderClassName = "Builder")
  @Getter
  @Setter
  public class SlackMsg implements Serializable {
 
    private String text;
    
  }
