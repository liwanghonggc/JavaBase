package lwh.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {

    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("lwh.java.reflect.Person");
        Person person = (Person) clazz.newInstance();

        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        method.invoke(person, "lwh");
        System.out.println(person.getName());

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "xcj");

        System.out.println(person.getName());

        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person newPerson = (Person)constructor.newInstance("lwh", 25);
        System.out.println(newPerson.getName());

        int parameterCount = method.getParameterCount();
        System.out.println(parameterCount);

        Parameter[] parameters = method.getParameters();
        for(Parameter parameter : parameters){
            System.out.println(parameter.getType());
        }

    }
}
