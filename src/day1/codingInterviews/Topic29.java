package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/28 17:52
 * description:例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第1个开始,到第4个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 使用动态规划的方法来进行思考
 *
 * f(n) 有两种取值
 *
 * 当f(n-1)<=0时，取array[n]，从这个元素重新开始
 *
 * 当f(n-1)>0时，取f(n-1)+array[n]
 */
public class Topic29 {
    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length==0) {
            return 0;
        }
        int currentSum = array[0];
        int maxSum = currentSum;
        for (int i = 1; i < array.length; i++) {
            if (currentSum<0) {//前面的和是负数，就直接丢弃
                currentSum = array[i];
            } else {
                currentSum = currentSum + array[i];
            }
            if (currentSum>maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
