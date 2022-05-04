package binasearch;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/4/30 下午2:41
 * @description Sqrt
 */
public class SqrtByBinarySearch {


    /**
     * 2的平方根 并且保留小数点后10位
     * 2的平方根：1.41 那求解 范围 1.42
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(sqrtDecimal(2));
    }

    /**
     * 求一个数的平方根，并保留6位小数
     *
     * @param x 求解的数
     * @return 平方根
     */
    public static double sqrtDecimal(int x){
        double l = 0;
        double h = x;
        double res = -1.100000;
        double flag = 0.000001;
        while(h - l >= flag){
           double mid = l + (h - l)/2;
            if(mid * mid <= x){
                res = mid;
                l = mid;
            }else {
                h = mid;
            }
        }
        return res;
    }


    /**
     * 整数的平方根
     *
     * @param x
     * @return
     */
    public static int sqrtInt(int x){
        int l = 0;
        int h = x;
        int res = -1;
        while(l <= h){
           int mid = l + (h - l)/2;
           //整数结果一定是在 mid * mid <= 这个区间寻找
            if((long) mid * mid <= x){
                res = mid;
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }
        return res;
    }

}
