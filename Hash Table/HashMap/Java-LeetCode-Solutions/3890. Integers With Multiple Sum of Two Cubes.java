class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int a = 1;

        while ((int)Math.pow(a, 3) <= n) {
            int b = a; // avoid duplicates

            while ((int)Math.pow(a, 3) + (int)Math.pow(b, 3) <= n) {
                int sum = (int)Math.pow(a, 3) + (int)Math.pow(b, 3);
                mp.put(sum, mp.getOrDefault(sum, 0) + 1);
                b++;
            }
            a++;
        }
        for (int sum : mp.keySet()) {
            if (mp.get(sum) >= 2) {
                arr.add(sum);
            }
        }

        Collections.sort(arr);
        return arr;
    }
}
