// 26. Remove Duplicates from Sorted Array leetcode.
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k.

public class RemoveDuplicates {
    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int p = 0; // currnt pointer
        int count = 0; // element count..
        int prevE = -101; // we are taking outside of the range as given constraints, as we have not seen
                          // the prev unique elemnet.
        for (; p < nums.length; p++) {
            int currentE = nums[p]; // 1-->2
            if (currentE != prevE) {
                nums[count] = currentE; // inside nums count in same array --> {0,1,2,3,4}
                count++; // 1->2->3->4->5
                prevE = currentE; // -101 --> 0 ->1 ->2->3->4
                System.out.println("k: " + count);
                System.out.println("prev : " + prevE);

            }
        }
        return count;

    }

}
