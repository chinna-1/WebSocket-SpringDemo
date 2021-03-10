package webSocketService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import webSocketService.Handler1;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        webSocketHandlerRegistry.addHandler(webSocketHandler(),"/TestWebSocket").setAllowedOrigins("*");
        // 不使用 setAllowedOrigins 方法，服务端将不会接收跨域请求
        //webSocketHandlerRegistry.addHandler(webSocketHandler(),"/testHandler");
    }

    @Bean
    public TextWebSocketHandler webSocketHandler() {
        return new Handler1();
    }
}
