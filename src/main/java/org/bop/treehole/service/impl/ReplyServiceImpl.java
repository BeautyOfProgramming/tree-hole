package org.bop.treehole.service.impl;

import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.dao.ReplyDao;
import org.bop.treehole.domain.Reply;
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
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Override
    public Long saveReply(MessageBean message) {

        Reply replyDo = new Reply();
        replyDo.setReplyEmail(message.getReplyEmail());
        replyDo.setMessageId(message.getId());
        return replyDao.saveReply(replyDo);
    }
}
