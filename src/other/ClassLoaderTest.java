package other;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yd
 * @date 2020/4/4 15:54
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = myClassLoader.loadClass("other.ClassLoaderTest");
        System.out.println(object.getClass());
        System.out.println(object instanceof ClassLoaderTest);
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(object.getClass().getClassLoader());
    }
}
