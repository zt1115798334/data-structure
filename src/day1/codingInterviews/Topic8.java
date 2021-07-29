package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 10:37
 * description:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：旋转数组其实就是一个递增的数组，整体移动了一下元素，类似3，4，5，1，2这种。要查找最小的元素，可以遍历一遍数组，复杂度为O(N)，这样就太暴力了，因为这个旋转数组其实是有规律的，可以根据左边界，右边界，中间值来判断最小值的位置
 *
 * 左边界<=中间值 说明左边界到中间值这一段是递增的，也就是最小值不处于这一段。这样可以排除掉这一段，然后去另一段里面遍历查找。
 *
 * 中间值<=右边界 说明中间值到右边界这一段是递增的，也就是最小值不处于这一段。这样可以排除掉这一段，然后去另一段里面查找。
 *
 * 一直排除到最后，右边界下标-左边界下标==1时，说明左边界是最大值，右边界是最小值，此时整个循环结束。
 *
 * 特殊情况 左边界== 中间值==右边界 说明无法判断最小值位于哪里，只能从左边界到右边界进行遍历然后获得最小值。
 *
 * 题009斐波那契数列
 */
public class Topic8 {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
    public static  int minNumberInRotateArray(int[] array) {
        if (array[0]<array[array.length-1]){//当前就是一个递增的情况
            return array[0];
        }
        int start = 0;
        int end = array.length-1;
        int mid = 0;
        while (array[start] >= array[end]) {
            System.out.println(start+"======"+mid+"====="+end);
            if (end-start == 1) {
                return array[end];
            }
            mid = (end + start)/2;

            if (array[start] == array[mid] && array[start] == array[end]) {//左边界，中间值，右边界相等
                int min = array[start];
                for (int i = start+1; i <=end ; i++) {
                    if (array[i]< min) {
                        min = array[i];
                    }
                }
                return min;
            }
            if ( array[mid]>=array[start]){//左半部分是递增的，那么就去掉左半部分
                start = mid;
            } else if(array[mid]<=array[end]) {//右半部分是递增的，那么就去掉右半部分
                end = mid;
            }
        }
        return array[mid];
    }
}
