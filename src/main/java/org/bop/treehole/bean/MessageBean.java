package org.bop.treehole.bean;

import lombok.Data;

/**
 * Created by bysocket on 02/05/2017.
 */
@Data
public class MessageBean {

    private Long id;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 回复邮箱
     */
    private String replyEmail;
}
