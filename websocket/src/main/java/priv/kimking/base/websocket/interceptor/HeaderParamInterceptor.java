//package priv.kimking.base.websocket.interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.messaging.simp.stomp.StompCommand;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.messaging.support.ChannelInterceptorAdapter;
//import org.springframework.messaging.support.MessageHeaderAccessor;
//import priv.kimking.base.websocket.message.SockPrincipal;
//
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * <p> websocket建立链接的时候获取headeri里认证的参数拦截器。
// *
// * @author kim
// * @date 2021/1/29
// */
//public class HeaderParamInterceptor implements ChannelInterceptor {
//    private static final Logger log = LoggerFactory.getLogger(HeaderParamInterceptor.class);
//
//    @Override
//    public Message<?> preSend(Message<?> message, MessageChannel channel) {
//        log.info("preSend发送消息前置处理逻辑");
//        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//            Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
//            if (raw instanceof Map) {
//                Object name = ((Map) raw).get("Authorization");
//                if (name instanceof LinkedList) {
//                    // 设置当前访问的认证用户
//                    accessor.setUser(new SockPrincipal(((LinkedList) name).get(0).toString()));
//                }
//            }
//        }
//        return message;
//    }
//
//}
