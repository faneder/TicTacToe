public class Player {
    private final Board board;
    private final char symbol;
    private final InputProvider inputProvider;

    public Player(Board board, char symbol, InputProvider inputProvider) {
        this.board = board;
        this.symbol = symbol;
        this.inputProvider = inputProvider;
    }

    public void move() {
        int row;
        int col;

        do {
            System.out.print("Player " + symbol + ": enter your move (row [0-2] and column [0-2]): ");
            row = inputProvider.getInput();
            col = inputProvider.getInput();
        } while (!board.isValidMove(row, col));

        board.markCell(row, col, symbol);
    }

    public char getSymbol() {
        return ' ';
    }
}
