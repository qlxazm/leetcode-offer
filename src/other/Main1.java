package other;

/**
 */
public class Main1 {

    public boolean isPower2(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        int n = 12;
        Main1 main1 = new Main1();
        System.out.println(main1.isPower2(n));
    }

}
