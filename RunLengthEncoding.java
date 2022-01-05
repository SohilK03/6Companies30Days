class Solution {
    String encode(String str) {
        // Your code here
        // Get the start char
        char start = str.charAt(0);
        /*
         * set count to 1 beacuse there will be atleast 1
         * of start ans iter to 1 becuase
         * index 0 is computed
         */
        int count = 1, itr = 1;
        String ans = "";
        while (itr < str.length()) {
            // if curr char is equal to start then keep increasing count
            if (str.charAt(itr) == start) {
                count++;
                itr++;
            } else {
                /*
                 * now the occurrence of that char has ended
                 * so add the count and char to ans
                 * and reset start to new char and count to 1
                 */
                ans += start + Integer.toString(count);
                count = 1;
                start = str.charAt(itr);
                itr++;
            }
        }
        ans += start + Integer.toString(count);
        return ans;
    }

}