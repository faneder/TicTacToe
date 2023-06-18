import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PlayerTest {

    @Test
    void givenValidMoveWhenMoveCalledThenMarksCellOnce() {
        Board board = mock(Board.class);
        InputProvider input = mock(InputProvider.class);
        when(input.getInput()).thenReturn(1, 1);
        when(board.isValidMove(anyInt(), anyInt())).thenReturn(true);

        Player player = new Player(board, 'X', input);

        player.move();

        verify(board, times(1)).markCell(1, 1, 'X');
    }

    @Test
    void givenMultipleInvalidMovesThenValidWhenMoveCalledThenMarkCellCalledOnce() {
        Board board = mock(Board.class);
        InputProvider inputProvider = mock(InputProvider.class);

        when(inputProvider.getInput()).thenReturn(0, 0, 5, 5, 1, 2);

        when(board.isValidMove(0, 0)).thenReturn(false);
        when(board.isValidMove(5, 5)).thenReturn(false);
        when(board.isValidMove(1, 2)).thenReturn(true);

        Player player = new Player(board, 'X', inputProvider);

        player.move();
        verify(inputProvider, times(6)).getInput();
        verify(board, times(1)).markCell(1, 2, 'X');
    }
}
