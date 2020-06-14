package algorithm;

/**
 *
 */
public class SumNums {

    public int sumNums(int n) {
        return n + sumNums(n - 1);
    }
}
