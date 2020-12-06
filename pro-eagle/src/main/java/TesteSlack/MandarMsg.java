package TesteSlack;

public class MandarMsg {
        public static void main(String[] args) {
            if (5 > 2) {
            SlackMsg slackMessage = SlackMsg.builder()
            .text("Hoje foi legal")
            .build();
            SlackUtils.sendMessage(slackMessage);
        }
            
            //https://hooks.slack.com/services/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
        
    }
}

