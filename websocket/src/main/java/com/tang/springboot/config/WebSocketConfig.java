package com.tang.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Description 广播式：即服务端有消息时，会将消息发送给所有连接了当前endpoint的浏览器。
 *  1、EnableWebSocketMessageBroker注解开启使用stomp协议来传输基于代理（message broker）的消息，这时控制器支持使用@MessageMapping 等同@requestMapping
 *  2、注册stomp协议的节点（endpoint),并映射的指定Url
 *  3、注册一个stomp的endpoint，并指定使用sockjs协议
 *  4、配置消息代理（Message Broker）
 *  5、广播式应配置一个/topic消息代理
 *
 * @Author RLY
 * @Date 2018/12/14 15:16
 * @Version 1.0
 **/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/endpointWisely").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
