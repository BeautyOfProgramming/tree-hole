package org.bop.treehole.service;


import org.bop.treehole.bean.MessageBean;
import org.bop.treehole.domain.Message;

import java.util.List;

/**
 * 留言业务逻辑接口类
 *
 * Created by bysocket on 04/05/2017.
 */
public interface MessageService {


    /**
     * 获取留言列表
     *
     * @return
     */
    List<Message> findAllMessage();

    /**
     * 新增留言
     *
     * @param message
     * @return
     */
    Long saveMessage(MessageBean message);
}
