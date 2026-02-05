class Solution {
    //TC-O(1) and SC-O(1), atmost 32 loops as 31 bits
    //1&1=1 but it is 2 so it has to be 11, but it s giving only carry 
    //that carry has to be in next left place else it will modify ones place, so <<1
    //1^1=0, 2=10, so it is giving sum without carry
    //if a=2, b=3 - 10+11
    //10^11=01
    //(10&11)=10<<1=100
    //do same until carry becomes zero, return sumWithoutCarry
    public int getSum(int a, int b) {
        while (b != 0) {
            int sumWithoutCarry = a ^ b;
            int carry = (a & b) << 1;//wrap a&b in brackets else it will with <<1 first and give error
            a = sumWithoutCarry;
            b = carry;
        }
        return a;
    }
}