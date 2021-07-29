package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 11:13
 * description:数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent 。求 base 的 exponent 次方。
 *
 * 思路可以用一个循环，让底数直接相乘，循环次数为整数次方数，这样如果有n次方，复杂度为O(N)，可以
 *
 * 假设f(n)代表x的n次方
 *
 * n为偶数时，
 *
 * f(n)= f(n/2)*f(n/2)
 *
 * n为奇数时，
 *
 * f(n)= f(n/2)*f(n/2) * x
 */
public class Topic11 {
    public static void main(String[] args) {
        double base = 4.5;
        int exp = 3;
        System.out.println(Power(base,exp));

    }
    public static  double Power(double base ,int exponent) {
        if (exponent<0) {
            if (base!=0) {
                return 1/Power(base,-exponent);
            } else {
                //抛出异常
            }
        }
        if (exponent == 0) { return 1;}
        else if (exponent == 1) { return base;}
        double result = Power(base, exponent / 2);
        if ((exponent & 0x1) == 0) {
            return result * result;
        }
        return base * result * result;
    }
}
