class Solution {
    public double angleClock(int hour, int minutes) {
        //Solution Approach
        // 1 hour=30 degrees
        // so, to calculate hourdegree= (hour%12)*30;
        // 1 minute= 6 degrees
        // so, to calculate mindegree= min * 6

        // but the hour hand moves based on how many minutes hand passed
        // 60 min or 1 hour = 30 degrees
        // 1 min = 30/60 == 1/2 degree
        // m min = 1/2 * m degrees

        double hourdegree= (hour%12) * 30 +(0.5)*minutes;
        double minutesdegree=minutes*6;
        double diff=Math.abs(hourdegree-minutesdegree);
        return Math.min(diff,360-diff);
    }
}
