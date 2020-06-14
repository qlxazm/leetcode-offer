package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 快手面试题
 */
public class PrettyPhoneSort {

    public String prettyPhoneSort(String line) {
        String[] phones = line.split(",");
        List<PrettyPhone> prettyPhones = new ArrayList<>();
        for (String phone : phones) {
           int sValue = getValueOfSunZi(phone);
           int bValue = getValueOfBaoZi(phone);
           PrettyPhone prettyPhone = new PrettyPhone(phone);
           if (sValue > 0) {
               prettyPhone.isS = true;
               prettyPhone.len = sValue;
           }
           if (bValue >= sValue) {
               prettyPhone.isS = false;
               prettyPhone.isB = true;
               prettyPhone.len = bValue;
           }
           if (prettyPhone.len > 0) {
               prettyPhones.add(prettyPhone);
           }
        }
        prettyPhones.sort(new Comparator<PrettyPhone>() {
            /**
             * 降序排列
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(PrettyPhone o1, PrettyPhone o2) {
                if (o1 == o2) {
                    return 0;
                } else if ((o1.isS && o2.isS) || (o1.isB && o2.isB)) {
                    return o2.len - o1.len;
                } else if (o1.isS && o2.isB){
                    return o2.len >= o1.len ? 1 : -1;
                } else {
                    return o1.len >= o2.len ? -1 : 1;
                }
            }
        });

        StringBuilder builder = new StringBuilder();
        for (PrettyPhone prettyPhone : prettyPhones) {
            builder.append(prettyPhone.phone);
            builder.append(",");
        }
        String ans = builder.toString();
        return ans.substring(0, ans.length() - 1);
    }


    private int getValueOfSunZi(String phoneNum) {
        int sLen = 0;
        for (int i = 3; i <= 7; i++) {
            int j = i + 3;
            // 顺子
            if (phoneNum.charAt(i) + 1 == phoneNum.charAt(i + 1) && phoneNum.charAt(i + 1) + 1 == phoneNum.charAt(i + 2)) {
                while (j <= 10 && phoneNum.charAt(j) == phoneNum.charAt(j - 1) + 1) { j++; }
                sLen = Math.max(sLen, j - i);
                i = j;
            } else if(phoneNum.charAt(i) - 1 == phoneNum.charAt(i + 1) && phoneNum.charAt(i + 1) - 1 == phoneNum.charAt(i + 2)) {
                while (j <= 10 && phoneNum.charAt(j) == phoneNum.charAt(j - 1) - 1) { j++; }
                sLen = Math.max(sLen, j - i);
                i = j;
            }
        }
        return sLen;
    }

    private int getValueOfBaoZi(String phoneNum) {
        int bLen = 0;
        for (int i = 3; i <= 7; i++) {
            int j = i + 3;
            // 顺子
            if (phoneNum.charAt(i) == phoneNum.charAt(i + 1) && phoneNum.charAt(i + 1) == phoneNum.charAt(i + 2)){
                // 豹子
                while (j <= 10 && phoneNum.charAt(j) == phoneNum.charAt(j - 1)) { j++; }
                bLen = Math.max(bLen, j - i);
                i = j;
            }
        }
        return bLen;
    }

    class PrettyPhone{
        /**
         * 是否是顺子
         */
        boolean isS = false;
        /**
         * 是否是豹子
         */
        boolean isB = false;
        /**
         * 是豹子或顺子时的长度
         */
        int len = 0;

        String phone;

        public PrettyPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return phone;
        }
    }

    public static void main(String[] args) {
        String phones = "13811654321,13822123456";
        PrettyPhoneSort a = new PrettyPhoneSort();
        System.out.println(a.prettyPhoneSort(phones));
    }
}
