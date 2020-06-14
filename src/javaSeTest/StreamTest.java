package javaSeTest;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args){
       // 串行流
       /*List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");
       String joinStr = stringList.stream()
               .filter(item -> !item.isEmpty())
               .sorted()
               .collect(Collectors.joining("="));
       System.out.println(joinStr);

        List<String> filtered = stringList.stream()
                .filter(item -> !item.isEmpty())
                .map(s -> s + "!!")
                .limit(100)
                .sorted()
                .collect(Collectors.toList());

        for (String s: filtered) {
            System.out.println(s);
        }

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());*/

       /* 并行流 */
       /*List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.print(count);*/

        /*
        * 生成Stream的方法：
        * 1、Stream接口的静态工厂方法（java8里的接口可以带静态方法）
        * 2、Collection接口或数组的stream方法
        * 3、Random.ints()
        *    BitSet.stream()
        *    Pattern.splitAsStream(java.lang.CharSequence)
        *    JarFile.stream()
        * */

        /*
        * 使用Stream接口的of静态方法生成Stream实例
        * 使用of方法生成的Stream的长度就是方法形参的个数
        * */
//        Stream<Integer> integerStream = Stream.of(1, 2, 3);

        /**
         * 使用Stream接口的generate静态方法生成一个串行的、无限长度的Stream实例
         * 其中函数形参是Supplier接口的实例
         * Supplier接口是一个函数式接口
         */
//        Stream<Double> generateA = Stream.generate(Math::random);

        /**
         * 使用Stream接口的iterate静态方法生成一个无限长度的、有序的Stream
         * iterate函数签名是：iterate(T seed, UnaryOperator<T>f)
         * 最后Stream中生成的元素可以看成是：seed、f(seed)、f(f(seed))......
         */
        /*Stream.iterate(1, item -> item + 1)
                .limit(10)
                .forEach(System.out::println);*/

        /**
         * 使用Stream接口的empty静态方法生成一个空的Stream
         */
//        Stream<Integer> emptyStream = Stream.empty();

        /**
         * 使用Collection接口的Stream方法、Arrays的Stream方法
         * 生成Stream
         */
        /*List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        Stream<Integer> integerStream1 = integerList.stream();
        long[] nums = new long[]{1, 3,4,7};
        LongStream longStream = Arrays.stream(nums);
        longStream.forEach(System.out::println);*/


        List<String> strList = Arrays.asList("a", "b", "c", "d");
        Optional<String> resultStr = strList.stream()
                .reduce((a, b) -> a + "=" + b);
        resultStr.ifPresent(System.out::println);

        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        Stream stream = Stream.of("a", "b", "c");
        stream.collect(Collectors.toList());

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5)
        );
        List<Integer> integerList = inputStream.flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(integerList);

        List<String> peekTest = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(peekTest);

        List<String> strArr = Arrays.asList("q", "w", "e");
        strArr.forEach(System.out::println);
    }
}
