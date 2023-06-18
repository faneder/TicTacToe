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
}
