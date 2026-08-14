class Solution {
    public boolean[] transformStr(String src, String[] strs) {
        int n = src.length();
        //Prefix count of 1's in source string
        int[] sourcePrefix = new int[n];
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (src.charAt(i) == '1') {
                totalOnes++;
            }
            sourcePrefix[i] = totalOnes;
        }

        boolean[] ans = new boolean[strs.length];

        // check if we can transform each string in strs
        for (int idx = 0; idx < strs.length; idx++) {
            char[] arr = strs[idx].toCharArray();
            int fixedOnes = 0;
            int questions = 0;
            // count number of ones in each string in strs
            for (char ch : arr) {
                if (ch == '1') {
                    fixedOnes++;
                } else if (ch == '?') {
                    questions++;
                }
            }
            // if total ones in string of strs is greater than the total ones in src or total ones in string of strs is greater than the total ones in src + the questions , then its impossible
            if (totalOnes < fixedOnes || totalOnes > fixedOnes + questions) {
                ans[idx] = false;
                continue;
            }

            // check req ones
            int need = totalOnes - fixedOnes;

            // starting from the last update ? to ones till req is not zero
            for (int i = n - 1; i >= 0 && need > 0; i--) {
                if (strs[idx].charAt(i) == '?') {
                    arr[i] = '1';
                    need--;
                }
            }

            // transform rest ? to 0
            for (int i = 0; i < n; i++) {
                if (arr[i] == '?') {
                    arr[i] = 0;
                }
            }

            // Prefix validation check
            int preOnes = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    preOnes++;
                }
                if (preOnes > sourcePrefix[i]) {
                    possible = false;
                }
            }

            ans[idx] = possible;
        }
        return ans;
    }
}
