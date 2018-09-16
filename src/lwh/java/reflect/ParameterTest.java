package lwh.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author lwh
 * @date 2018-09-16
 * @desp
 */

class Param{
    public void show(int a, String str){

    }
}

public class ParameterTest {

    public static void main(String[] args) {
        Class clazz = Param.class;
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("方法名" + method.getName());
            PrintParam task = new PrintParam();
            task.setMethod(method);
            new Thread(task).start();
        }
    }
}

class PrintParam implements Runnable{

    private Method method;

    public void setMethod(Method method){
        this.method = method;
    }

    @Override
    public void run() {
        Parameter[] parameters = method.getParameters();
        for(Parameter parameter : parameters){
            System.out.println("参数名: " + parameter.getType());
        }
    }
}
