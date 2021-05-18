package priv.kimking.base.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import priv.kimking.base.websocket.handler.PrincipalHandshakeHandler;
import priv.kimking.base.websocket.interceptor.AuthHandshakeInterceptor;
//import priv.kimking.base.websocket.interceptor.HeaderParamInterceptor;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/20
 */
@Configuration(proxyBeanMethods = false)
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

//    private GetHeaderParamInterceptor getHeaderParamInterceptor;

    @Bean
    public PrincipalHandshakeHandler principalHandshakeHandler() {
        return new PrincipalHandshakeHandler();
    }

    @Bean
    public AuthHandshakeInterceptor authHandshakeInterceptor() {
        return new AuthHandshakeInterceptor();
    }

    /**
     * 配置 WebSocket 进入点，及开启使用 SockJS，这些配置主要用配置连接端点，用于 WebSocket 连接
     *
     * @param registry STOMP 端点
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint")
                .setAllowedOrigins("*")
                .setHandshakeHandler(principalHandshakeHandler())
                .withSockJS()
                .setInterceptors(authHandshakeInterceptor());
    }

    /**
     * 配置消息代理选项
     *
     * @param registry 消息代理注册配置
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置一个或者多个代理前缀，在 Controller 类中的方法里面发生的消息，会首先转发到代理从而发送到对应广播或者队列中。
        registry.enableSimpleBroker("/topic");
        // 配置客户端发送请求消息的一个或多个前缀，该前缀会筛选消息目标转发到 Controller 类中注解对应的方法里
        registry.setApplicationDestinationPrefixes("/app", "/web", "/phone");
    }

//    /**
//     * 采用自定义拦截器，获取connect时候传递的参数
//     */
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(headerParamInterceptor());
//    }
//
//    @Bean
//    public HeaderParamInterceptor headerParamInterceptor() {
//        return new HeaderParamInterceptor();
//    }
}
