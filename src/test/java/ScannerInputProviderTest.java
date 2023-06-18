import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ScannerInputProviderTest {

    @Test
    void getInputReturnsUserInput() {
        var input = 1;
        var scanner = new Scanner(String.valueOf(input));
        ScannerInputProvider inputProvider = new ScannerInputProvider(scanner);

        int result = inputProvider.getInput();

        assertThat(result).isEqualTo(input);
    }
}
