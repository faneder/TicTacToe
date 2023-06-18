import java.util.Scanner;

public record ScannerInputProvider(Scanner scanner) implements InputProvider {

    @Override
    public int getInput() {
        return scanner.nextInt();
    }
}