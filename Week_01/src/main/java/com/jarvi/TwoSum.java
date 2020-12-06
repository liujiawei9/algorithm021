package com.jarvi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    /**
     * 缓存优化法（一次循环），别人的优秀题解，妙啊。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums   传入数组
     * @param target 寻找的目标值
     * @return int[] , 符合条件的元素的下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 缓存优化法（两次循环）
     * 使用 hash 存下数据 (value,index)，
     * 遍历数组，用 hash.get(target - nums[i]),若存在，则获取 value。
     * 而 [i,value] 即为答案。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums   传入数组
     * @param target 寻找的目标值
     * @return int[] , 符合条件的元素的下标
     */
    public int[] twoSum2(int[] nums, int target) {
        //两种方法，
        //方法一：常规遍历，时间复杂度 log(n^2)，空间复杂度log(1)
        //方法二：
        //方法二的时间复杂度为O(n),空间复杂度O(n);
        // target = i + j
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Integer j;
        for (int i = 0; i < nums.length; i++) {
            j = map.get(target - nums[i]);
            if (j != null && i != j) {
                return new int[]{i, j};
            }
        }
        return new int[0];
    }

    /**
     * 暴力枚举法
     * 两层循环，效率较低，不可取。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums   传入数组
     * @param target 寻找的目标值
     * @return int[] , 符合条件的元素的下标
     */
    public int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum solution = new TwoSum();
        long begin = System.currentTimeMillis();
        int[] result1 = solution.twoSum(nums, 9);
        System.out.println("time cost (ms) :" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(result1));

        begin = System.currentTimeMillis();
        int[] result2 = solution.twoSum2(nums, 9);
        System.out.println("time cost (ms) :" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(result2));

        begin = System.currentTimeMillis();
        int[] result3 = solution.twoSum3(nums, 9);
        System.out.println("time cost (ms) :" + (System.currentTimeMillis() - begin));
        System.out.println(Arrays.toString(result3));
    }

}
