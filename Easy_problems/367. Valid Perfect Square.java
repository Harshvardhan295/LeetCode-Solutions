//_________________________Method 1__________________________
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        
        long low = 2, high = num / 2, mid, square;
        while (low <= high) {
            mid = low + (high - low) / 2;
            square = mid * mid;
            if (square == num) {
                return true;
            }
            if (square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
//_________________________Method 1__________________________
class Solution {
    public boolean isPerfectSquare(int num) {
        long i = 0;
        if(num == 0 || num == 1)
        {
            return true;
        }
		while(i <= num/2)
		{
			if(i * i < num)
			{
                i++;
				continue;
			}
			else if(i * i == num)
			{
				return true;
			}
			else
			{
				break;
			}
		}
        return false;        
    }
}
