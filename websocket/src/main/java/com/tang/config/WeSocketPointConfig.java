package com.tang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Description 点对点式：即消息由谁发送、由谁接收
 * @Author RLY
 * @Date 2018/12/21 16:32
 * @Version 1.0
 **/
@Configuration
@EnableWebSocketMessageBroker
public class WeSocketPointConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/endpointWisely").withSockJS();
        //注册一个名为endpointChat的endpoint
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //点对点式应增加一个queue消息代理
        registry.enableSimpleBroker("queue","/topic");
    }

}
