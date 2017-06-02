package org.bop.treehole.controller;

import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.domain.Message;
import org.bop.treehole.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageRestController {

    private final MessageService messageService;

    @Autowired
    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 获取留言列表
     *
     */
    @RequestMapping(value = "/message/list", method = RequestMethod.GET)
    public List<Message> findAllMessage() {
        return messageService.findAllMessage();
    }

    /**
     * 去留言
     *
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Long createMessage(@RequestBody MessageBean message) {
        return messageService.saveMessage(message);
    }

}
