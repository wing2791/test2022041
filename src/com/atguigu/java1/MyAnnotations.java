package com.atguigu.java1;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER, ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
public @interface MyAnnotations {

   MyAnnotation[] value();
}
