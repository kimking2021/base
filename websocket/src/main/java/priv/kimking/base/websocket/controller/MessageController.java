package priv.kimking.base.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import priv.kimking.base.websocket.interceptor.ContextHolder;
import priv.kimking.base.websocket.message.MessageBody;
import priv.kimking.base.websocket.message.SockPrincipal;

import java.security.Principal;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/20
 */
@Controller(value = "/web")
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    /** 消息发送工具对象 */
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    /** 广播发送消息，将消息发送到指定的目标地址 */
    @MessageMapping("/foo")
    public void sendTopicMessage(MessageBody messageBody, SockPrincipal principal) {
        // 将消息发送到 WebSocket 配置类中配置的代理中（/topic）进行消息转发
//        simpMessageSendingOperations.convertAndSend(messageBody.getDestination(), messageBody);
//        System.out.println(auth);
        log.info("principal: {}", principal);
        log.info("foo 收到消息： {}", messageBody);
    }

}
