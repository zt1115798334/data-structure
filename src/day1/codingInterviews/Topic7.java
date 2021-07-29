package day1.codingInterviews;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 10:36
 * description:用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为int类型。
 *
 * 思路：因为队列是先进先出，栈是先进后出，一个栈用来进元素，一个栈用来反序，就可以实现队列。用一个栈stack1来进元素，另一个栈stack2来出元素，stack2为空时，将stack1的元素依次出栈，然后依次入栈到stack2，然后从stack2取出栈顶元素。
 */
public class Topic7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(Integer number) {
        stack1.push(number);
    }
    public Integer pop() {
        if (stack2.size()>0) {
            return stack2.pop();
        }else if (stack1.size()>=0) {
            while (stack1.size()>0) {
                Integer temp = stack1.pop();
                stack2.push(temp);
            }
            return stack2.pop();
        }
        return null;
    }
}
