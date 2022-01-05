class Solution {

    public int countSubArrayProductLessThanK(long a[], long n, long k) {
        // Two pointer Approach
        int start = 0, end = 0;
        /*
         * Product is set to long beacuse product
         * value can increase Integer.MAX_VALUE
         */
        long p = 1;
        int ans = 0;
        // runn loop till left pointer reaches the end
        while (end < n) {
            // Multiply curr element with product
            p *= a[end];
            /*
             * if after multiplication p becomes greater than or
             * equal to k then keep dividing to get the minimum size
             */
            while (start < end && p >= k)
                p /= a[start++];
            /*
             * this minimum size array can create n subarrays where
             * n=length of subarray if the subarray was already
             * minimum then its contribution to answer will also be n
             * Eg. arr=[1,2,3,4] k=10
             * at index 3
             * ans=3 and p=6
             * since p is less than 6 so ans will add upto 6
             * Why ?
             * --> num of subarrays with [1,2]=3 {[1],[2],[1,2]}
             * --> if we include 3 in all these then 3 new will form thus 6
             */
            if (p < k)
                ans += 1 + (end - start);
            end++;

        }
        return ans;
    }
}