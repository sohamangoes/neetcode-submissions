// class Pair {
//     int key;
//     String value;

//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        if(pairs.size() == 0) {
            return List.of();
        }

        if(pairs.size() == 1) {
            return List.of(pairs);
        }

        List<List<Pair>> steps = new ArrayList<>(0);
        steps.add(new ArrayList<>(pairs));

        for(int i = 1; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            int j = i-1;

            while(j >= 0 && pairs.get(j).key > pair.key) {
                pairs.set(j+1, pairs.get(j));
                j--;
            }

            pairs.set(j+1, pair);
            steps.add(new ArrayList<>(pairs));
        }

        return steps;
    }
}
