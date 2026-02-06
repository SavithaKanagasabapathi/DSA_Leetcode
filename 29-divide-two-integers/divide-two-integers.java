class Solution {
    //TC-O(logn) and SC-O(1), as divident is reducing by 2 every loop so log2n
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        //true^true=false(-^-=+)
        //false^false=false(+^+=+)
        //true^false=true(-^+ or +^- = -true)
        long dividendAbs = Math.abs((long) dividend);//-ve to +ve 
        long divisorAbs = Math.abs((long) divisor);
        //in abs -ve change to +ve, will overflow int, so changing to long
        int quotient = 0;
        while (dividendAbs >= divisorAbs) {
            long tempDivisor = divisorAbs;
            int multiple = 1;
            while (dividendAbs >= tempDivisor << 1) {
                tempDivisor <<= 1;//if divisor=3, 3*2=6
                multiple <<= 1;//multiple=2
                //again, 6*2=12 and multiple become 4 as 2*2
            }
            dividendAbs -= tempDivisor;//10-6=4
            quotient += multiple;
            //If divident is 10 and divisor is 3
            //10-6(3*2)=4, multiple=2
            //Again 4/3, 3*2=6 is greater than 4, so stopped but multiple is 1
            //so return multiple 2+1=3
        }
        return isNegative ? -quotient : quotient;
    }
}