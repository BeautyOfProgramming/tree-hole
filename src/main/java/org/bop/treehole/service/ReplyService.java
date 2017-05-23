package org.bop.treehole.service;


import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.domain.Message;
import org.bop.treehole.domain.Reply;

import java.util.List;

/**
 * 回复业务逻辑接口类
 *
 * Created by bysocket on 04/05/2017.
 */
public interface ReplyService {


    /**
     * 新增回复
     *
     * @param message
     * @return
     */
    Long saveReply(MessageBean message);

    /**
     * 获取待回复列表
     *
     * @return
     */
    String findAllTemplateReply();
}
