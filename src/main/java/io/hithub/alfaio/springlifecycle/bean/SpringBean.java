package io.hithub.alfaio.springlifecycle.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author LimMF
 * @since 2024/5/10
 **/
@Component
public class SpringBean implements InitializingBean, DisposableBean
        , BeanNameAware, ApplicationContextAware {

    @Value("${test.spring.Value}")
    String springValue;

    @Autowired
    OtherBean otherBean;

    ApplicationContext applicationContext;

    public SpringBean() {
        System.out.println(" ===>>> SELF.2 SpringBean: construct");
    }

    // 不知道为什么没有调用
    public void setOtherBean(OtherBean otherBean) {
        System.out.println(" ===>>> SELF.？ SpringBean: setOtherBean");
        this.otherBean = otherBean;
    }


    @Override
    public void setBeanName(String name) {
        System.out.println(" ===>>> SELF.5 BeanNameAware: setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(" ===>>> SELF.6 ApplicationContextAware: setApplicationContext");
        this.applicationContext = applicationContext;
    }

    /**
     * PostConstruct是Java EE 5引入的注解，Spring从2.5版本开始支持该注解。
     * 该注解被用来修饰方法，被@PostConstruct修饰的方法会在类的构造函数执行完毕、字段注入之后执行，
     * 但在Bean的afterPropertiesSet或init-method之前执行。
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println(" ===>>> SELF.8 PostConstruct: postConstruct");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" ===>>> SELF.9 InitializingBean: afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println(" ===>>> SELF.10 @Bean: initMethod");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(" ===>>> SELF.12 DisposableBean: destroy");
    }

    public void destroyMethod() {
        System.out.println(" ===>>> SELF.13 @Bean: destroyMethod");
    }
}
