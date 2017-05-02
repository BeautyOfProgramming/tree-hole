package org.bop.treehole.domain;

import java.util.Date;

/**
 * 留言实体类
 *
 * Created by bysocket on 02/05/2017.
 */
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(Integer isReplied) {
        this.isReplied = isReplied;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getReplyNumber() {
        return replyNumber;
    }

    public void setReplyNumber(Integer replyNumber) {
        this.replyNumber = replyNumber;
    }
}
