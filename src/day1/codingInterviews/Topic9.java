package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 11:04
 * description:大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */
public class Topic9 {

    int Fibonacci(int n) {
        if (n == 0){
            return 0;
        } else if (n==1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
