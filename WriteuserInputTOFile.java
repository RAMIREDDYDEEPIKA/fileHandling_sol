import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteuserInputTOFile {

    public static void main(String[] args) {

        String filePath = "UserInput.txt";
        Scanner scanner = null;
        FileWriter writer = null;

        try {
            scanner = new Scanner(System.in);
            writer = new FileWriter(filePath);

            System.out.println("Enter text to write to the file (type 'exit' to finish):");

            while (true) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                writer.write(input + System.lineSeparator());
            }

            System.out.println("Input has been written to " + filePath);
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (scanner != null) {
                    scanner.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    }
}