//package tech.ineb.adp.api.binance.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.simp.stomp.StompCommand;
//import org.springframework.messaging.simp.stomp.StompHeaders;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.messaging.simp.stomp.StompSessionHandler;
//import org.springframework.web.socket.client.WebSocketClient;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//
//import java.lang.reflect.Type;
//import java.util.Scanner;
//
//@Configuration @Slf4j
//public class WsClientConfig {
//  public WebSocketClient client() {
//    WebSocketClient client = new StandardWebSocketClient();
//
//    WebSocketStompClient stompClient = new WebSocketStompClient(client);
//    stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//
//    StompSessionHandler sessionHandler = null;
//
//    stompClient.connect(URL, sessionHandler);
//
//    new Scanner(System.in).nextLine(); // Don't close immediately.
//  }
//
//}
