package org.bop.treehole.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Business exception grouping and description
 * <p>
 * <strong>Error Code Mapping:</strong>
 * <ul>
 * <li>2000xx Net request exception for retrofit framework</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    NET_REQUEST_SUSPEND(2000001, "网络请求超时或者请求中断"),
    NET_REQUEST_ERROR(2000002, "网络请求服务器响应失败"),
    SENSITIVE_WORD(3000001, "提交信息存存在敏感词");

    private int code;

    private String desc;
}
