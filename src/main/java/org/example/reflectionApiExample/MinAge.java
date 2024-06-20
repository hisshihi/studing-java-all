package org.example.reflectionApiExample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Где можно будет использовать аннотацию
@Target({
        ElementType.TYPE,
        ElementType.FIELD
})
// Как долго и где будет хранится аннотация
@Retention(RetentionPolicy.RUNTIME)
public @interface MinAge {

    int value() default 18;

}
