package io.hithub.alfaio.springlifecycle.bean;

import org.springframework.stereotype.Component;

/**
 * @author LimMF
 * @since 2024/5/10
 **/
@Component
public class OtherBean {

    public OtherBean() {
        System.out.println(" ===>>> OtherBean: constructor");
    }

}
