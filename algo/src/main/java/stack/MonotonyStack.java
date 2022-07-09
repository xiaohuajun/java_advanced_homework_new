package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/9 下午2:02
 * @description MonotonyStack 单调栈的应用：移掉k位数，使得移除后的数字值最小
 * leetcode：402. 移掉 K 位数字
 */
public class MonotonyStack {


    /**
     * 可以认为：高位 比 低位大，必须移除高位，最后的值才会是最小的
     * 从左往右：当前位的数值与前一位（高位）做比较：前一位 大于 当前位 前一位从栈顶弹出，当前位入栈
     * 使用单调栈：定义-> 从栈底到栈顶依次递增的栈
     * 处理过程中存在两个问题：
     * 1、如果需要移除k个数，当遍历结束后，k还有剩余，例如：k=4 ，遍历过程中已经移除2个，往后的数字都是
     * 当前位比前一位大，这样会一直入栈，不会移除栈顶；这时会再从栈顶移除 剩余k个元素
     * 2、如果存在0的情况：0会一直存在栈底，由于0是最小的非负整数，不会被弹出栈顶
     * 在处理最终结果的时候，需要处理这种前导0 的情况，直接移除
     * <p>
     * 实现：栈是后进先出的结构，为了最后结果的操作少一步反转，直接使用双端队列实现
     *
     * @param num 非负整数字符串
     * @param k   移除的个数
     * @return 移除后的最小的数字
     */
    public static String removeKdigits(String num, int k) {
        //边界条件
        int len = num.length();
        if (len == k) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            //前一位高位（栈顶） 大于 当前位，移除高位（栈顶）
            while (!deque.isEmpty() && deque.peekLast() > digit && k > 0) {
                deque.pollLast();
                k--;
            }
            //当前位入栈-队列尾部相当于栈顶
            deque.offerLast(digit);
        }
        //剩余k 还没有移除的情况,从栈顶移除剩余位数
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        //处理返回结果过程中(从队列的头部获取，不用反转)-移除前导0的
        StringBuilder sb = new StringBuilder();
        boolean isLeadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (isLeadingZero && digit == '0') {
                continue;
            }
            isLeadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String s = removeKdigits(num, k);
        System.out.println("------" + s);
    }

}
