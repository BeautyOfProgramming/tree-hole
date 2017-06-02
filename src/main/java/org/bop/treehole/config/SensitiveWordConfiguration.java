package org.bop.treehole.config;

import com.google.common.base.Strings;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bop.treehole.aop.sensitive.WordAspect;
import org.bop.treehole.aop.sensitive.WordFilter;
import org.bop.treehole.aop.sensitive.filters.SensitiveWordFilter;
import org.bop.treehole.config.properties.TreeHoleProperties;
import org.bop.treehole.constant.AppProfiles;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import java.util.List;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
public class SensitiveWordConfiguration {

    @Bean
    @SneakyThrows
    @ConditionalOnProperty(name = "tree.filter.enableDict", havingValue = "true")
    public WordFilter dictBasedFilter(TreeHoleProperties properties) {
        String dictPath = properties.getFilter().getDictPath();
        log.debug("Load sensitive dict file {}", dictPath);
        Assert.isTrue(!Strings.isNullOrEmpty(dictPath), "Need [tree.filter.dictPath] be configured");
        Assert.isTrue(ResourceUtils.isUrl(dictPath), "Wrong [tree.filter.dictPath], not a read uri");

        return new SensitiveWordFilter(ResourceUtils.getFile(dictPath));
    }

    @Bean
    @Profile({AppProfiles.SPRING_PROFILE_DEVELOPMENT, AppProfiles.SPRING_PROFILE_PRODUCTION})
    public WordAspect loggingAspect(List<WordFilter> filters) {
        return new WordAspect(filters);
    }
}
