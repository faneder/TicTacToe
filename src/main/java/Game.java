public class Game {
    private final Board board;
    private final Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game(Board board, Player playerX, Player playerO) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        currentPlayer = playerX;
    }

    public void play() {
        boolean gameFinished = false;

        while (!gameFinished) {
            currentPlayer.move();

            if (board.hasWinner(currentPlayer.getSymbol())) {
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                board.display();
                gameFinished = true;
            }

            currentPlayer = currentPlayer == playerX ? playerO : playerX;
        }
    }
}
