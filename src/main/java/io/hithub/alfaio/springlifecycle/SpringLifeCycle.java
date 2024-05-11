package io.hithub.alfaio.springlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author LimMF
 * @since 2024/5/10
 **/
@Component
public class SpringLifeCycle implements InstantiationAwareBeanPostProcessor, BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.contains("springBean")) {
            System.out.println(" ===>>> A.1 InstantiationAwareBeanPostProcessor: postProcessBeforeInstantiation");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.contains("springBean")) {
            System.out.println(" ===>>> A.3 InstantiationAwareBeanPostProcessor: postProcessAfterInstantiation");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.contains("springBean")) {
            System.out.println(" ===>>> A.4 InstantiationAwareBeanPostProcessor: postProcessProperties");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("springBean")) {
            System.out.println(" ===>>> A.7 BeanPostProcessor: postProcessBeforeInitialization");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("springBean")) {
            System.out.println(" ===>>> A.11 BeanPostProcessor: postProcessAfterInitialization");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
