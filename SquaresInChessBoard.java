class Solution {
    static Long squaresInChessBoard(Long N) {
        // code here
        if (N == 1)
            return (long) 1;
        return (N * N) + squaresInChessBoard(N - 1);
    }
};