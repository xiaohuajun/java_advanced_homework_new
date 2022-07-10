package backtracking;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/10 下午6:16
 * @description ZeroOneBag 回溯算法实现 0-1 背包问题
 */
public class ZeroOneBag {


    /**
     * 存在背包中的物品重量的最大值
     */
    private static int maxWeight = Integer.MIN_VALUE;


    /**
     * 0-1背包问题：期望选择物品装如背包，不超过背包重量的情况下，使得装入背包的重量最大
     * 1、每种物品只有两种情况：装或者不装
     * 2、利用剪枝技巧：当前遇到物品重量大于背包重量或者当前背包剩余的重量，则不装入
     *
     * @param i     第几个物品
     * @param cw    背包已经装的重量
     * @param items 物品重量
     * @param n     物品个数
     * @param w     背包重量
     */
    public static void calBagWeight(int i, int cw, int[] items, int n, int w) {
        //递归终止条件
        if (cw == w || i == n) {
            if (cw > maxWeight) {
                maxWeight = cw;
            }
            return;
        }
        //考察下一个物品:先尝试所有的可能性，先遍历到末尾元素，从后往前装入背包
        calBagWeight(i + 1, cw, items, n, w);
        //剪枝
        if (cw + items[i] <= w) {
            calBagWeight(i + 1, cw + items[i], items, n, w);
        }
    }


    public static void main(String[] args) {
        //每个物品的重量
        int[] items = {43, 39, 25, 14};
        int n = items.length;
        int cw = 0;
        int w = 110;
        calBagWeight(0,cw,items,n,w);
        System.out.print("-----" + maxWeight +"------");
    }

}
