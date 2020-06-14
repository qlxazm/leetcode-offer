package java8;

/**
 * @author qian
 * @date 2020/2/25 21:04
 */
public class ConverterTest {

    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer a = converter.convert("1234");
    }
}
