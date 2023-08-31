package com.joker.dorabey.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.Principal;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    public String processMessageFromClient(@Payload String message) throws Exception {
        System.out.println(message);
        return message;
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

    @MessageMapping("/image")
    @SendToUser("/queue/stream")
    public void test(Principal principal) {
        BufferedImage img = null;
        byte[] bytes = null;
        try {
            img = ImageIO.read(new File("/Users/cl10076-m/Pictures/avator.jpeg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpeg", baos);
            bytes = baos.toByteArray();
        } catch (IOException e) {
        }
//        messagingTemplate.convertAndSend("/topic/stream", "hello");
//        messagingTemplate.convertAndSend("/topic/stream", new BinaryMessage(bytes));
        messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/stream", new BinaryMessage(bytes));
    }


}
