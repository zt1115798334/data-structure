package day1;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/13 16:51
 * description:
 */
public class LRUDemo {


    public static class ListNode {
        private String key;
        private Integer value;
        private ListNode pre;
        private ListNode next;

        public ListNode(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode head;
    ListNode last;
    int limit = 4;

    Map<String, ListNode> hashMap = Maps.newHashMap();

    public void add(String key, Integer val) {
        ListNode existNode = hashMap.get(key);
        if (existNode != null) {
            //如果存在需要删除元素再把元素放在第一个
            ListNode pre = existNode.pre; //当前元素的上一个元素
            ListNode next = existNode.next; //当前元素的下一个元素
            if (pre != null) {
                pre.next = next;
            }
            if (next != null) {
                next.pre = pre;
            }
            if (last == existNode) {
                last = existNode.pre;
            }
            head.pre = existNode;
            existNode.next = head;
            head = existNode;
            existNode.value = val;

        }else{
            //达到最大的限制 删除最后一个元素
            if (hashMap.size() == limit) {
                ListNode deleteNode = last;
                hashMap.remove(deleteNode.key);
                last = deleteNode.pre;
                deleteNode.pre = null;
                last.next = null;
            }
            ListNode listNode = new ListNode(key, val);
            hashMap.put(key, listNode);
            if (head == null) {
                head = listNode;
                last = listNode;
            }else{
                listNode.next = head;
                head.pre = listNode;
                head = listNode;
            }
        }
    }

    public ListNode get(String key) {
        return hashMap.get(key);
    }

    public void remove(String key) {
        ListNode deleteNode = hashMap.get(key);
        ListNode pre = deleteNode.pre;
        ListNode next = deleteNode.next;
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }
        if (deleteNode == head) {
            head = next;
        }
        if (deleteNode == last) {
            last = pre;
        }
        hashMap.remove(key);
    }
}

