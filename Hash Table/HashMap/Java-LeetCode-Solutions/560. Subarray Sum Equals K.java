//PrefixSum and HashMaps
class Solution {
     public int subarraySum(int[] arr, int k) {
        int count=0,n=arr.length;
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        HashMap<Integer,Integer> maps=new HashMap<>();
        for(int i=0;i<n;i++){
            if(arr[i]==k) count++;
            if(maps.containsKey(arr[i]-k)) count+=maps.get(arr[i]-k);
            maps.put(arr[i],maps.getOrDefault(arr[i],0)+1);
        }
        return count;
    }
}

//Brute Force
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
}

