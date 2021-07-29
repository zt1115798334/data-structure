package day1.codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/29 10:14
 * description:
 */
public class Topic40 {

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList arrayList = new ArrayList<ArrayList<Integer>>();
        int low=1,high=2;
        while (low<high) {
            int currentSum = (low+high)*(high-low+1)/2;//除以2的操作放在后面，否则在前面除时，(low+high)/2除不尽会丢掉1，比如3/2*2会丢掉1。
            if (currentSum==sum) {
                ArrayList tempArrayList = new ArrayList<Integer>();
                for (int k =low;k<=high;k++) {
                    tempArrayList.add(k);
                }
                arrayList.add(tempArrayList);
                low++;
            } else if (currentSum<sum) {
                high++;
            } else {
                low++;
            }
        }
        return arrayList;
    }
}
