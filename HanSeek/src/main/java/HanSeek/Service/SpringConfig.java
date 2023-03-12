package HanSeek.Service;


import HanSeek.Repository.JpaRepository;
import HanSeek.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class SpringConfig {

    @Bean
    public UserService userService2() {
        return new UserService(jpaRepository());
    }

    @Bean
    public JpaRepository jpaRepository() {
        return new UserRepository();
    }
}
