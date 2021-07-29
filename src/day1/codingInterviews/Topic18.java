package day1.codingInterviews;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/28 16:40
 * description:
 */
public class Topic18 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        int r = 0;
        int c = 0;
        for (int i = 1; i <= 16; i++) {
            array[r][c] = i;
            if (i  % 4 == 0) {
                r++;
                c = 0;
            } else {
                c++;
            }
        }
        System.out.println("array = " + array);

        Topic18 topic18 = new Topic18();
        ArrayList<Integer> integers = topic18.printMatrix(array);
        integers.forEach(System.out::println);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        return printMatrix(arrayList, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    public ArrayList<Integer> printMatrix(ArrayList<Integer> arrayList, int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return arrayList;
        }
        for (int i = colStart; i <= colEnd; i++) {
            arrayList.add(matrix[rowStart][i]);
        }
        for (int i = rowStart + 1; i <= rowEnd - 1; i++) {
            arrayList.add(matrix[i][colEnd]);
        }
        for (int i = colEnd; i >= colStart && rowEnd > rowStart; i--) {//要加rowEnd>rowStart判断，不然对于单行情况会重复打印
            arrayList.add(matrix[rowEnd][i]);
        }
        for (int i = rowEnd - 1; i >= rowStart + 1 && colStart < colEnd; i--) {//要加rowEnd>rowStart判断，不然对于单列情况会重复打印
            arrayList.add(matrix[i][colStart]);
        }
        printMatrix(arrayList, matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
        return arrayList;
    }
}
