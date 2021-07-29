package day1.codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 10:26
 * description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 首先通过开始的判断，来排除链表为空的情况，直接返回空数组，链表不为空，取下一个节点，判断下一个节点是否为空，
 *
 * 不为空，那么递归调用printListFromTailToHead方法来获取后面的节点反序生成的ArrayList，然后添加当前的节点的值，然后返回arrayList。
 * 为空，那么说明当前节点是链表尾部节点，直接创建一个ArrayList，然后添加当前节点的值，然后返回arrayList。
 * 其实原理就是先递归遍历，然后再打印，这样链表打印的顺序就是逆序的了。
 */
public class Topic5 {

    public static void main(String[] args) {

    }
//    ArrayList<Integer> list = new ArrayList<Integer>();
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        if(listNode == null ){
//            return list;
//        }
//        printListFromTailToHead(listNode.next);
//        list.add(listNode.val);
//        return list;
//    }
}
