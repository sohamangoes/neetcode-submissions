class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<List<Integer>, List<String>> frequencyMap = new HashMap<>();

        for(String str: strs) {
            List<Integer> cf = charFrequencies(str);
            frequencyMap.merge(cf, new ArrayList<String>(Arrays.asList(str)), (oldV, newV) -> {
                oldV.addAll(newV);
                return oldV;
            });
        }

        return frequencyMap.values().stream().collect(Collectors.toList());
    }

    private List<Integer> charFrequencies(String str) {

        List<Integer> result = IntStream
            .range(0, 26).mapToObj(i -> (Integer)null)
            .collect(Collectors.toList());

        for(int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            int charIndex = (int)ch - 97;

            if(result.get(charIndex) == null) {
                result.set(charIndex, 0);
            }
            result.set(charIndex, result.get(charIndex) + 1);
        }

        return result;
    }
}
