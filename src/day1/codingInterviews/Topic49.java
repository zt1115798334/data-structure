package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/29 13:23
 * description:数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到 n-1 的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 解法一就是在遍历时将每个元素添加到hashSet，通过判断hashset中是否包含当前元素，来判断是否重复，由于这个长度为n数组中元素的取值范围是0-n-1，所以可以使用一个长度为n的数组array来代替hashSet记录元素是否出现，例如x出现了，将数组array[x]设置为1。
 *
 * 解法二就是将当前数组作为标记数组，每次遍历到下标为i的元素时，将array[array[i]]与当前元素交换，并且将array[array[i]]设置为-1，代表已经这个元素是重复元素，然后i- -，继续遍历交换后的这个元素。
 */
public class Topic49 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers, numbers.length, duplication));
        for (int i : duplication) {
            System.out.println(i);
        }

    }
    public static boolean duplicate(int[] numbers, int length, int [] duplication) {
        if (numbers == null || numbers.length==0) {
            return false;
        }
        for (int i=0;i<numbers.length;i++) {
            int current = numbers[i];
            if (current == -1) {//当前存储的值为-1，说明这个下标之前出现过，但是不重复
                continue;
            }else if (numbers[current] == -1) {//说明有重复的了
                duplication[0] = current;
                return true;
            } else if (current == i) {//等于当前下标，直接标识为-1
                numbers[i]= -1;
            } else {//不等于当前下标，进行交换后，然后标识为-1
                int temp = numbers[current];
                numbers[current] = -1;
                numbers[i] = temp;
                i--;
            }
        }
        return false;
    }
}
