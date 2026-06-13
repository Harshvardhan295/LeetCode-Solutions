class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0;
        if(ruleKey.equals("type")){
            for(List<String> list:items){
                if(ruleValue.equals(list.get(0))) ans++;
            }
        }
        else if(ruleKey.equals("color")){
            for(List<String> list:items){
                if(ruleValue.equals(list.get(1))) ans++;
            }
        }
        else{
            for(List<String> list:items){
                if(ruleValue.equals(list.get(2))) ans++;
            }
        }
        return ans;
    }
}
