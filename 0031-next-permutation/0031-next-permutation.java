class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // 1. Find the rightmost index where nums[i] < nums[i + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // 2. If such an index exists, find the rightmost element greater than nums[pivot] and swap
        if (pivot != -1) {
            for (int j = n - 1; j > pivot; j--) {
                if (nums[j] > nums[pivot]) {
                    swap(nums, pivot, j);
                    break;
                }
            }
        }

        // 3. Reverse the suffix after pivot (or the entire array if pivot == -1)
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}