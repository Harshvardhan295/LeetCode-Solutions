//method 1
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> l=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
           l.add(String.valueOf(i));
        }

        Collections.sort(l ,(a, b) -> a.compareTo(b));
        List<Integer> intList = l.stream()
                                .map(Integer::parseInt) // or Integer::valueOf
                              .collect(Collectors.toList());
        return intList;
    }
}
//method 2
import java.util.*;
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            result.add(count);
            if (count * 10 <= n) {
                count *= 10;
            } else {
                if (count >= n) count /= 10;
                count++;
                while (count % 10 == 0) {
                    count /= 10;
                }
            }
        }
        return result;
    }
}
