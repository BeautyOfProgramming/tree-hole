package org.bop.treehole.dao;


import org.apache.ibatis.annotations.Param;
import org.bop.treehole.domain.Reply;

import java.util.List;

/**
 * 回复 DAO 接口类
 *
 * Created by bysocket on 02/05/2017.
 */
public interface ReplyDao {

    /**
     * 保存回复
     *
     * @param reply
     * @return
     */
    Long saveReply(Reply reply);

    /**
     * 获取待回复的留言列表
     *
     * @return
     */
    List<Long> findToReplyMessageIds();

    /**
     * 获取留言待回复列表
     *
     * @return
     */
    List<Reply> findToReplyByMessageId(@Param("messageId") Long messageId);
}
