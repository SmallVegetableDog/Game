package matches.no316;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Num6224 {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        Integer c = 5;

        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(c.compareTo(c));
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->o2-o1);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.forEach(System.out::println);
    }


    public int subarrayGCD(int[] nums, int k) {
        int res = 0;

        return res;
    }



}
