package io.hithub.alfaio.springlifecycle.definition;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author LimMF
 * @since 2024/5/11
 **/
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ImportBeanDefinitionRegistrarImpl.class)
public @interface EnableConfig {
    String defaultName() default "";
}
