package stack;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/10/11 下午6:35
 * @description Lattery
 */
public class Lattery {


    private static Set<Integer> prevSet = new HashSet<>();

    private static Set<Integer> afterSet = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            calPrev(1);
        }
        for (int i = 0; i < 2; i++) {
            calAfter(1);
        }

        for (Integer prev : prevSet) {
            System.out.println("前区---->" + prev);
        }
        for (Integer after : afterSet) {
            System.out.println("后区---->" + after);
        }
    }

    private static void calPrev(int sed) {
        Random r = new Random();
        int g = r.nextInt(35);
        if (g == 0 || !prevSet.add(g)) {
            calPrev(g);
        }
    }

    private static void calAfter(int s) {
        Random r = new Random();
        int g = r.nextInt(12);
        if (g == 0 || !afterSet.add(g)) {
            calAfter(g);
        }
    }
}
