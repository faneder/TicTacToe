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
        int row = inputProvider.getInput() - 1;
        int col = inputProvider.getInput() - 1;
        board.markCell(row, col, symbol);
    }
}
