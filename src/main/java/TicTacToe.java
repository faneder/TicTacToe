import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] strings) {
        Board board = new Board(3);
        Scanner scanner = new Scanner(System.in);
        InputProvider inputProvider = new ScannerInputProvider(scanner);

        Game game = new Game(board, new Player(board, 'X', inputProvider), new Player(board, 'O', inputProvider));

        game.play();
    }
}
