package org.bop.treehole.constant;

/**
 * Basic constants class for define tree hole spring profiles for development, test and production.
 * <p>
 * By default, application will use the dev profile. In production, you has to run with the prod profile.
 */
public class AppProfiles {

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_SWAGGER = "swagger";
    // Spring profile used to disable running liquibase
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";

    private AppProfiles() {
    }
}
