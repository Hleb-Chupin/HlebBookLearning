package lessonseven;

import java.util.*;


public class CheckTime {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        List list = new LinkedList();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        list.add("60");
        list.add("70");
        System.out.println(System.currentTimeMillis());
        list.get(0);
        list.get(1);
        list.get(2);
        list.get(3);
        list.get(4);
        list.get(5);
        list.get(6);
        System.out.println(System.currentTimeMillis());
        list.clear();
        System.out.println(System.currentTimeMillis());
        System.out.println("");

        System.out.println(System.currentTimeMillis());
        List arrList = new ArrayList();
        arrList.add("10");
        arrList.add("20");
        arrList.add("30");
        arrList.add("40");
        arrList.add("50");
        arrList.add("60");
        arrList.add("70");
        System.out.println(System.currentTimeMillis());
        arrList.get(0);
        arrList.get(1);
        arrList.get(2);
        arrList.get(3);
        arrList.get(4);
        arrList.get(5);
        arrList.get(6);
        System.out.println(System.currentTimeMillis());
        arrList.clear();
        System.out.println(System.currentTimeMillis());
        System.out.println("");

        System.out.println(System.currentTimeMillis());
        Set tree = new TreeSet();
        tree.add("10");
        tree.add("20");
        tree.add("30");
        tree.add("40");
        tree.add("50");
        tree.add("60");
        tree.add("70");
        System.out.println(System.currentTimeMillis());
        tree.iterator();
        System.out.println(System.currentTimeMillis());
        tree.clear();
        System.out.println(System.currentTimeMillis());
        System.out.println("");

        System.out.println(System.currentTimeMillis());
        Set hash = new HashSet();
        tree.add("10");
        tree.add("20");
        tree.add("30");
        tree.add("40");
        tree.add("50");
        tree.add("60");
        tree.add("70");
        System.out.println(System.currentTimeMillis());
        tree.iterator();
        System.out.println(System.currentTimeMillis());
        tree.clear();
        System.out.println(System.currentTimeMillis());
        System.out.println("");
    }


}
