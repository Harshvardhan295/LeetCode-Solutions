class Solution {
    public int furthestDistanceFromOrigin(String moves) {
         int x = 0,z=0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') x++;
            else if (c == 'R') x--;
            else z++;
        }
        return (x>0)? x+z: -x+z;
    }
}
