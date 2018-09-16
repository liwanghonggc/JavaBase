package lwh.java.zhujie.junit;

import java.lang.reflect.Method;

public class JunitRunner {

    public static void main(String[] args) throws Exception{
        Class clazz = DemoTest1.class;

        Method[] methods = clazz.getMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(Test.class)){
                /** 进一步判断是否有time属性,如果有的话方法的执行时间必须控制在time之内 **/
                Test test = method.getAnnotation(Test.class);

                long time = test.time();

                long now = System.currentTimeMillis();

                method.invoke(clazz.newInstance(), null);

                if(System.currentTimeMillis() - now > time){
                    throw new RuntimeException("超时了");
                }
            }
        }
    }
}
