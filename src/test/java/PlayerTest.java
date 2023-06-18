import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PlayerTest {
  private Board board;
  private InputProvider input;
  private Player playerX;

  @BeforeEach
  void setUp() {
    board = mock(Board.class);
    input = mock(InputProvider.class);
    playerX = new Player(board, 'X', input);
  }

  @Test
  void givenValidMoveWhenMoveCalledThenMarksCellOnce() {
    when(input.getInput()).thenReturn(1);
    when(board.isValidMove(anyInt(), anyInt())).thenReturn(true);

    playerX.move();

    verify(board, times(1)).markCell(1, 1, 'X');
  }

  @Test
  void givenMultipleInvalidMovesThenValidWhenMoveCalledThenMarkCellCalledOnce() {
    when(input.getInput()).thenReturn(0, 0, 5, 5, 1, 2);
    when(board.isValidMove(0, 0)).thenReturn(false);
    when(board.isValidMove(5, 5)).thenReturn(false);
    when(board.isValidMove(1, 2)).thenReturn(true);

    playerX.move();

    verify(input, times(6)).getInput();
    verify(board, times(1)).markCell(1, 2, 'X');
  }
}
