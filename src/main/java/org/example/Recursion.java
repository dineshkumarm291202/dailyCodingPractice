package org.example;

public class Recursion {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        // Step 1: trim leading spaces
        s = s.trim();
        if (s.isEmpty()) return 0;

        // Step 2: handle sign
        int sign = 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            s = s.substring(1);
        }

        // Step 3: start recursive digit parsing
        return helper(s, 0, sign, 0);
    }

    // Recursive helper
    private int helper(String s, int index, int sign, int result) {
        // Base case: end of string OR not a digit
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return result * sign;
        }

        int digit = s.charAt(index) - '0';

        // Overflow check BEFORE adding digit
        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Update result
        result = result * 10 + digit;

        // Recursive call with next index
        return helper(s, index + 1, sign, result);
    }
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        long temp = n;

        if (temp < 0) {
            x = 1 / x;
            temp = -temp;
        }

        return power(x, temp);
    }

    private double power(double x, long n) {
        if (n == 0) return 1;

        double half = power(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }
}
