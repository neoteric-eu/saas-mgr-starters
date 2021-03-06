package com.neoteric.starter.test.saasmgr.embedded;

import com.neoteric.starter.saasmgr.auth.SaasMgrAuthenticationProvider;
import com.neoteric.starter.saasmgr.filter.SaasMgrAuthenticationMatcher;
import com.neoteric.starter.saasmgr.model.AccountStatus;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@MockBean(value = SaasMgrAuthenticationMatcher.class, reset = MockReset.NONE)
@MockBean(value = SaasMgrAuthenticationProvider.class, reset = MockReset.NONE)
public @interface FixedSaasMgr {

    boolean noAuth() default false;
    String customerId() default "customerId";
    String customerName() default "customerName";
    String email() default "email";
    String firstName() default "firstName";
    String lastName() default "lastName";
    String userId() default "userId";
    AccountStatus accountStatus() default AccountStatus.ACTIVE;
    String[] features() default {};

    /**
     * Pattern: "KEY;0.5;10.0" Key name; max value; current value
     */
    String[] constraints() default {};
}
