package org.bop.treehole.aop.sensitive.filters;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bop.treehole.aop.sensitive.WordFilter;

import java.io.*;
import java.util.*;

/**
 * DFA
 *
 * @see "http://blog.csdn.net/chenssy/article/details/26961957"
 */
@Slf4j
public class SensitiveWordFilter implements WordFilter {

    private Map sensitiveWordMap = null;

    public static final int minMatchTYpe = 1;
    public static final int maxMatchType = 2;

    public SensitiveWordFilter(File file) {
        sensitiveWordMap = loadSensitiveWord(file);
    }

    @SneakyThrows
    private Set<String> readSensitiveWord(File file) {
        Set<String> set = Sets.newHashSet();
        try (InputStream inputStream = new FileInputStream(file)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                set.add(line);
            }
        }
        return set;
    }

    private Map addSensitiveWordToHashMap(Set<String> keyWordSet) {
        Map resultMap = Maps.newHashMapWithExpectedSize(keyWordSet.size());
        String key;
        Map nowMap;
        Map newWorMap;
        for (String aKeyWordSet : keyWordSet) {
            key = aKeyWordSet;
            nowMap = resultMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    newWorMap = new HashMap<>();
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }
                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");
                }
            }
        }
        return resultMap;
    }

    private Map loadSensitiveWord(File file) {
        Set<String> sensitiveWord = readSensitiveWord(file);
        return addSensitiveWordToHashMap(sensitiveWord);
    }

    public Boolean containsSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = this.containsSensitiveWord(txt, i, matchType);
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    public Integer containsSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;
        int matchFlag = 0;
        char word = 0;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            if (Character.isWhitespace(word)) {
                continue;
            }

            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                matchFlag++;
                if ("1".equals(nowMap.get("isEnd"))) {
                    flag = true;
                    if (SensitiveWordFilter.minMatchTYpe == matchType) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (matchFlag < 2 || !flag) {
            matchFlag = 0;
        }
        return matchFlag;
    }

    public Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<>();
        for (int i = 0; i < txt.length(); i++) {
            int length = containsSensitiveWord(txt, i, matchType);
            if (length > 0) {
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }
        return sensitiveWordList;
    }

    public String replaceSensitiveWord(String txt, int matchType, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word;
        String replaceString;
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            word = iterator.next();
            sb.append(word);

            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);

            if (sb.toString().length() < txt.length()) {
                return txt;
            }
        }

        return resultTxt;
    }

    private String getReplaceChars(String replaceChar, int length) {
        StringBuilder resultReplace = new StringBuilder(replaceChar);
        for (int i = 1; i < length; i++) {
            resultReplace.append(replaceChar);
        }
        return resultReplace.toString();
    }

    @Override
    public Boolean containsSensitiveWord(String txt) {
        return containsSensitiveWord(txt, minMatchTYpe);
    }
}
