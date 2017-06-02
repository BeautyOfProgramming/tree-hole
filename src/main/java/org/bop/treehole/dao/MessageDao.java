package org.bop.treehole.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bop.treehole.domain.Message;

import java.util.List;

/**
 * 留言 DAO 接口类
 *
 * Created by bysocket on 02/05/2017.
 */
@Mapper
public interface MessageDao {

    List<Message> findAllMessage();

    Long saveMessage(Message message);

    Message findById(@Param("messageId") Long messageId);
}
