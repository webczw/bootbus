package com.webczw.bootbus.listener;

import com.google.common.eventbus.Subscribe;
import com.sun.istack.internal.logging.Logger;
import com.webczw.bootbus.vo.MessageVO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@EventBusListener
@Order(0)
public class ActivityListener {
    Logger log = Logger.getLogger(EventListener.class);

    @Subscribe
    public void onMessageEvent(MessageVO msg) {
        log.info("Activity message:" + msg.getMsg());
    }
}
