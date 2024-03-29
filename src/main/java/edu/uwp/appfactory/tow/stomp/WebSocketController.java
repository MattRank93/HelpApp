//package edu.uwp.appfactory.tow.stomp;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//    private final ObjectMapper mapper;
//    private final SimpMessagingTemplate messageTemplate;
//
//    public WebSocketController(ObjectMapper mapper, SimpMessagingTemplate messageTemplate) {
//        this.mapper = mapper;
//        this.messageTemplate = messageTemplate;
//    }
//
//    public void sendWebSocketUpdate() throws JsonProcessingException {
//        Hello hello = Hello.builder().name("John").message("Hello").build();
//        this.messageTemplate.convertAndSend("/queue",
//                mapper.writeValueAsString(hello));
//    }
//
//    @Data
//    @Builder
//    private static class Hello {
//        String name;
//        String message;
//    }
//}
