package org.bop.treehole;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bop.treehole.config.properties.TreeHoleProperties;
import org.bop.treehole.support.DefaultProfileUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.bop.treehole.constant.AppProfiles.*;
import static org.springframework.util.ObjectUtils.containsElement;

@Slf4j
@ComponentScan
@AllArgsConstructor
@MapperScan("org.bop.treehole.dao")
@EnableAutoConfiguration(exclude = {MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@EnableConfigurationProperties({LiquibaseProperties.class, TreeHoleProperties.class})
public class TreeHoleApp {

    // Spring boot would auto inject this value
    private final Environment env;

    /**
     * Initializes Tree Hole App.
     * <p>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     */
    @PostConstruct
    public void initApplication() {
        String[] activeProfiles = DefaultProfileUtil.getActiveProfiles(env);
        if (containsElement(activeProfiles, SPRING_PROFILE_DEVELOPMENT) && containsElement(activeProfiles, SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run " +
                "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (containsElement(activeProfiles, SPRING_PROFILE_DEVELOPMENT) && containsElement(activeProfiles, SPRING_PROFILE_TEST)) {
            log.error("You have misconfigured your application! It should not" +
                "run with both the 'dev' and 'test' profiles at the same time.");
        }
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(TreeHoleApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Tree Hole '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" +
                "External: \t{}://{}:{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            DefaultProfileUtil.getActiveProfiles(env));
    }
}
