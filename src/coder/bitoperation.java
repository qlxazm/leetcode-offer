package coder;

/**
 * Java 位运算
 */
public class bitoperation {
    public static void main(String[] args) {
        int a = 1;
        int b = -1;

        int result1 = a & b;
        System.out.println("1和-1按位与得结果是：" + result1);

        int result2 = a | b;
        System.out.println("1和-1按位或得结果是：" + result2);

        int result3 = ~a;
        System.out.println("1按位取反的结果是：" + result3);

        int result4 = ~b;
        System.out.println("-1按位取反的结果是：" + result4);

        int result5 = a << 2;
        System.out.println("1左移动两位的结果是：" + result5);

        int result6 = a >> 2;
        System.out.println("1右移动两位的结果是：" + result6);

        int result7 = b << 2;
        System.out.println("-1左移两位的结果是：" + result7);

        int result8 = b >> 2;
        System.out.println("-1右移两位的结果是：" + result8);

        System.out.println("6右移两位" + (6 >> 2));
    }
}
