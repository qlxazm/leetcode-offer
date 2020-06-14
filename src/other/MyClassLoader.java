package other;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader{

    /**
     * 基础路径
     */
    private String baseDir;

    public MyClassLoader(String baseDir) {
        this.baseDir = baseDir;
    }

    /**
     * 覆盖findClass方法
     * @param name 类的完全限定名
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        byte[] classData = getData(name);
        if (classData != null) {
            clazz = defineClass(name, classData, 0, classData.length);
        }

        return super.findClass(name);
    }

    /**
     * 获取类的字节码二进制流
     * @param name
     * @return
     */
    private byte[] getData(String name) {
        String[] classPath = name.split(".");
        String path = baseDir + File.separator + String.join(File.separator, classPath) + ".class";
        File file = new File(path);

        if (file.exists()) {
            FileInputStream is = null;
            ByteArrayOutputStream os = null;
            try {
                is = new FileInputStream(file);
                os = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;

                while ((size = is.read(buffer)) > 0) {
                    os.write(buffer, 0, size);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return os.toByteArray();
        }
        return null;
    }

    @Override
    public String toString() {
        return "other.MyClassLoader{" +
                "baseDir='" + baseDir + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        String baseDir = "E:\\IDEAWorkSpace\\javaTest\\out\\production\\javaTest";
        String clazz = "other.HelloWorld";

        MyClassLoader myClassLoader = new MyClassLoader(baseDir);
        Class<?> aClass = myClassLoader.loadClass(clazz);

        Object object = aClass.newInstance();

        System.out.println(object instanceof HelloWorld);
    }

}
