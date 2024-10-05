class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = (char) (s1.charAt(i) - 'a');
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size();

        int i = 0, j = 0;
        int window = s1.length();
        while (j < s2.length()) {
            char ch = (char) (s2.charAt(j) - 'a');
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1)
                    count--;
                map.put(ch, map.get(ch) - 1);
            }
            if (j - i + 1 < window)
                j++;
            

            else if (j - i + 1 == window) {
                if (count == 0) {
                    return true;
                }

                ch = (char)(s2.charAt(i) - 'a');
                if (map.containsKey(ch)) {
                    if (map.get(ch) == 0)
                        count++;
                    map.put(ch, map.get(ch) + 1);
                }
                i++;
                j++;
            }
        }
        return false;
    }
}