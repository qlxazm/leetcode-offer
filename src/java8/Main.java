package java8;

/**
 * @author qian
 * @date 2020/2/25 16:13
 */
public class Main {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));

        // 下面开始使用java8中的接口
        InterfaceDemo interfaceDemo = new InterfaceDemo() {
            @Override
            public int method1() {
                return 0;
            }
        };
    }
}
