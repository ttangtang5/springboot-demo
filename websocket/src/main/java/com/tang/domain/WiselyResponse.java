package com.tang.domain;

/**
 * @Description
 * @Author RLY
 * @Date 2018/12/14 15:30
 * @Version 1.0
 **/
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage(){
        return responseMessage;
    }
}
