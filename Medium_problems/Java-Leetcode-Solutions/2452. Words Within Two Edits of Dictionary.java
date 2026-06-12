class Solution {
    public List<String> twoEditWords(String[] q, String[] d) {
        List<String> ans = new ArrayList<>();
        int m = q.length, n = d.length, s = q[0].length();
        for (int i = 0; i < m; i++) {
            String a = q[i];
            for (int j = 0; j < n; j++) {
                String b = d[j];
                int diff = 0;  
                int k = 0;
                while (k < s) {
                    if (a.charAt(k) != b.charAt(k)) {
                        diff++;
                    }
                    if (diff > 2) break;
                    k++;
                }
                if (diff <= 2) {
                    ans.add(a);
                    break;   // avoid duplicate add
                }
            }
        }

        return ans;
    }
}
