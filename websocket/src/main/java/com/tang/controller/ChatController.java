package com.tang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @Description
 * 1、通过SimpMessagingTemplate向浏览器发送消息
 * 2、在spring mvc中，可以直接在参数中获取principal，principal中包含当前的用户信息
 * 3、这里是一段硬编码，如果发送人是tang，则发送给zf；如果发送人是zf,则发送给tang，之后可根据实际需求改写此处代码
 * 4、通过messagingTemplate.convertAndSendToUser向用户发送消息，第一个参数是接收消息的用户，第二个是浏览器订阅的地址，第三个是消息本身
 * @Author RLY
 * @Date 2018/12/21 16:41
 * @Version 1.0
 **/
@Controller
//此处加上存在消息发送失败
//@RequestMapping("/web")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/handleChat")
    public void handleChat(Principal principal, String msg){
        if(principal.getName().equals("tang")){
            messagingTemplate.convertAndSendToUser("zf", "/queue/notifications", principal.getName() + "-send:" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("tang", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }
}
