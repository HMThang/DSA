package Lab5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;

    public TicTacToe(char[][] board) {
        this.board = board;
    }

    public TicTacToe() {

    }

    public boolean checkRows() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != EMPTY && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != EMPTY && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        // Check top-left to bottom-right diagonal
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        // Check bottom-left to top-right diagonal
        if (board[2][0] != EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return true;
        }

        return false;
    }

    //task 2.4
    public boolean nxncheckRows() {
        for (int row = 0; row < board.length; row++) {
            if (checkRowForWinner(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowForWinner(int row) {
        char firstCell = board[row][0];
        if (firstCell == EMPTY) {
            return false;
        }
        for (int col = 1; col < board.length; col++) {
            if (board[row][col] != firstCell) {
                return false;
            }
        }
        return true;
    }

    public boolean nxncheckColumns() {
        for (int col = 0; col < board.length; col++) {
            if (checkColumnForWinner(col)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnForWinner(int col) {
        char firstCell = board[0][col];
        if (firstCell == EMPTY) {
            return false;
        }
        for (int row = 1; row < board.length; row++) {
            if (board[row][col] != firstCell) {
                return false;
            }
        }
        return true;
    }

    public boolean nxncheckDiagonals() {
        return checkTopLeftToBottomRightDiagonal() || checkBottomLeftToTopRightDiagonal();
    }

    private boolean checkTopLeftToBottomRightDiagonal() {
        char firstCell = board[0][0];
        if (firstCell == EMPTY) {
            return false;
        }
        for (int i = 1; i < board.length; i++) {
            if (board[i][i] != firstCell) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBottomLeftToTopRightDiagonal() {
        char firstCell = board[board.length - 1][0];
        if (firstCell == EMPTY) {
            return false;
        }
        for (int i = 1; i < board.length; i++) {
            if (board[board.length - 1 - i][i] != firstCell) {
                return false;
            }
        }
        return true;
    }


}
