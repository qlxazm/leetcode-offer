package other;

public class StringConstPool {
    public static void main(String[] args) {
       /*
        答案：false
       String s = new String("1");
        s.intern();
        String s1 = "1";
        System.out.println(s == s1);*/

      /*
        答案：true
      String s = new String("1") + new String("1");
       s.intern();
       String s1 = "11";
       System.out.println(s == s1);*/

      String s1 = new String("he") + new String("llo");
      String s2 = new String("h") + new String("ello");

      String s3 = s1.intern();
      String s4 = s2.intern();

      System.out.println(s1 == s3);
      System.out.println(s1 == s4);

    }
}
