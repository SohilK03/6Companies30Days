class Solution {
    public int CountWays(String str) {
        // A table to store results of subproblems
        int n = str.length();
        long[] count = new long[n + 1];
        count[0] = 1;
        count[1] = 1;
        // for base condition "01123" should return 0
        if (str.charAt(0) == '0')
            return 0;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to the number of words
            if (str.charAt(i - 1) > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller than 7,
            // then last two digits form a valid character
            if (str.charAt(i - 2) == '1' ||
                    (str.charAt(i - 2) == '2' && str.charAt(i - 1) < '7'))
                count[i] += count[i - 2];
            count[i] = count[i] % 1000000007;
        }
        return (int) count[n] % 1000000007;
    }
}