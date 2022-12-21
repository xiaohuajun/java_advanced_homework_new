package base;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/30 下午3:05
 * @description SimpleComputer 简单的计算
 */
public class SimpleComputer {


    public static void main(String[] args) {
        int k = 5;
        // 0 ~ 7 = 0,8 ~ 15 = 1  16 ~ 23 = 2  24～31 = 3
        // 32 ～ 39 = 4  40～47 = 5  48 ～ 55 = 6  56～63 = 7
        // 64 ~ 71 = 8.....
        //向下取整
        int r = k / 8;
        //求余数：左边小于右边 余数是本身
        int h = k % 8;
        //二进制：0101
        int a = 5;
        //二进制：0011
        int b = 3;
        //按位或：只有两个都是0，结果才是0 ---> 0111 = 1 + 2 + 4
        //a |= b;
        //按位与：只有两个都是1，结果才是1 ---> 0001 = 1
        //a &= b;
        //按位异或：异或运算只要与本身运算都是0(false) ---> 0110 = 4 + 2 = 6
        a ^= b;
        System.out.println("---->" + r);
        System.out.println("---->" + h);
        System.out.println("---->" + a);
    }


}
