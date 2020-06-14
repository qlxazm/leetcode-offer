package java8;

/**
 * java8中接口不能指定构造函数和初始化块
 * 接口中定义的内部类默认使用public static修饰
 * @author qian
 * @date 2020/2/25 16:33
 */
public interface InterfaceDemo {

    /**
     * java8的接口中成员变量只能是静态常量（也就是自动被static final修饰，不用在声明的时候指定）
     * 成员变量的访问修饰符只能是public，而且也是默认的。
     * 定义成员变量时必须指定初始值
     */
    String NAME = "interface";
    int AGE = 1;

    /**
     * java8的接口只允许有抽象方法、类方法、默认方法
     * 并且这些方法自动被public修饰
     */

    /**
     * 这是一个抽象方法，在实现类中必须提供具体实现
     * @return
     */
    int method1();

    /**
     * 这是一个类方法，必须提供方法实现，可以通过InterfaceDemo.method2()访问
     * @return
     */
    static int method2() {
      return 2;
    }

    /**
     * 这是一个默认方法，必须提供方法实现，可以通过实现类的实例访问
     * @return
     */
    default int method3() {
        return 3;
    }

}
