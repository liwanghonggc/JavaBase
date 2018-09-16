package lwh.java.generic;

import java.lang.reflect.Field;

public class Cache3 <T extends String> {

    T value;

    public Cache3(T value){
        this.value = value;
    }

    public static void main(String[] args) {
        Cache3<String> cache3 = new Cache3<>("hh");
        Class clazz = cache3.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            System.out.println("Field name " + f.getName() + " type is " + f.getType().getName());
        }
    }
}
