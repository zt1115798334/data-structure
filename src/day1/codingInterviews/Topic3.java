package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 10:13
 * description:
 */
public class Topic3 {
    public static void main(String[] args) {

    }

    /**
     * 在一个二维中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维[数组]和一个整数，判断数组中是否含有该整数。
     *如果在一个二维数组中找到数字7，则返回true，如果没有找到，则返回false。
     *
     * 思路
     * 就是从右上角开始遍历，假设要查找的数为A，当前遍历的数为B，B的特点是B所在行里面最大的数，也是B所在列最小的数，
     * 如果遍历的数B<A，那么B所在的行可以排除（比B都小)，如果遍历的数B>A，那么B所在的列可以排除(比B都大)。
     * @param target
     * @param arr
     * @return
     */
    public static boolean find(int target, int[][] arr) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int curRow = 0;
        int curCol = colLen - 1;
        while (curRow < rowLen && curCol >= 0) {
            if (arr[curRow][curCol] == target) {
                return true;
            } else if (arr[curRow][curCol] < target) {
                curRow++;
            }else{
                curCol--;
            }
        }
        return false;
    }
}
