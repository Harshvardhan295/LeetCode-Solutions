class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<digits.length;i++){ //add key and values
            if(map.containsKey(digits[i])){
                int freq=map.get(digits[i]);
                map.put(digits[i],freq+1);
            }
            else map.put(digits[i],1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        // traverse all three digit even numbers
        for(int i=100;i<=999;i+=2){ 
            int x=i;
            int c=x%10; x=x/10;
            int b=x%10; x=x/10;
            int a=x;
            if(map.containsKey(a)){
                int afreq=map.get(a);
                map.put(a,afreq-1);
                if(afreq==1) map.remove(a);

                if(map.containsKey(b)) {
                    int bfreq = map.get(b);
                    map.put(b, bfreq - 1);
                    if(bfreq==1) map.remove(b);

                    if(map.containsKey(c)) {
                        ans.add(i);
                    }
                    map.put(b,bfreq);

                }
                map.put(a,afreq);
            }
        }
        int arr[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}
