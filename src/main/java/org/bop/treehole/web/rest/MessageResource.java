package org.bop.treehole.web.rest;

import org.bop.treehole.web.dto.MessageBean;
import org.bop.treehole.domain.Message;
import org.bop.treehole.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public Long createMessage(@Valid @RequestBody MessageBean message, BindingResult result) {
        if (result.hasErrors()) {
            // TODO Give frontend friend message, use @ControllerAdvice
            throw new IllegalArgumentException("");
        } else {
            return messageService.saveMessage(message);
        }
    }

}
