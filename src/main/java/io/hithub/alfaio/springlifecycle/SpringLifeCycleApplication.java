package io.hithub.alfaio.springlifecycle;

import io.hithub.alfaio.springlifecycle.bean.SpringBean;
import io.hithub.alfaio.springlifecycle.definition.Apple;
import io.hithub.alfaio.springlifecycle.definition.BeanFromImportRegistry;
import io.hithub.alfaio.springlifecycle.definition.BeanFromRegistry;
import io.hithub.alfaio.springlifecycle.definition.EnableConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableConfig
@SpringBootApplication
public class SpringLifeCycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringLifeCycleApplication.class, args);
        System.out.println(" ===>>> Registry By ImportBeanDefinitionRegistrar: " + context.getBean(BeanFromImportRegistry.class.getSimpleName()));
        System.out.println(" ===>>> Registry By BeanDefinitionRegistryPostProcessor: " + context.getBean(BeanFromRegistry.class.getSimpleName()));
        Apple apple = (Apple)context.getBean("apple");
        System.out.println(" ===>>> Bean replace by BeanFactoryPostProcessor, Apple name: " + apple.getName());
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public SpringBean springBean() {
        return new SpringBean();
    }

}
