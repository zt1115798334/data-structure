package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 10:21
 * description:
 */
public class Topic4 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(StringBuffer str) {
        int number = 0;//空格数目
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                number++;
            }
        }
        int oldLength = str.length();
        int newLength = str.length() + 2 * number;

        str.setLength(newLength);
        int tempIndex = newLength - 1;//新字符串正在的位置
        for (int i = oldLength - 1; i >= 0; i--) {//遍历
            if (str.charAt(i) != ' ') {
                str.setCharAt(tempIndex, str.charAt(i));
                tempIndex--;
            } else {
                str.setCharAt(tempIndex, '0');
                str.setCharAt(tempIndex - 1, '2');
                str.setCharAt(tempIndex - 2, '%');
                tempIndex = tempIndex - 3;

            }
        }
        return str.toString();
    }
}
