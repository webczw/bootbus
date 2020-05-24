package com.webczw.bootbus.controller;

import com.sun.istack.internal.logging.Logger;
import com.webczw.bootbus.handler.EventHandler;
import com.webczw.bootbus.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class PublishController {
    private static Logger LOG = Logger.getLogger(PublishController.class);

    @Autowired
    private EventHandler eventHandler;

    @GetMapping("/publish")
    public void publishEvent() {
        LOG.info("this publish method...");
        eventHandler.eventPost(new MessageVO("芝麻开门！"));
    }

    @GetMapping("/async/publish")
    public void publishAsyncEvent() {
        LOG.info("this async publish method...");
        eventHandler.asyncEventPost(new MessageVO("芝麻开门！"));
    }
}
