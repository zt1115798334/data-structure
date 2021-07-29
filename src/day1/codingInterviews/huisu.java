package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/28 17:16
 * description:
 */
public class huisu {
    private static int[] array = {1,2,3,4};
    private static int length = array.length;
    private static int[] temp = new int[length];

    public static void main(String[] args) {
        all_subset("all");
        System.out.println();
//        all_subset("num");
//        System.out.println();
//        all_subset("sp");

    }
    /**
     * 输出集合的子集
     * @param limit  决定选出特定条件的子集
     * 注：all为所有子集,num为限定元素数量的子集,
     *    sp为限定元素奇偶性相同，且和小于8。
     */
    public static void all_subset(String limit){
        switch(limit){
            case "all":backtrack(0);break;
            case "num":backtrack1(0);break;
            case "sp":backtrack2(0);break;
        }
    }


    /**
     * 回溯法求集合的所有子集，依次递归
     * 注：是否回溯的条件为精髓
     * @param t
     */
    private static void backtrack(int t){
        if(t >= length)
            output(temp);
        else
            for (int i = 0; i <= 1; i++) {
                temp[t] = i;
                backtrack(t+1);
            }

    }

    /**
     * 回溯法求集合的所有(元素个数小于4)的子集，依次递归
     * @param t
     */
    private static void backtrack1(int t){
        if(t >= length)
            output(temp);
        else
            for (int i = 0; i <= 1; i++) {
                temp[t] = i;
                if(count(temp, t) < 4)
                    backtrack1(t+1);
            }

    }

    /**
     * (剪枝)
     * 限制条件：子集元素小于4,判断0~t之间已被选中的元素个数，
     *        因为此时t之后的元素还未被递归,即决定之后的元素
     *        是否应该被递归调用
     * @param x
     * @param t
     * @return
     */
    private static int count(int[] x, int t) {
        int num = 0;
        for (int i = 0; i <= t; i++) {
            if(x[i] == 1){
                num++;
            }
        }
        return num;
    }

    /**
     * 回溯法求集合中元素奇偶性相同，且和小于8的子集,依次递归
     * @param t
     */
    private static void backtrack2(int t){
        if(t >= length)
            output(temp);
        else
            for (int i = 0; i <= 1; i++) {
                temp[t] = i;
                if(legal(temp, t))
                    backtrack2(t+1);
            }

    }

    /**
     * 对子集中元素奇偶性进行判断，还需元素的数组和小于8
     * @param x
     * @param t
     * @return
     */
    private static boolean legal(int[] x, int t) {
        boolean bRet = true;   //判断是否需要剪枝
        int part = 0;  //奇偶性判断的基准

        for (int i = 0; i <= t; i++) {  //选择第一个元素作为奇偶性判断的基准
            if(x[i] == 1){
                part = i;
                break;
            }
        }

        for (int i = 0; i <= t; i++) {
            if(x[i] == 1){
                bRet &= ((array[part] - array[i]) % 2 == 0);
            }

        }

        int sum = 0;
        for(int i = 0; i <= t; i++){
            if(x[i] == 1)
                sum += array[i];
        }
        bRet &= (sum < 8);

        return bRet;
    }


    /**
     * 子集输出函数
     * @param temp
     */
    private static void output(int[] temp) {
        for (int i : temp) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == 1){
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }
}
