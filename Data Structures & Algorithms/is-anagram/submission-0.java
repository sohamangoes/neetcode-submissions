class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Integer> occurences = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            occurences.compute(sChar, (k, v) -> (v == null) ? 1 : v + 1);

            char tChar = t.charAt(i);
            occurences.compute(tChar, (k,v) -> (v == null) ? -1: v - 1);

        }

        boolean allZeroes = true;
        for(int value: occurences.values()) {
            if(value != 0) {
                allZeroes = false;
                break;
            }
        }

        return allZeroes;
    }
}
