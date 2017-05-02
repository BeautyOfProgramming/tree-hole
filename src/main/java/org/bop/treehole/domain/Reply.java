package org.bop.treehole.domain;

import java.util.Date;

/**
 * 回复实体类
 *
 * Created by bysocket on 02/05/2017.
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(String replyEmail) {
        this.replyEmail = replyEmail;
    }
}
