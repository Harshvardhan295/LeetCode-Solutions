//O(n*n)
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int shipWeight=0, count=0;
        
        for(int i=0;i<n*n;i++){
            shipWeight+=w;
            if(shipWeight<=maxWeight)count++;
            else break;
        }
        return count;
    }
}
//Math
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int maxContainers = maxWeight / w;
        int decksize = n * n;
        return maxContainers > decksize ? decksize : maxContainers;
    }
}
