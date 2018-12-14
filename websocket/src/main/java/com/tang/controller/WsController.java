package com.tang.controller;

import com.tang.domain.WiselyMessage;
import com.tang.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Description 1、当浏览器向服务端发送请求时，通过@MessageMapping映射/hello这个地址，类似@requestMapping
 * 2、当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
 *
 * @Author RLY
 * @Date 2018/12/14 15:34
 * @Version 1.0
 **/
@Controller
public class WsController {

    @MessageMapping("/hello")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("hello " + message.getName() + "!");
    }
}
