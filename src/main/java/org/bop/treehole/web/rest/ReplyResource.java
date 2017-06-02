package org.bop.treehole.web.rest;

import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyResource {

    private final ReplyService replyService;

    @Autowired
    public ReplyResource(ReplyService replyService) {
        this.replyService = replyService;
    }

    /**
     * 新增回复
     *
     */
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public Long createReply(@RequestBody MessageBean message) {
        return replyService.saveReply(message);
    }

    /**
     * 获取待回复列表
     *
     */
    @RequestMapping(value = "/reply/template/list", method = RequestMethod.GET)
    public String findAllTemplateReply() {
        return replyService.findAllTemplateReply();
    }
}
