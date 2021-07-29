package day1.codingInterviews;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2021/7/21 11:18
 * description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解题思路：
 *
 * 如果可以使用额外的内存空间，可以对数组遍历两遍，一遍将奇数取出，存放在额外的数组中去，一遍把剩下的偶数存放到额外的数组中去。
 *
 * 如果不能使用额外的内存空间，就是查找奇数，然后与前面的元素互换，一直到替换到最后一个奇数的后面，有点像是冒泡排序。(因为不能改变相对位置，所以不能用快排)
 *
 * 冒泡排序是其实是交换，从头开始，依次判断两个相邻的元素，将更大的元素向右交换，遍历一次后可以将当前序列最大的元素交换到最后面去，下次遍历就不用管最后一个元素。
 */
public class Topic12 {
}