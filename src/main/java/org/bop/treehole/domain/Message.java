package org.bop.treehole.domain;

import lombok.Data;

import java.util.Date;

/**
 * 留言实体类
 *
 * Created by bysocket on 02/05/2017.
 */
@Data
public class Message {

    /**
     * 留言编号
     */
    private Long id;

    /**
     * 是否删除 0 默认  1 删除
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 是否回复状态
     */
    private Integer isReplied;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复次数
     */
    private Integer replyNumber;
}
