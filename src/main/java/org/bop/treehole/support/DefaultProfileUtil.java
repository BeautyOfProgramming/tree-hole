package org.bop.treehole.support;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

import static java.util.Collections.singletonMap;
import static org.bop.treehole.constant.AppProfiles.SPRING_PROFILE_DEVELOPMENT;

/**
 * Utility class to load a Spring profile to be used as default
 * when there is no <code>spring.profiles.active</code> set in the environment or as command line argument.
 * If the value is not available in <code>application.yml</code> then <code>dev</code> profile will be used as default.
 */
public final class DefaultProfileUtil {

    private static final String SPRING_PROFILE_DEFAULT_KEY = "spring.profiles.default";

    private DefaultProfileUtil() {
        // No need to have construct function
    }

    /**
     * Set a default to use when no profile is configured.
     * <p>
     * The default profile to use when no other profiles are defined
     * This cannot be set in the <code>application.yml</code> file.
     *
     * @param app the Spring application
     * @link https://github.com/spring-projects/spring-boot/issues/1219
     */
    public static void addDefaultProfile(SpringApplication app) {
        app.setDefaultProperties(singletonMap(SPRING_PROFILE_DEFAULT_KEY, SPRING_PROFILE_DEVELOPMENT));
    }

    /**
     * Get the profiles that are applied else get default profiles.
     *
     * @param env spring environment
     * @return profiles
     */
    public static String[] getActiveProfiles(Environment env) {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length == 0) {
            return env.getDefaultProfiles();
        }
        return profiles;
    }
}
