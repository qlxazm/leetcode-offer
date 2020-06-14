package algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 */
public class NextDay {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String dates = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
        Date date1 = format.parse(dates.substring(0, 10));
        Date date2 = format.parse(dates.substring(13));

        long diff = date2.getTime() - date1.getTime();
        long days = Math.abs(diff) / (24 * 60 * 60 * 1000);
        int d = dates.charAt(11) - '0';

        days %= 7;

        if (diff > 0) {
            days = (d + days) % 7;
        } else {
            days = (d - days + 7) % 7;

        }
        System.out.println(days);
    }

}
