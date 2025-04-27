import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();//for unique elements
        
        for (int j = 0; j < nums2.length; j++) {
            int low = 0, high = nums1.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums1[mid] == nums2[j]) {
                    set.add(nums2[j]);
                    break; // break binary search if found
                } else if (nums1[mid] < nums2[j]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        int[] ans = new int[set.size()];
        int i = 0;
        for (int ele : set) {
            ans[i++] = ele;
        }
        return ans;
    }
}

