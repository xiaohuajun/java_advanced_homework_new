package bitmap;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/30 下午2:01
 * @description BitMap 位图
 */
public class BitMap {

    /**
     * char 16位 （2个字节）
     */
    private char[] bytes;

    private int n;

    public BitMap(int n) {
        this.n = n;
        bytes = new char[n / 16 + 1];
    }

    public void set(int k) {
        if (k > n) {
            return;
        }
        //以16位单位计算在数组的位置-巧妙
        int index = k / 16;
        //计算数组存储的值，需要余数
        int cal = k % 16;
        //1 * 2 cal 次方 按位或 结果 存储在 数组中 bytes[index]
        bytes[index] |= (1 << cal);
    }


    public boolean get(int k) {
        if (k > n) {
            return false;
        }
        //以16位单位计算在数组的位置-巧妙
        int index = k / 16;
        //计算数组存储的值，需要余数
        int cal = k % 16;
        //如果与数组的值匹配上，与运算就是原值，匹配不上就只0，因为与运算只有对应的位上都是1，才是1，否则就是0
        int s = bytes[index] & (1 << cal);
        return s != 0;
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10);
        bitMap.set(4);
        boolean b = bitMap.get(5);
        System.out.println("--->" + b);

    }


}
