package org.bop.treehole.service.impl;

import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.dao.MessageDao;
import org.bop.treehole.domain.Message;
import org.bop.treehole.service.MessageService;
import org.bop.treehole.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言业务逻辑实现类
 *
 * Created by bysocket on 04/05/2017.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ReplyService replyService;

    @Override
    public List<Message> findAllMessage() {
        return messageDao.findAllMessage();
    }

    @Override
    public Long saveMessage(MessageBean message) {
        Message messageDo = new Message();
        messageDo.setContent(message.getContent());
        messageDo.setReplyNumber(0);
        messageDo.setIsReplied(0);
        messageDao.saveMessage(messageDo);

        // 保存回复
        message.setId(messageDo.getId());
        replyService.saveReply(message);
        return messageDo.getId();
    }

    @Override
    public Message findById(Long messageId) {
        return messageDao.findById(messageId);
    }
}
