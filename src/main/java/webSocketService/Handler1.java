package webSocketService;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class Handler1 extends TextWebSocketHandler {
    // js 调用 websocket.onopen时 ，服务端即会调用该方法，建立连接
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("服务器建立连接 .........");
    }

    // js 调用 websocket.send 发送消息时，服务端即会调用该方法，处理客户端的消息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        System.out.println("服务器收到消息：" + message.getPayload());
        // 发送消息给客户端
        session.sendMessage(new TextMessage("Hello,client,我在服务端向你问好"));
    }

    // js 调用 websocket.close时, 服务端即会调用该方法，关闭当前客户端的连接
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("服务器关闭连接");
    }
}



