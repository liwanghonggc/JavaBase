package lwh.java.reflect;

public class Person {

    private String name;

    private int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
