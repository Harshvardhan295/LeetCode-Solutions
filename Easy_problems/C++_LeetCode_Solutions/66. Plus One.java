class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;  
        }
        // If loop completes, all digits were 9 (e.g., 999 -> 000)
        // Add a new digit '1' at the beginning
        digits.insert(digits.begin(), 1);
        return digits;
    }
};
