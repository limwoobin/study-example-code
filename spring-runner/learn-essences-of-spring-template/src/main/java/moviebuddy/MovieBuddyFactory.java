package moviebuddy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({ MovieBuddyFactory.DataSourceModuleConfig.class , MovieBuddyFactory.DataSourceModuleConfig.class })
public class MovieBuddyFactory {

    @Configuration
    static class DomainModuleConfig {

    }

    @Configuration
    static class DataSourceModuleConfig {

    }
}
