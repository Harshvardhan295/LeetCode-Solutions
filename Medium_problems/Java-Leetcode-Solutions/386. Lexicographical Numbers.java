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
