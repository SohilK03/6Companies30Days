import java.util.*;

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        /*
         * map which stores the remainders as key
         * and their frequencies as values
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        // +k % k has been done to convert negative remainders to positive
        for (int n : nums) {
            int rem = (n % k + k) % k;
            if (!map.containsKey(rem))
                map.put(rem, 1);
            else
                map.put(rem, map.get(rem) + 1);
        }
        /*
         * if rem is 0 or rem is half of k then occurance
         * should be even other wise pairing is not possible
         * and otherwise the rem and k-rem should be equal
         * because number with remainder r will form a pair with
         * k-r so that the net remainder is 0 and pair is divisible
         * in case of 0 and half the number will have to make pair with it
         * self so there should be even occurances of that number
         */
        for (int n : nums) {
            int rem = (n % k + k) % k;
            if (rem == 0 || rem * 2 == k) {
                if (map.get(rem) % 2 == 1)
                    return false;
            } else if (map.get(rem) != map.get(k - rem))
                return false;
        }
        return true;
    }
}