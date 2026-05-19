class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a); //no. of 1s in binary of a
            int countB = Integer.bitCount(b); //no. of 1s in binary of b

            if (countA == countB)
                return a - b; // Tie-breaker: sort by value (ascending)
            return countA - countB; // Sort by bit count (ascending)
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}
