package tech.ineb.ats.alpha.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static tech.ineb.ats.alpha.strategy.Strategy.DEFAULT_DESCRIPTION;
import static tech.ineb.ats.alpha.strategy.Strategy.DEFAULT_NAME;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Strategy {
    String name() default DEFAULT_NAME;

    String description() default DEFAULT_DESCRIPTION;

    /**
     * Should be defined in format RU:MOEX:FUT:LKOH
     * @return
     */
    String[] securities();
}
