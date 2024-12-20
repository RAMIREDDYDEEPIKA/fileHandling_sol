import java.io.*;

public class ReversefileContent {

    public static void main(String[] args) {

        String inputFilePath = "C:\\Users\\Deepika\\IdeaProjects\\FileHandlingOperations\\src\\Words.txt";
        String outputFilePath = "reversed.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            String reversedContent = content.reverse().toString();
            writer.write(reversedContent);

            System.out.println("Reversed content has been written to " + outputFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    }
}