package lwh.java.zhujie.junit;

public class DemoTest1 {

    @Test(time = 1000)
    public void test1(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1执行了");
    }

    public void test2(){
        System.out.println("test2执行了");
    }
}
