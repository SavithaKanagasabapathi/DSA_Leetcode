class Solution {
    public String multiply(String num1, String num2) {
        //TC-O(M.N) and SC-O(M+N)
        if (num1 == "0" || num2 == "0") {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];//if 11*11=121, extra leading 0, so 4 digits
        for (int i = m - 1; i >= 0; i--) {//right to left
            for (int j = n - 1; j >= 0; j--) {//i multiplies with all j
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //if directly multiplied, ascii value will get multiplied, so -'0'
                int quotient = i + j, remainder = i + j + 1;
                //remainder last in result array(ones), quotient is tens place, next loop it moves left
                int sum = multiply + result[remainder];//carryover
                //quotient needs to be added technically but in next loop, it moves left 
                //so remainder position becomes quotient position
                result[remainder] = sum % 10;
                result[quotient] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            if (!(sb.length() == 0 && res == 0)) {
                //leading zeros not allowed, so if length-0 and res-0, skip
                sb.append(res);//if length=0 and no leading zero, !(true&&false)=!false=true
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}