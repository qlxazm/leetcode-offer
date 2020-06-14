package hot100;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */
public class num406 {

    public int[][] reconstructQueue(int[][] people) {
        // 1、先按照k升序排列，再按照h升序排列
        quickSort(people, 0, people.length - 1);

        // 2、重新生成顺序
        for (int i = 1, len = people.length; i < len; i++) {
            int count = people[i][1], j = 0;
            while (j < i && count > 0) {
                if (people[j][0] >= people[i][0]) {count--;}
                j++;
            }
            while (j < i) {
                if (people[j][0] >= people[i][0]) {break;}
                j++;
            }

            int[] currPeople = people[i];
            // 现在j指向的位置就是currPeople最后的合适的位置，现在需要将j到i - 1位置之间的元素后移一个位置
            for (int k = i - 1; k >= j; k--) {people[k + 1] = people[k];}
            people[j] = currPeople;

        }

        return people;
    }

    /**
     * 快速排序
     * @param data
     * @param i
     * @param j
     */
    private void quickSort(int[][] data, int i, int j) {
        if (i >= j) {return;}
        int[] pivot = data[i];
        int lower = i, higher = j;

        while (i < j) {
            while (j > i && (data[j][1] > pivot[1] || (data[j][1] == pivot[1] && data[j][0] > pivot[0]))) {
                j--;
            }
            if (j > i) {data[i] = data[j];}
            while (i < j && (data[i][1] < pivot[1] || (data[i][1] == pivot[1] && data[i][0] <= pivot[0]))) {
                i++;
            }
            if (i < j) {data[j] = data[i];}
        }
        data[i] = pivot;
        // 排序子问题
        quickSort(data, lower, i);
        quickSort(data, i + 1, higher);
    }

    public static void main(String[] args) {
        num406 a = new num406();
        int[][] people = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        a.reconstructQueue(people);
        for (int[] pair : people) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}
