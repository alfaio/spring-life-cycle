package io.hithub.alfaio.springlifecycle.definition;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author LimMF
 * @since 2024/5/11
 **/
public class ImportBeanDefinitionRegistrarImpl implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableConfig.class.getName());
        // 可以通过注解传递参数，如指定bean名字
        String beanName = attributes.get("defaultName").toString();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(BeanFromImportRegistry.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        registry.registerBeanDefinition(StringUtils.hasLength(beanName)?beanName: "BeanFromImportRegistry", beanDefinition);
    }
}
