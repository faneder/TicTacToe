import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class IntegrationTest {

    @Test
    void whenPlayerXWins() {
        String input = "0 0\n0 1\n1 0\n2 2\n2 0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        TicTacToe.main(new String[0]);

        assertThat(out.toString()).contains("Player X wins!");
    }

    @Test
    void whenGameEndsInDraw() {
        String input = "0 0\n 0 1\n 0 2\n1 0\n1 2\n1 1\n2 0\n2 2\n2 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        TicTacToe.main(new String[0]);

        assertThat(out.toString()).contains("It's a draw!");
    }
}
