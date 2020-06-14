package algorithm;

import java.util.Random;

/**
 */
public class Shuffle {

    private int randInt(int i, int j) {
        return new Random().nextInt(j - i) *  + i;
    }

    /**
     * 洗牌
     * @param arr
     */
    public void shuffle(int[] arr) {
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            int k = randInt(i, len - 1);
            // 交换
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    public void test() {
        int n = 6;
        int[] count = new int[6];
        for (int i = 0, N = 1000000; i < N; i++) {
            int[] arr = {1, 0, 0, 0, 0, 0};
            shuffle(arr);
            for (int j = 0; j < n; j++) {
                if (arr[j] == 1) {
                    count[j]++;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(count[i]);
        }
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        shuffle.test();
    }
}
