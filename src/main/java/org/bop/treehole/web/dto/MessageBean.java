package org.bop.treehole.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

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
    @Email
    private String replyEmail;
}
