package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 */
public class GenericTest {
    public static void main(String[] args) {
        List<? super B> list = new ArrayList<>();
        list.add(new B());
        list.add(new C());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        B b = new B();
        A a = b;
    }

}
