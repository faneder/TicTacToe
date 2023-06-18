import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(3);
    }

    @Test
    void initializeEmptyThreeByThreeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertThat(board.getCell(row, col)).isEqualTo(' ');
            }
        }
    }

    @Test
    void isValidMove() {
        board.markCell(1, 1, 'O');

        assertThat(board.isValidMove(0, 0)).isTrue();
        assertThat(board.isValidMove(1, 1)).isFalse();
        assertThat(board.isValidMove(3, 0)).isFalse();
        assertThat(board.isValidMove(0, 3)).isFalse();
        assertThat(board.isValidMove(-1, 0)).isFalse();
        assertThat(board.isValidMove(-1, 0)).isFalse();
    }

    @Test
    void givenBoardWithHorizontalWinningLineWhenHasWinnerCalledWithSymbolThenReturnTrue() {
        board.markCell(0, 0, 'X');
        board.markCell(0, 1, 'X');
        board.markCell(0, 2, 'X');

        assertThat(board.hasWinner('X')).isTrue();
    }

    @Test
    void givenBoardWithVerticalWinningLineWhenHasWinnerCalledWithSymbolThenReturnTrue() {
        board.markCell(0, 1, 'O');
        board.markCell(1, 1, 'O');
        board.markCell(2, 1, 'O');

        assertThat(board.hasWinner('O')).isTrue();
    }

    @Test
    void givenBoardWithDiagonalLeftToRightWinningLineWhenHasWinnerCalledThenReturnTrue() {
        board.markCell(0, 0, 'X');
        board.markCell(1, 1, 'X');
        board.markCell(2, 2, 'X');

        assertThat(board.hasWinner('X')).isTrue();
    }

    @Test
    void givenBoardWithDiagonalRightToLefWinningLineWhenHasWinnerCalledThenReturnTrue() {
        board.markCell(0, 2, 'X');
        board.markCell(1, 1, 'X');
        board.markCell(2, 0, 'X');

        assertThat(board.hasWinner('X')).isTrue();
    }

    @Test
    void givenBoardWithoutWinningLineWhenHasWinnerCalledThenReturnFalse() {
        board.markCell(0, 0, 'X');
        board.markCell(0, 1, 'O');
        board.markCell(0, 2, 'X');
        board.markCell(1, 1, 'O');
        board.markCell(1, 2, 'X');
        board.markCell(2, 0, 'O');
        board.markCell(2, 1, 'X');
        board.markCell(2, 2, 'O');

        assertThat(board.hasWinner('X')).isFalse();
        assertThat(board.hasWinner('O')).isFalse();
    }
}