public class Board {
    private char[][] cells;
    private final int size;

    public Board(int size) {
        this.size = size;
        cells = new char[size][size];
        initialize();
    }

    public void initialize() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cells[row][col] = ' ';
            }
        }
    }

    public char getCell(int row, int col) {
        return cells[row][col];
    }

    public void markCell(int row, int col, char mark) {
        cells[row][col] = mark;
    }

    public boolean isValidMove(int row, int col) {
        return isInsideBoard(row) && isInsideBoard(col) && cells[row][col] == ' ';
    }

    private boolean isInsideBoard(int value) {
        return value >= 0 && value < 3;
    }

    public boolean hasWinner(char symbol) {
        for (int row = 0; row < 3; row++) {
            if (cells[row][0] == symbol && cells[row][1] == symbol && cells[row][2] == symbol) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (cells[0][col] == symbol && cells[1][col] == symbol && cells[2][col] == symbol) {
                return true;
            }
        }

        if (cells[0][0] == symbol && cells[1][1] == symbol && cells[2][2] == symbol) {
            return true;
        }

        if (cells[0][2] == symbol && cells[1][1] == symbol && cells[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public void display() {
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cells[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
