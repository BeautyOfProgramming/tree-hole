CREATE TABLE message
(
  id            BIGINT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  status        TINYINT(11) DEFAULT '0'         NOT NULL COMMENT '状态：0 默认 1 删除',
  create_time   DATETIME COMMENT '创建时间',
  update_time   DATETIME COMMENT '更新时间',
  content       VARCHAR(500) COMMENT '留言内容',
  is_replied    TINYINT(11) DEFAULT '0'         NOT NULL COMMENT '是否回复状态：0 默认 否 1 是',
  reply_content VARCHAR(500) COMMENT '回复内容',
  reply_number  INT(11) COMMENT '回复次数'
);

CREATE TABLE reply
(
  id          BIGINT(11) UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
  status      TINYINT(11) DEFAULT '0'         NOT NULL COMMENT '状态：0 默认 1 删除',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间',
  message_id  BIGINT(11) UNSIGNED             NOT NULL COMMENT '留言 ID',
  reply_email VARCHAR(200) COMMENT '回复的邮箱'
);
