package org.bop.treehole.bean;

/**
 * Created by bysocket on 02/05/2017.
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(String replyEmail) {
        this.replyEmail = replyEmail;
    }

}
