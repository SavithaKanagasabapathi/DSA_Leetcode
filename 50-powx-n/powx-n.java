class Solution {
    //TC-O(logn) and SC-O(logn) for divide and conquer, sc for recursion stack
    //x^n, it takes n times, so divide n by n/2 and multiply that answer twice
    //if n is odd, n/2*n/2*n, if even, n/2*n/2
    //if n is negative, negate n and make x to 1/x, which is same as x^-n=1/x^n
    public double myPow(double x, int n) {
        long bigN = n;
        if (n < 0) {
            x = 1 / x;
            bigN = -n;//if -(minvalue)=greter than int max value, so long
        }
        return divideAndConquerPow(x, bigN);
    }

    //recursion - O(logn)
    private double divideAndConquerPow(double x, long n) {
        if (n == 0) {
            return 1.0;//if not given, stackoverflow
        }
        double temp = divideAndConquerPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    //iterative - O(1)
    // private double divideAndConquerPow(double x, long n) {
    //     if (n == 0) {
    //         return 1.0;//if not given, stackoverflow
    //     }
    //     double result = 1;
    //     double currentX = x;
    //     for (long i = n; i > 0; i /= 2) {
    //         if (i % 2 == 1) {
    //             result *= currentX;
    //         }
    //         currentX *= currentX;
    //     }
    //     return result;
    // }
}