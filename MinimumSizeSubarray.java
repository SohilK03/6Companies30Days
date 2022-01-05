class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        /*
         * two pointer approach
         * similar to product <k question refer that for detailed
         * comments
         * 1 change here is we need minimum length instead of number of sub arrays
         * so everytime we reduce length (left++) we can check
         * whether the curr len is eligible to become
         * min_length or not
         */
        int left = 0, right = 0, s = 0, len = Integer.MAX_VALUE;
        while (right < nums.length) {
            s += nums[right];
            while (left < nums.length && s >= target) {
                len = Math.min(right - left + 1, len);
                s -= nums[left++];
            }
            right++;

        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}