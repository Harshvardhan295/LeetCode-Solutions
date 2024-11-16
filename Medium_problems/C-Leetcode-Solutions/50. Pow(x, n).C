double powHelper(double x, long n) {
    if (n == 0) return 1;
    double half = powHelper(x, n / 2);
    if (n % 2 == 0) {
        return half * half;
    } else {
        return half * half * x;
    }
}

double myPow(double x, int n) {
    if (n == 0) return 1;
    long longN = n;
    if (longN < 0) {
        x = 1 / x;
        longN = -longN;  
        }
    return powHelper(x, longN);
}

