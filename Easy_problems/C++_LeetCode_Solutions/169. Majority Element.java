class Solution {
public:
    int majorityElement(vector<int>& a) {
        int n=a.size();
        sort(a.begin(), a.end());
        return a[n/2];
    }
};
