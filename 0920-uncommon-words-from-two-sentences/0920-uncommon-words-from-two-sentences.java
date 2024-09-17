class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(String str: arr1)
            map1.put(str, map1.getOrDefault(str, 0)+1);
        for(String str: arr2)
            map2.put(str, map2.getOrDefault(str, 0)+1);


        List<String> res = new ArrayList<>();
        for(var entry : map1.entrySet()){
            String word = entry.getKey();
            int wordFreq = entry.getValue();
            if(wordFreq == 1 && !map2.containsKey(word)){
                 res.add(word);
            }
        }
       
        for(var entry : map2.entrySet()){
            String word = entry.getKey();
            int wordFreq = entry.getValue();
            if(wordFreq == 1 && !map1.containsKey(word)){
                 res.add(word);
            }
        }

        return res.stream().toArray(String[]::new);
    }
}