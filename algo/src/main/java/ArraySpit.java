import java.util.Arrays;


/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2023/2/9 下午8:23
 * @description ArraySpit
 */
public class ArraySpit {


    public static void splitArray(int[] a) {
        int n = a.length;
        //前缀和
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
        }
        //sum[left] <= sim[mid] <= sum[right]
        //枚举第一刀的位置，计算第二刀的位置是一个区间：[l,r]
        int l = 2;
        int r = 2;
        for (int i = 1; i <= n - 1; i++) {
            //保证l,r 都在i后面寻找
            l = Math.max(l, i + 1);
            r = Math.max(r, i + 1);
            // |-------|------|------|------|
            // 0       i      l      r      n
            //寻找第二个位置区间的最后一个位置，满足sum[right] >= sum[mid]，最后一个r
            while (r <= n - 1 && sum[n] - sum[r] >= sum[r] - sum[i]) {
                r++;
            }
            //寻找满足sum[mid] >= sum[left] 第一个 l
            while (l <= n - 1 && sum[l] - sum[i] < sum[i]) {
                l++;
            }
            //第二个位置mid在区间[l,r]
            if (l <= r) {
                printArr(a, i, l, r, n);
            }
        }

    }

    private static void printArr(int[] a, int i, int l, int r, int n) {

        for(int k = 0;k < r - l;k++){
            int[] a1 = new int[i];
            for(int h = 0;h < i;h++){
                a1[h] = a[h];
            }
            System.out.println("a1===>" + Arrays.toString(a1));

            int[] a2 = new int[k + 1];
            int mIndex = i;
            for(int e = 0; e < k + 1;e++){
                a2[e] = a[mIndex++];
            }
            System.out.println("a2===>" + Arrays.toString(a2));

            int[] a3 = new int[n - mIndex];
            int finIndex = mIndex;
            for(int x = 0;x < n - mIndex; x++){
                a3[x] = a[finIndex++];
            }
            System.out.println("a3===>" + Arrays.toString(a3));
            System.out.println("======分割线======");
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 5, 0};
        splitArray(a);


    }


}
