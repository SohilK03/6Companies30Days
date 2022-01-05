class Solution {
    /* Function to get the nth ugly number */
    long getNthUglyNo(int n) {
        // code here
        // this array contains ith ugly number at ith position
        /*
         * Point to remember
         * numbers which have prime factors 2,3, or 5 are actually
         * multiples of 2,3 or 5 or all of them
         * so we calculate multiples of 2,3 & 5 and assign minimum to the ith
         * ugly number.
         */
        int[] ug = new int[n];
        ug[0] = 1;
        int c2 = 1, c3 = 1, c5 = 1;
        for (int i = 1; i < n; i++) {
            // get minimum
            int next = Math.min(c2 * 2, Math.min(c3 * 3, c5 * 5));
            ug[i] = next;
            // increase the counter on the basis of minimum
            /*
             * All conditions are if and not if else because there is possibility
             * that a number is multiple of 2 or more of {2,3,5}
             * so all them must be increased otherwise that number will be
             * twice or thrice times there in the array
             */
            if (next == c2 * 2)
                c2++;
            if (next == c3 * 3)
                c3++;
            if (next == c5 * 5)
                c5++;

        }
        // Return the last element of array for nth ugly number
        return ug[n - 1];
    }
}