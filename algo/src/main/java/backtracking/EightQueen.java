package backtracking;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/7/10 上午9:39
 * @description EightQueue 回溯算法：8皇后问题
 */
public class EightQueen {


    private static int[] result = new int[8];


    /**
     * 8皇后问题：
     * 8 * 8的棋盘，每个放入一个棋子，要求，对角线、所在行和列不允许有其他的棋子
     * 如果不满足，则寻找另外一中放法
     * <p>
     * 每一行都有8种放法
     *
     * @param row 8行
     */
    public static void calEightQueens(int row) {
        //递归终止条件
        if (row == 8) {
            printQueen(result);
            return;
        }
        for (int col = 0; col < 8; col++) {
            //判断 左上角，右上角的对角线，左下角，右下角都没有开始放，所以不用的考虑
            if (isOk(row, col)) {
                //当前这行，这列可以放
                result[row] = col;
                //进行往下行继续放
                calEightQueens(row + 1);
            }
        }
    }


    /**
     * 检测当前行的左上角，右上角的对角线，左下角，右下角都没有开始放，所以不用的考虑
     *
     * @param row 当前行
     * @param col 当前列
     * @return 是否满足放的要求
     */
    private static boolean isOk(int row, int col) {
        //左上角
        int leftUp = col - 1;
        //右上角
        int rightUp = col + 1;
        //因为后面的行还没有开始处理，所以只需要判断往前的行、列左右上角
        for (int i = row - 1; i >= 0; --i) {
            //所在列
            if (result[i] == col) {
                return false;
            }
            //判断左上角
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            //判断右上角
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private static void printQueen(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.println("Q");
                } else {
                    System.out.println("*");
                }
            }
            System.out.println("-----");
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        calEightQueens(0);
    }

}
