package io.hithub.alfaio.springlifecycle.definition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LimMF
 * @since 2024/5/10
 **/
@Component
public class BeanFactoryPostProcessorImpl implements BeanDefinitionRegistryPostProcessor, BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 用于新增 BeanDefinition
        System.out.println(" ===>>> BeanFactory.1 BeanDefinitionRegistryPostProcessor: postProcessBeanDefinitionRegistry");
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(BeanFromRegistry.class);
        registry.registerBeanDefinition("BeanFromRegistry", builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" ===>>> BeanFactory.2 BeanFactoryPostProcessor: postProcessBeanFactory");
        // 用于修改 BeanDefinition,
        // 1、a. bean的个数。
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("    ===>>> Get " + count + " beans...");

        // 2、所有bean类名中包含springbean。
        Arrays.stream(beanFactory.getBeanDefinitionNames())
                .filter(name -> name.toLowerCase().contains("springbean"))
                .map(name -> "    ===>>> find bean with 'springbean': " + name).forEach(System.out::println);

        // 3、在启动的时候把Spring的某个原生Bean，替换为自己的Bean
        Arrays.stream(beanFactory.getBeanNamesForType(Apple.class)).forEach(beanName->{
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            beanDefinition.setBeanClassName(Peach.class.getName());
            beanDefinition.setFactoryBeanName(null);
            beanDefinition.setFactoryMethodName(null);
        });
        System.out.println("    ===>>> Replace Apple with Peach");
    }
}
