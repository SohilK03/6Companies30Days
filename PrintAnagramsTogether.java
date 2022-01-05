import java.util.*;

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : string_list) {
            char tempArray[] = s.toCharArray();

            // Sorting temp array using
            Arrays.sort(tempArray);
            String check = new String(tempArray);
            if (map.containsKey(check)) {
                map.get(check).add(s);
            } else {
                map.put(check, new ArrayList<>(List.of(s)));
            }
        }
        for (Map.Entry<String, List<String>> ent : map.entrySet()) {
            ans.add(ent.getValue());
        }
        return ans;
    }
}

/**
 * PrintAnagramsTogether
 */
public class PrintAnagramsTogether {
    public static void main(String[] args) {

        Solution obj = new Solution();
        String[] list = { "act", "god", "cat", "dog", "tac" };
        System.out.println(obj.Anagrams(list));
    }
}