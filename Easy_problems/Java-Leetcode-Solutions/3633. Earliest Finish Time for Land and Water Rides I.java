class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int landThenWater = calculateTime(lst, ld, wst, wd);
        int waterThenLand = calculateTime(wst, wd, lst, ld);
        
        return Math.min(landThenWater, waterThenLand);
    }
    
    private int calculateTime(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        int minFirstStageFinish = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minFirstStageFinish = Math.min(minFirstStageFinish, start1[i] + dur1[i]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < start2.length; j++) {
            int a = Math.max(minFirstStageFinish, start2[j]) + dur2[j];
            min = Math.min(min, a);
        }
        
        return min;
    }
}
