import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

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
    void whenPlayGameThenSwitchPlayers() {
        when(board.hasWinner(anyChar())).thenReturn(false);
        when(board.isFull()).thenReturn(false, false, true);

        game.play();

        InOrder inOrder = inOrder(playerX, playerO, playerX);
        inOrder.verify(playerX).move();
        inOrder.verify(playerO).move();
        inOrder.verify(playerX).move();
    }

    @Test
    void whenPlayGameThenPlayerXWins() {
        when(board.hasWinner('X')).thenReturn(true);
        when(playerX.getSymbol()).thenReturn('X');

        game.play();

        verify(board, atLeastOnce()).display();
        verify(playerX, atLeastOnce()).move();
        verify(playerO, never()).move();
        verify(board, never()).isFull();
        assertThat(getOutputFromStream()).contains("Player X wins!");
    }

    @Test
    void whenPlayGameThenPlayerOWins() {
        when(board.hasWinner('X')).thenReturn(false);
        when(board.hasWinner('O')).thenReturn(true);
        when(playerO.getSymbol()).thenReturn('O');

        game.play();

        verify(board, atLeastOnce()).display();
        verify(playerO, atLeastOnce()).move();
        verify(playerX, times(1)).move();
        verify(board, times(1)).isFull();
        assertThat(getOutputFromStream()).contains("Player O wins!");
    }

    @Test
    void whenNeitherOfPlayersWinsThenGameInADraw() {
        when(board.hasWinner(anyChar())).thenReturn(false);
        when(board.isFull()).thenReturn(true);

        game.play();

        verify(board, times(1)).display();
        verify(playerX, times(1)).move();
        verify(board, times(1)).hasWinner(anyChar());
        verify(playerO, never()).move();
        verify(board, times(1)).isFull();
    }

    private String getOutputFromStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        return outputStream.toString();
    }
}
