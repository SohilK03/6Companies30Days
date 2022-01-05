import java.util.*;

class Solution {
    static String printMinNumberForPattern(String S) {
        // code here
        String ans = "";
        /*
         * Maintain a Stack of integers (start with curr=1)
         * if D is encountered :
         * --> add to stack
         * --> increment curr
         * else :
         * --> add to stack
         * --> increment
         * --> pop all from stack and add to ans
         * 
         * Why Stack ?
         * if you closely see then the answer of D's are nothing
         * but reverese of I's
         * Eg . III ==> 1234
         * DDD ==> 4321
         * thus considering D's as I's and adding the answer to stack
         * instead of result will make the answer reveresed
         * thus helping in achieving the task
         */
        Stack<Integer> st = new Stack<>();
        int curr = 1;
        for (char a : S.toCharArray()) {

            if (a == 'D') {
                st.push(curr);
                curr++;
            } else {
                st.push(curr);
                curr++;
                while (!st.isEmpty())
                    ans += Integer.toString(st.pop());
            }
        }
        st.push(curr);
        while (!st.isEmpty())
            ans += Integer.toString(st.pop());

        return ans;
    }
}