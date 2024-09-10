class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
                int n=arr.length, m=arr[0].length;
List<Integer> ans=new ArrayList<>();
        int min_r=0, max_r=n-1, min_c=0, max_c=m-1;

      while(min_r<=max_r && min_c<=max_c){

          for (int j=min_c;j<=max_c;j++){
              ans.add(arr[min_r][j]);
          } min_r++;

            if (min_r>max_r || min_c>max_c) break;

          for (int i=min_r;i<=max_r;i++){
              ans.add(arr[i][max_c]);
          } max_c--;

          if (min_r>max_r || min_c>max_c) break;

          for (int j=max_c;j>=min_c;j--) {
              ans.add(arr[max_r][j]);
          } max_r--;

          if (min_r>max_r || min_c>max_c) break;
          
          for (int i=max_r;i>=min_r;i--){
              ans.add(arr[i][min_c]);
          } min_c++;
      }
      return ans;
    }
}
