import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}