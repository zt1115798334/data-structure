package day1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/11
 * description: 环形队列 该设计里面包含一个空置
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
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


class CircleArrayQueue {
    private final int maxSize; //arr最大容量
    private final int[] arr; //集合
    private int front; //队头当前第一个元素位置
    private int rear; //队尾 数组中最后一个元素后一个位置

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = num;
        //rear后移
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //最终有效数据个数为 （rear+maxSize-front)%maxSize
        //从front开始遍历 遍历
        for (int i = front; i < front + effectiveCount(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int effectiveCount() {
        return (rear + maxSize - front) % maxSize;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
