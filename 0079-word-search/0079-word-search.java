class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] states = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (generatePaths(0, i, j, board, states, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean generatePaths(int idx, int i, int j, char[][] arr, int[][] states, String str) {

        if (idx == str.length()-1) {
            return true;
        }
        

        states[i][j] = 1;
        if (isValid(idx + 1, i + 1, j, arr, str) && states[i + 1][j] != 1) {
            if (generatePaths(idx + 1, i + 1, j, arr, states, str)) {
                return true;
            }
        }
        if (isValid(idx + 1, i, j + 1, arr, str) && states[i][j + 1] != 1) {
            if (generatePaths(idx + 1, i, j + 1, arr, states, str)) {
                return true;
            }
        }
        if (isValid(idx + 1, i - 1, j, arr, str) && states[i - 1][j] != 1) {
            if (generatePaths(idx + 1, i - 1, j, arr, states, str)) {
                return true;
            }
        }
        if (isValid(idx + 1, i, j - 1, arr, str) && states[i][j - 1] != 1) {
            if (generatePaths(idx + 1, i, j - 1, arr, states, str)) {
                return true;
            }
        }

        states[i][j] = 0;
        return false;

    }

    public static boolean isValid(int idx, int i, int j, char[][] arr, String str) {
        if (idx < str.length()) {
            if (i >= 0 && i < arr.length) {
                if (j >= 0 && j < arr[0].length) {
                    if (str.charAt(idx) == arr[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}