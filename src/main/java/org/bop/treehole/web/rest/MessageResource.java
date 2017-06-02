package org.bop.treehole.web.rest;

import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.domain.Message;
import org.bop.treehole.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageResource {

    private final MessageService messageService;

    @Autowired
    public MessageResource(MessageService messageService) {
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
