package java8;

/**
 * 函数式接口，只要这个接口中 只有一个抽象方法（可以有多个默认方法、类方法），这个接口就算是函数式接口。
 * 如果lambda表达式的方法体只有一行代码时，可以使用方法引用或者构造函数引用
 * @author qian
 * @date 2020/2/25 21:02
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
