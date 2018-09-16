package lwh.java.exception;

import java.sql.SQLException;

public class ExceptionTest {

    public static void main(String[] args) {

    }

    /** 抛出的是RuntimeException,方法声明无须使用throws,可以捕捉也可以不捕捉 **/
    public void test1(){
        throw new RuntimeException("runtime exception");
    }

    /** 抛出的是受检查异常,要在方法声明使用throws抛出,或者放在try里显示捕捉**/
    public void test2(){
        try {
            throw new SQLException("sql exception");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
