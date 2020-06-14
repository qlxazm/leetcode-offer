package javaSeTest;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author qian
 * @date 2020/2/16 11:00
 */
public class ToolsTest {

    public static void collectionTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组：" + arrayList);

        Collections.reverse(arrayList);
        System.out.println("逆序之后的数组：" + arrayList);

        Collections.rotate(arrayList, 4);
        System.out.println("旋转之后的数组：" + arrayList);

        Collections.sort(arrayList);
        System.out.println("排序之后的数组：" + arrayList);

        Collections.shuffle(arrayList);
        System.out.println("随机洗牌之后的数组：" + arrayList);

        // 自定义排序规则（降序）
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("定制排序后的数组：" + arrayList);

        // 对有序的集合进行二分查找
        int index;
        index = Collections.binarySearch(arrayList, 7);
        System.out.println("二分查找返回的是索引：" + index + "，元素内容是：" + arrayList.get(index));

        index = Collections.min(arrayList);
        System.out.println("集合中的最小数：" + index);

        /*Collections.fill(arrayList, Integer.MIN_VALUE);
        System.out.println("填充整个list：" + arrayList);*/

        index = Collections.frequency(arrayList, 3);
        System.out.println("3的出现频率：" + index);

        Collections.replaceAll(arrayList, -1, Integer.MAX_VALUE);
        System.out.println("替换之后的列表：" + arrayList);

        // 返回集合对象的不可变视图，如果强行改变，将引发 java.lang.UnsupportedOperationException 异常
        List<Integer> unmodifiableList = Collections.unmodifiableList(arrayList);
    }

    public static void main(String[] args) {
        String[] str = {"you", "me"};
        List<String> list = Arrays.asList(str);
        str[0] = "me";
        System.out.println(list.get(0));

        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2   " + (i1 == i2));
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
        System.out.println("i1=i4   " + (i1 == i4));
        System.out.println("i4=i5   " + (i4 == i5));
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
        System.out.println("40=i5+i6   " + (40 == i5 + i6));

        /*String s = new String("a") + new String("b");
        String s1 = "ab" + "cd";
        String s2 = s.intern();
        System.out.println(s == s2);*/

        String s = new String("a");
//        s.intern();
        String s1 = "a";
        System.out.println(s == s1);


        // 实例化、取当前值和 stamp 值
        final Integer initialRef = 0, initialStamp = 0;
        final AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(initialRef, initialStamp);
        System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

        // compare and set
        final Integer newReference = 666, newStamp = 999;
        final boolean casResult = asr.compareAndSet(initialRef, newReference, initialStamp, newStamp);
        System.out.println("currentValue=" + asr.getReference()
                + ", currentStamp=" + asr.getStamp()
                + ", casResult=" + casResult);

        // 获取当前的值和当前的 stamp 值
        int[] arr = new int[1];
        final Integer currentValue = asr.get(arr);
        final int currentStamp = arr[0];
        System.out.println("currentValue=" + currentValue + ", currentStamp=" + currentStamp);

        // 单独设置 stamp 值
        final boolean attemptStampResult = asr.attemptStamp(newReference, 88);
        System.out.println("currentValue=" + asr.getReference()
                + ", currentStamp=" + asr.getStamp()
                + ", attemptStampResult=" + attemptStampResult);

        // 重新设置当前值和 stamp 值
        asr.set(initialRef, initialStamp);
        System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

        // [不推荐使用，除非搞清楚注释的意思了] weak compare and set
        // 困惑！weakCompareAndSet 这个方法最终还是调用 compareAndSet 方法。[版本: jdk-8u191]
        // 但是注释上写着 "May fail spuriously and does not provide ordering guarantees,
        // so is only rarely an appropriate alternative to compareAndSet."
        // todo 感觉有可能是 jvm 通过方法名在 native 方法里面做了转发
        final boolean wCasResult = asr.weakCompareAndSet(initialRef, newReference, initialStamp, newStamp);
        System.out.println("currentValue=" + asr.getReference()
                + ", currentStamp=" + asr.getStamp()
                + ", wCasResult=" + wCasResult);

    }
}
