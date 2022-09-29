package stack;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/3 下午2:13
 * @description StackLearn
 */
public class StackLearn {


    /**
     * 构造一个单调递增栈：
     * 1、根据栈的特性，是后进先出
     * 2、递增的顺序就是---栈的出栈顺序
     * 3、递增顺序的构造：栈顶元素需要维护是最大的，栈底元素是最小的
     * 4、制定规则：入栈前需要：比较栈顶元素和入栈元素的大小
     * 5、如果入栈元素大于栈顶元素，直接入栈
     * 6、如果入栈元素小于、等于栈顶元素，则栈顶元素出栈，直到栈顶元素小于入栈元素
     * <p>
     * <p>
     * 每日温度计算：leetcode：739. 每日温度
     *
     * @param nums 每日的维度
     * @return 等待更高的温度的等待天数
     */
    public static int[] increaseStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        //下标是每一天，值是等待的天数
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int prev = stack.pop();
                // 因为当前温度比 prev温度高，需要等待的天数
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Random r = new Random();
            int g = r.nextInt(12);
            System.out.println("------>" + g);
        }
    }

}
