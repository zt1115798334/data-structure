package day1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/11
 * description: 稀疏数组 （第一行存储的行列和有效数据格式，下面每一列存储有效数据的行值 列值 有效值）
 * 二维数组转稀疏数据思路
 * 1.遍历原始二维数组，获得有效数据个数 sum
 * 2.遍历sum就可以创建稀疏数组sparseArr int[sum+1][3]
 * 3.二维数组的有效数据存入到稀疏数据
 * 4.稀疏数组第一行存储原始数组行列
 * <p>
 * 稀疏数组转二维数组
 * 1.先读取稀疏数组的第一行，根据第一行的数据，创建二维数组
 * 2.去读稀疏数组后几行的数据，赋值给二位数
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[2][3] = 1;
        arr[3][5] = 2;
        printArr(arr);

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int num = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = arr[i][j];
                    num++;
                }

            }
        }

        printTxt("D:\\test.txt", sparseArr);
        printArr(sparseArr);

        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        printArr(arr2);
    }


    public static void printArr(int[][] arr) {

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

    public static void printTxt(String pathStr, int[][] arr) {
        Path path = Paths.get(pathStr);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    bufferedWriter.write(anInt + "\t");
                }
                bufferedWriter.write( "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
