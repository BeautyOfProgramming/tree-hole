package org.bop.treehole.aop.sensitive;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.bop.treehole.web.dto.MessageBean;
import org.bop.treehole.web.exception.SensitiveWordsException;

import java.util.List;
import java.util.Optional;

import static org.bop.treehole.web.exception.ErrorCode.SENSITIVE_WORD;

@Slf4j
@Aspect
public class WordAspect {

    private final List<WordFilter> filters;

    public WordAspect(List<WordFilter> filters) {
        this.filters = filters;
    }

    @Around(value = "(execution(* org.bop.treehole.service.ReplyService.saveReply(..))" +
        "|| execution(* org.bop.treehole.service.MessageService.saveMessage(..))) && args(message)")
    public Object filterAround(ProceedingJoinPoint joinPoint, MessageBean message) throws Throwable {
        Optional<Boolean> haveSensitiveWords = filters.stream()
            .map(filter -> filter.containsSensitiveWord(message.getContent()))
            .filter(Boolean::booleanValue)
            .findAny();
        if (haveSensitiveWords.isPresent()) {
            throw new SensitiveWordsException(message.getContent(), SENSITIVE_WORD);
        } else {
            return joinPoint.proceed(); // NOSONAR
        }
    }
}
