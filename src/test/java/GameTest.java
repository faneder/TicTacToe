import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class GameTest {
    private Game game;
    private Board board;
    private Player playerX;
    private Player playerO;

    @BeforeEach
    void setUp() {
        board = mock(Board.class);
        playerX = mock(Player.class);
        playerO = mock(Player.class);

        game = new Game(board, playerX, playerO);
    }

    @Test
    void whenPlayGameThenPlayerXWins() {
        when(board.hasWinner('X')).thenReturn(true);
        when(playerX.getSymbol()).thenReturn('X');

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.play();

        verify(board, atLeastOnce()).display();
        verify(playerX, atLeastOnce()).move();
        verify(playerO, never()).move();
        verify(board, never()).isFull();
        assertThat(outputStream.toString()).contains("Player X wins!");
    }


    @Test
    void whenPlayGameThenPlayerOWins() {
        when(board.hasWinner('X')).thenReturn(false);
        when(board.hasWinner('O')).thenReturn(true);
        when(playerO.getSymbol()).thenReturn('O');

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.play();

        verify(board, atLeastOnce()).display();
        verify(playerO, atLeastOnce()).move();
        verify(playerX, times(1)).move();
        verify(board, never()).isFull();
        assertThat(outputStream.toString()).contains("Player O wins!");
    }
}
