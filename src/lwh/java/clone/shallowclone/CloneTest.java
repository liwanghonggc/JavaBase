package lwh.java.clone.shallowclone;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(23, "lwh", new Address("南京", "江苏"));

        Person newPerson = (Person)person.clone();

        System.out.println(person);
        System.out.println(newPerson);

        newPerson.setAge(25);
        newPerson.setName("xcj");
        Address address = newPerson.getAddress();
        address.setProvince("安徽");
        address.setStreet("亳州");

        System.out.println(person);
        System.out.println(newPerson);
    }
}
