// Iterative approach
class Solution {
    public int getLucky(String str, int k) {
        //Convert letters to their alphabet positions
        StringBuilder num = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int n = ch - 'a' + 1;
            num.append(n);
        }

        //Perform the transformation operation k times
        str = num.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char ch : str.toCharArray()) {
                sum += ch - '0';
            }
            str = Integer.toString(sum);
        }
        
        return Integer.parseInt(str);
    }
}
//Recursive approach
class Solution {
    public static int recSuperDigit(long num, int k) {
        if (k <= 0)
            return (int) num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return recSuperDigit(sum, k - 1);
    }

    public int getLucky(String str, int k) {
        //Convert letters to their alphabet positions
        StringBuilder num = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int n = ch - 'a' + 1;
            num.append(n);
        }

        //Perform digit sum transformation
        str = num.toString();
        long sum = 0;
        for (char ch : str.toCharArray()) {
            sum += ch - '0';
        }

        //repeat the transformation operation k times
        return recSuperDigit(sum, k-1);
    }
}
