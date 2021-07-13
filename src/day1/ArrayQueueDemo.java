package day1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/11
 * description: 队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        final Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("a(add): 添加元素到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看头部数据");
            key = scanner.next();
            switch (key) {
                case "s":
                    try {
                        queue.show();
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    break;
                case "e":
                    loop = false;
                    break;
                case "a":
                    try {
                        System.out.println("输入一个数组");
                        final int i = scanner.nextInt();
                        queue.add(i);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }

                    break;
                case "g":
                    try {
                        final int i1 = queue.get();
                        System.out.println("获取数据为：" + i1);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    break;
                case "h":
                    try {
                        System.out.println("检查头部元素为：" + queue.peek());
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
    }

}

class ArrayQueue {
    private final int maxSize; //arr最大容量
    private final int[] arr; //集合
    private int front; //队头当前第一个元素前一个位置
    private int rear; //队尾 数组中最后一个元素位置

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        rear++;
        arr[rear] = num;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}

