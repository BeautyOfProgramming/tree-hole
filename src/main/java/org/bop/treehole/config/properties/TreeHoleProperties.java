package org.bop.treehole.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

/**
 * The main configuration properties for tree hole app. Validate the need configuration in boot file.
 */
@Data
@ConfigurationProperties(prefix = "tree", ignoreUnknownFields = false)
public class TreeHoleProperties {

    private final CorsConfiguration cors = new CorsConfiguration();

    private final Http http = new Http();

    @Data
    public static class Http {

        public enum Version {V_1_1, V_2_0}

        private final Cache cache = new Cache();

        /**
         * HTTP version, must be "V_1_1" (for HTTP/1.1) or V_2_0 (for (HTTP/2)
         */
        public Version version = Version.V_1_1;

        @Data
        public static class Cache {

            private int timeToLiveInDays = 1461;
        }
    }
}
