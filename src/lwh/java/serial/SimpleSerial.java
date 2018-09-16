package lwh.java.serial;

import java.io.*;

public class SimpleSerial {

    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        Person person = new Person("lwh", 23, Gender.MALE);
        Pet pet = new Pet("cat");
        person.setPet(pet);

        System.out.println(person);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(person);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = in.readObject();
        in.close();

        System.out.println(newPerson);
    }
}
