class Solution {
    public int secondsBetweenTimes(String st, String et) {
        String[] s1 = st.split(":");
        String[] s2 = et.split(":");
        
        int s1Seconds = helper(s1);
        int s2Seconds = helper(s2);
        
        return Math.abs(s2Seconds - s1Seconds);
    }
    
    private int helper(String[] str) {
        int hours = Integer.parseInt(str[0]);
        int minutes = Integer.parseInt(str[1]);
        int seconds = Integer.parseInt(str[2]);
        
        return (hours * 3600) + (minutes * 60) + seconds;
    }
}
