package org.bop.treehole.aop.sensitive;

public interface WordFilter {

    /**
     * @param txt The commit message from user
     * @return true marked passed
     */
    Boolean containsSensitiveWord(String txt);
}
