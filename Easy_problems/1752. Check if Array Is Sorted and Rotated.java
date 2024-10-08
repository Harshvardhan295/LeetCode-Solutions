class Solution {
    public boolean check(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}

// __________________GOOD Method___________________
// class Solution {
//     public boolean check(int[] arr) {
//         int drop = 0;
//         for(int i = 1; i < arr.length; i++){
//             if(arr[i - 1] > arr[i]){
//                 drop++;
//             }
//         }
//         if(arr[0] < arr[arr.length - 1]) drop++;
//         return drop <= 1;
//     }
// }
