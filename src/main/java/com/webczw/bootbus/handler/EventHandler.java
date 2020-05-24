package com.webczw.bootbus.handler;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.sun.istack.internal.logging.Logger;
import com.webczw.bootbus.listener.ActivityListener;
import com.webczw.bootbus.listener.EventBusListener;
import com.webczw.bootbus.listener.EventListener;
import com.webczw.bootbus.util.SpringContextUtils;
import com.webczw.bootbus.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class EventHandler {
    Logger log = Logger.getLogger(EventHandler.class);
    @Autowired
    private EventBus eventBus;

    @Autowired
    private AsyncEventBus asyncEventBus;

    @PostConstruct
    public void init() {
        List<Object> listeners = SpringContextUtils.getBeansWithAnnotation(EventBusListener.class);
        for (Object listener : listeners) {
            eventBus.register(listener);
            asyncEventBus.register(listener);
        }
    }

    @PreDestroy
    public void destroy() {
        List<Object> listeners = SpringContextUtils.getBeansWithAnnotation(EventBusListener.class);
        for (Object listener : listeners) {
            eventBus.unregister(listener);
            asyncEventBus.unregister(listener);
        }
    }

    public void eventPost(MessageVO msg) {
        eventBus.post(msg);
        log.info("post event");
    }

    public void asyncEventPost(MessageVO msg) {
        asyncEventBus.post(msg);
        log.info("async post event");
    }
}
