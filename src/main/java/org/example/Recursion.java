package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, result, n);

        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result, int n) {

        // Base case: all queens placed
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // 1️⃣ Place queen
                board[row][col] = 'Q';

                // 2️⃣ Recurse
                backtrack(row + 1, board, result, n);

                // 3️⃣ Remove queen (Backtracking step)
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }

        return list;
    }
}
