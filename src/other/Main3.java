package other;

/**
 */
public class Main3 {

    public double sqart(double n) {
        /*if (n == 0) { return 0; }
        double lower = 0, hight = n;
        double mid = 0;
        while (!isTerminal(mid)) {
            mid = (lower + hight) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                hight = mid;
            } else {
                lower = mid;
            }
        }
        return mid;*/

        if (n == 0) {return 0;}
        double lower = 0, hight = n;
        double mid = lower + (hight - lower) / 2;
        while (Math.abs(mid * mid - n) >= 1e-10) {
            if (mid * mid > n) {
                hight = mid;
            } else if (mid * mid < n) {
                lower = mid;
            }
            mid = lower + (hight - lower) / 2;
        }
        return mid;
    }

    private boolean isTerminal(double n) {
        String nStr = Double.toString(n);
        int index = nStr.indexOf(".");
        return (nStr.length() - index - 1) == 10;
    }

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.sqart(2));
    }

}
