import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PlayerTest {

    @Test
    void GivenAPlayerWhenMovesThenCallsBoardMarkCell() {
        Board board = mock(Board.class);
        InputProvider input = mock(InputProvider.class);
        when(input.getInput()).thenReturn(1).thenReturn(1);

        Player player = new Player(board, 'X', input);

        player.move();

        verify(board).markCell(0, 0, 'X');
    }
}
