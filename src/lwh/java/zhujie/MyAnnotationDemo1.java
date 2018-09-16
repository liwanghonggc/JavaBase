package lwh.java.zhujie;


/**
 * 注解的属性的类型只能是：基本类型、String、Class、枚举、注解类型以及以上类型的一维数组
 */
public @interface MyAnnotationDemo1 {

    String name();

    /** 类型 属性名称() default 默认值**/
    int age() default 18;

}
