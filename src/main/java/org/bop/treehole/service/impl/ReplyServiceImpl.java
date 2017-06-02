package org.bop.treehole.service.impl;

import org.bop.treehole.web.dto.MessageBean;
import org.bop.treehole.constant.TemplateReply;
import org.bop.treehole.dao.MessageDao;
import org.bop.treehole.dao.ReplyDao;
import org.bop.treehole.domain.Message;
import org.bop.treehole.domain.Reply;
import org.bop.treehole.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 回复业务逻辑实现类
 *
 * Created by bysocket on 04/05/2017.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyDao replyDao;

    private final MessageDao messageDao;

    @Autowired
    public ReplyServiceImpl(ReplyDao replyDao, MessageDao messageDao) {
        this.replyDao = replyDao;
        this.messageDao = messageDao;
    }

    @Override
    public Long saveReply(MessageBean message) {

        Reply replyDo = new Reply();
        replyDo.setReplyEmail(message.getReplyEmail());
        replyDo.setMessageId(message.getId());
        return replyDao.saveReply(replyDo);
    }

    @Override
    public String findAllTemplateReply() {

        // 获取待回复的留言列表
        List<Long> messageIds = replyDao.findToReplyMessageIds();

        if (CollectionUtils.isEmpty(messageIds)) {
            return null;
        }

        StringBuilder messageTemplateList = new StringBuilder();

        // 循环获取留言回复列表
        messageIds.forEach( messageId -> {
            Message message = messageDao.findById(messageId);
            // 待回复邮箱列表
            StringBuilder emailList = new StringBuilder();
            List<Reply> replyList = replyDao.findToReplyByMessageId(messageId);
            replyList.forEach(reply -> emailList.append("  ").append(reply.getReplyEmail()));
            // 模板化
            String messageTemplate = String.format(TemplateReply.TEMPLATE,
                    String.valueOf(message.getId()),
                    emailList,
                    message.getContent(),
                    message.getReplyContent());
            messageTemplateList.append(messageTemplate);
        });

        return messageTemplateList.toString();
    }
}
