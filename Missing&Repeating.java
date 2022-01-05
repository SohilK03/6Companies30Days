class Solve {
    /*
     * My original approach was to
     * create two equations from sum (1,2,3....N-x+y) and
     * sum (1^2,2^2,3^2,.....N^2-x^2+y^2) [where x & y are missing & repeating]
     * but that was working on interview bit and not working on gfg so I learnt
     * this apporoach from gfg editorial
     */
    int[] findTwoElement(int arr[], int n) {
        // code here
        int i;
        int x = 0;
        int y = 0;
        long s = arr[0];

        int xor1 = arr[0];

        /* Get the xor of all array elements */
        for (i = 1; i < n; i++) {
            s += arr[i];
            xor1 = xor1 ^ arr[i];
        }

        /*
         * XOR the previous result with numbers from
         * 1 to n
         */
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        /* Get the rightmost set bit in set_bit_no */
        int set_bit_no = xor1 & ~(xor1 - 1);

        /*
         * Now divide elements into two sets by comparing
         * rightmost set bit of xor1 with the bit at the same
         * position in each element. Also, get XORs of two
         * sets. The two XORs are the output elements. The
         * following two for loops serve the purpose
         */
        for (i = 0; i < n; i++) {

            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
            else
                /* arr[i] belongs to second set */
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
            else
                /* i belongs to second set */
                y = y ^ i;
        }
        int[] ans = new int[2];
        if ((s - y + x) == (n * (n + 1)) / 2) {
            ans[0] = y;
            ans[1] = x;
        } else {
            ans[0] = x;
            ans[1] = y;
        }
        return ans;

    }
}