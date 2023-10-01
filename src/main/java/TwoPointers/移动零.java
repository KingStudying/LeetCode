package TwoPointers;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class 移动零 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0;i < nums.length - 1;i++) {
            for (int j = i+1; j< nums.length;j++) {
                if (nums[i] == 0 && nums[j] !=0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    //双指针
    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] !=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    //双指针优化
    public static void moveZeroes2(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
