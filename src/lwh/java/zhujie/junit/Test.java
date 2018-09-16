package lwh.java.zhujie.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模拟Junit的单元测试@Test的注解
 * 此注解只能用于方法上,存在于运行时
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

    long time() default 2000;
}
