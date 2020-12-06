package com.jarvi;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZero {

    /**
     * 双指针，一个指针用于遍历元素，另外一个指针记录 O 元素的下标
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums 待处理数组
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * 最开始想到的方法，思路来自冒泡排序，但是只把等于0的元素往后面冒。
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * @param nums 待处理数组
     */
    public void moveZeroes2(int[] nums) {
         for(int i = nums.length - 1; i >= 0; i--) {
             if (nums[i] == 0) {
                 for (int j = i; j < nums.length - 1; j++) {
                     int temp = nums[j];
                     nums[j] = nums[j + 1];
                     nums[j + 1] = temp;
                 }
             }
         }
    }

    public static void main(String[] args) {
        MoveZero solution = new MoveZero();
        int[] nums = {0,1,0,3,12};
        long begin = System.currentTimeMillis();
        solution.moveZeroes(nums);
        System.out.println("time cost (ms) :" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {19,0,0,1,8,0,3,12};
        begin = System.currentTimeMillis();
        solution.moveZeroes2(nums2);
        System.out.println("time cost (ms) :" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(nums2));

    }

}
