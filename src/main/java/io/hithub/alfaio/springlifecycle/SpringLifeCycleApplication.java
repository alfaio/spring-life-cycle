package io.hithub.alfaio.springlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLifeCycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLifeCycleApplication.class, args);
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public SpringBean springBean() {
        return new SpringBean();
    }

}
