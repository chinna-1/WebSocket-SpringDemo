package sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("webSocketService")
public class WebSocketApplication {
    public static void main(String[] args){
        SpringApplication.run(WebSocketApplication.class,args);
    }
}
