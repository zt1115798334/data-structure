package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/29 10:55
 * description:
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 输入字符串S=”abcXYZdef”,要输出“XYZdefabc”，其实就是将前n个字符移动到字符串末尾，直接移动的话很容易实现，不管是直接使用添加字符串的方法，还是直接使用字符串截取的方法，这里是一种新方法，就是将整个字符串翻转，再将length-n的字符翻转，再将后n个字符翻转，这样得到的也是前n个字符移动到末尾的结果。
 *
 * 原字符串： abcXYZdef
 *
 * 整个字符翻转： fedZYXcba
 *
 * 前length-n个字符翻转： XYZdefcba
 *
 * 后n个字符翻转得到最终结果：XYZdefabc
 */
public class Topic42 {
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }
    public static String LeftRotateString(String str,int n) {
        if (str==null|| str.length()==0 || str.length()<n) {
            return str;
        }

        str = reverse(str,0,n-1);
        str = reverse(str, n,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
    }

    public static  String reverse(String str, int start, int end) {
        if (start>=end) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = start,j = end; i < j; i++,j--) {
            char temp = stringBuffer.charAt(i);
            stringBuffer.setCharAt(i, stringBuffer.charAt(j));
            stringBuffer.setCharAt(j, temp);
        }
        return stringBuffer.toString();
    }
}
