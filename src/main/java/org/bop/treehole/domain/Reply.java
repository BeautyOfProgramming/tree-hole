package org.bop.treehole.domain;

import lombok.Data;

import java.util.Date;

/**
 * 回复实体类
 *
 * Created by bysocket on 02/05/2017.
 */
@Data
public class Reply {

    /**
     * 回复编号
     */
    private Long id;

    /**
     * 是否删除 0 默认  1 删除
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    /**
     * 留言 ID
     */
    private Long messageId;

    /**
     * 回复邮箱
     */
    private String replyEmail;
}
