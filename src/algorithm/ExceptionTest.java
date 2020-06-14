package algorithm;

import java.io.IOException;
import java.util.HashMap;

/**
 */
public class ExceptionTest {
    public void method1() {
        throw new RuntimeException();
    }

    public void method2() throws IOException{
        throw new IOException();
    }

    public void method3() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        ExceptionTest exceptionTest = new ExceptionTest();
//        exceptionTest.method1();
//        exceptionTest.method2();

        HashMap<MyKey, Integer> map = new HashMap<>();
        MyKey myKey = new MyKey(1);
        map.put(myKey, null);
        map.put(null, null);
        System.out.println(map.get(myKey));
        System.out.println(map.get(new MyKey(1)));
        System.out.println(map.get(null));
    }

}
