class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == word.charAt(0) && search(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] b, int i, int j, int c, String w) {
        if(c == w.length()) {
            return true;
        }
        if(i<0 || i>=b.length || j<0 || j>=b[i].length || b[i][j] != w.charAt(c)) {
            return false;
        }
        char x = b[i][j];
        b[i][j] = ' ';
        boolean found = search(b, i+1, j, c+1, w) ||
                        search(b, i-1, j, c+1, w) ||
                        search(b, i, j+1, c+1, w) ||
                        search(b, i, j-1, c+1, w);
        b[i][j] = x;
        return found;
    }
}