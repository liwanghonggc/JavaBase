package lwh.java.generic;

import java.lang.reflect.Field;

public class Cache2<T> {

    T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public static void main(String[] args) {
        Cache2<Integer> cache = new Cache2();
        cache.setValue(134);
        int value = cache.getValue();
        System.out.println(value);

        Class clazz = cache.getClass();
        System.out.println(clazz);

        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            System.out.println("Field name " + f.getName() + " type is " + f.getType().getName());
        }
    }
}
