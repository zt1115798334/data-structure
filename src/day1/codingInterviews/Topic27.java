package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/28 17:40
 * description:
 */
public class Topic27 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0) {
            return 0;
        }
        if (array.length==1) {
            return array[0];
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                times = 1;
                result = array[i];
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        //下面就是判断这个数字是否满足条件
        int statTimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                statTimes++;
            }
        }
        if (statTimes>array.length/2) {
            return result;
        }
        return 0;
    }
}
