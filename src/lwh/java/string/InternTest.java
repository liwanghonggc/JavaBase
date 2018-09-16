package lwh.java.string;

/**
 * @author lwh
 * @date 2018-09-14
 * @desp
 */
public class InternTest {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc").intern();
        System.out.println(str1 == str2);
    }
}
