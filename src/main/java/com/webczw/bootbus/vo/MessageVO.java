package com.webczw.bootbus.vo;

public class MessageVO {
    private Integer msgId;
    private String msg;

    public MessageVO(String msg) {
        this.msg = msg;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
