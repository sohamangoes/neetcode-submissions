class Solution {
    public boolean isValidSudoku(char[][] board) {
        final char EMPTY = '.';
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {

            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != EMPTY) {
                    if (!rowSet.add(board[i][j]))
                        return false;

                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (boxes[boxIndex] != null) {
                        Set<Character> box = boxes[boxIndex];
                        if (!box.add(board[i][j]))
                            return false;
                    } else {
                        boxes[boxIndex] = new HashSet<>(Set.of(board[i][j]));
                    }
                }

                if (board[j][i] != EMPTY) {
                    if (!colSet.add(board[j][i]))
                        return false;
                }
            }

        }

        return true;
    }
}
