package lwh.java.generic;

public class Cache1 {

    Object value;

    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }

    public static void main(String[] args) {
        Cache1 cache = new Cache1();
        cache.setValue(134);
        int value = (int)cache.getValue();
        System.out.println(value);
    }
}
