package other;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class Container {

    public void isBox() {
        String ok = "POSSIBLE";
        String noOk = "IMPOSSIBLE";

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            int k = 0, a, b;
            int[][] nums = new int[6][2];
            while (k < 6) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                // 保证从小到大
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                nums[k][0] = a;
                nums[k][1] = b;
                k++;
            }

            Arrays.sort(nums, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });


            if (nums[0][0] == nums[1][0] && nums[0][1] == nums[1][1]
                    && nums[2][0] == nums[3][0] && nums[2][1] == nums[3][1]
                    && nums[4][0] == nums[5][0] && nums[4][1] == nums[5][1]) {
                if (nums[0][0] == nums[2][0] && nums[4][0] == nums[0][1] && nums[4][1] == nums[2][1]) {
                    System.out.println(ok);
                } else {
                    System.out.println(noOk);
                }
            } else {
                System.out.println(noOk);
            }


            T--;
        }
    }


    public static void main(String[] args){
        Container container = new Container();
        container.isBox();
    }
}
