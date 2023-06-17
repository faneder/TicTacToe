import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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
        board.makeMove(1, 1, 'O');

        assertThat(board.isValidMove(0, 0)).isTrue();
        assertThat(board.isValidMove(1, 1)).isFalse();
        assertThat(board.isValidMove(3, 0)).isFalse();
        assertThat(board.isValidMove(0, 3)).isFalse();
        assertThat(board.isValidMove(-1, 0)).isFalse();
        assertThat(board.isValidMove(-1, 0)).isFalse();
    }
}