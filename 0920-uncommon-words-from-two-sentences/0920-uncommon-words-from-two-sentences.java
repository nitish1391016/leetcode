class Solution {
    public String[] uncommonFromSentences(String A, String B) {
         Set<String> distinct = new HashSet<>(), com = new HashSet<>();
        for (String s : (A + " " + B).split("\\s")) {
            if (com.contains(s) || !distinct.add(s)) { 
                distinct.remove(s); com.add(s); 
            }
        }
        return distinct.toArray(new String[0]);
    }
}