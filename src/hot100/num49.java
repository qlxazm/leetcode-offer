package hot100;

import structs.ListNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 问题的关键是如何快速判断两个字符串含有相同的字符，这里是按照位运算实现的(但是这种判断不适合有重复字符的情况，如果有重复字符则可能相同)
 *  /*String s1 = s, s2 = anagrams.s;
 *             int flag1 = 0, flag2 = 0;
 *             if (s1.length() != s2.length()) {return false;}
 *             for (int i = 0, len = s1.length(); i < len; i++) {
 *                 flag1 += 1 << s1.charAt(i) - 'a';
 *                 flag2 += 1 << s2.charAt(i) - 'a';
 *             }
 *             return (flag1 & flag2) >= 0;
 *
 *
 *             HashMap在比较两个key是否相同时，首先比较两个key的hash的是否相同。如果不同，这两个key就不相同。如果相同，转而调用equals方法
 *             来比较两个key是否相同。
 */
public class num49 {

    static class Anagrams {
        public String s;
        public boolean[] chars = new boolean[26];
        public Anagrams(String s) {
            this.s = s;
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a'] = true;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Anagrams anagrams = (Anagrams) o;
            boolean result = true;
            for (int i = 0; i < 26 && result; i++) {
                result = result && chars[i] == anagrams.chars[i];
            }
            return s.length() == anagrams.s.length() && result;
        }

        @Override
        public int hashCode() {
            int flag = 0;
            for (int i = 0, len = s.length(); i < len; i++) {
                flag += 1 << s.charAt(i) - 'a';
            }
            return flag;
        }
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Anagrams, List<String>> map = new HashMap<>();
        for (int i = 0, len = strs.length; i < len; i++) {
            String str = strs[i];
            Anagrams temp = new Anagrams(str);
            List<String> list = map.containsKey(temp) ? map.get(temp) : new ArrayList<>();
            list.add(str);
            map.put(temp, list);
        }

        List<List<String>> result = new ArrayList<>();
       Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List> entry = (Map.Entry<String, List>)iterator.next();
            result.add(entry.getValue());
        }


        return result;
    }

   /* public boolean strIsSame(String s1, String s2) {
        int flag1 = 0, flag2 = 0;
        if (s1.length() != s2.length()) {return false;}
        for (int i = 0, len = s1.length(); i < len; i++) {
            flag1 += 1 << s1.charAt(i) - 'a';
            flag2 += 1 << s2.charAt(i) - 'a';
        }
        return (flag1 & flag2) > 0;
    }*/

    public static void main(String[] args) {
        num49 a = new num49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {"", ""};
        List<List<String>> result = a.groupAnagrams(strs);

        for (int i = 0; i < result.size(); i++) {
            List<String> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + ",");
            }
            System.out.println("");
        }

        HashMap<Anagrams, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        map.put(new Anagrams("huh"), list);
        if (map.containsKey(new Anagrams("tit"))){
            System.out.println("可以啦！");
            System.out.println(new Anagrams("huh").equals(new Anagrams("tit")));
            System.out.println(new Anagrams("tit").hashCode());
        }

//        System.out.println(a.strIsSame("eat", "atea"));
    }
}
