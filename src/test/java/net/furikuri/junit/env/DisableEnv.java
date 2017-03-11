package net.furikuri.junit.env;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(EnvCondition.class)
public @interface DisableEnv {
    String[] value();
}
