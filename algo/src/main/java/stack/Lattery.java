package stack;

import java.util.*;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/10/11 下午6:35
 * @description Lattery
 */
public class Lattery {


    private static Set<Integer> prevSet = new HashSet<>();

    private static Set<Integer> afterSet = new HashSet<>();

    private static Set<Integer> prevSetForF = new HashSet<>();

    private static Set<Integer> afterSetForF = new HashSet<>();

    private static List<Integer> resList = new ArrayList<>();

    public static void main(String[] args) {
        calDaleTou();
        calTwoSeQiu();
        calThreeDes();
    }


    private static void calDaleTou() {
        for (int i = 0; i < 5; i++) {
            calPrev(1);
        }
        for (int i = 0; i < 2; i++) {
            calAfter(1);
        }
        for (Integer prev : prevSet) {
            System.out.println("大乐透前区---->" + prev);
        }
        System.out.println("==========================");
        for (Integer after : afterSet) {
            System.out.println("大乐透后区---->" + after);
        }
        System.out.println("==============大乐透===============");

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

    private static void calTwoSeQiu() {
        for (int i = 0; i < 6; i++) {
            calPrevF(1);
        }
        for (int i = 0; i < 1; i++) {
            calAfterF(1);
        }
        for (Integer prev : prevSetForF) {
            System.out.println("双色球前区---->" + prev);
        }
        System.out.println("==========================");
        for (Integer after : afterSetForF) {
            System.out.println("双色球后区---->" + after);
        }
        System.out.println("=============双色球==============");
    }

    private static void calPrevF(int sed) {
        Random r = new Random();
        int g = r.nextInt(33);
        if (g == 0 || !prevSetForF.add(g)) {
            calPrevF(g);
        }
    }

    private static void calAfterF(int s) {
        Random r = new Random();
        int g = r.nextInt(16);
        if (g == 0 || !afterSetForF.add(g)) {
            calAfterF(g);
        }
    }

    private static void calThreeDes() {
        for (int i = 0; i < 3; i++) {
            calThreeD();
        }
        System.out.println("==============3D===============");
        for (Integer s : resList) {
            System.out.println("3D---------->" + s);
        }
    }

    private static void calThreeD() {
        Random r = new Random();
        int g = r.nextInt(9);
        resList.add(g);
    }


}
