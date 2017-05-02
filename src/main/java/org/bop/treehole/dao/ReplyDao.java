package org.bop.treehole.dao;


import org.bop.treehole.domain.Reply;

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
}
