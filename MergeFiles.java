import java.io.*;
import java.util.Arrays;
import java.util.List;

public class MergeFiles {
    public static void main(String[] args) {
        List<String> inputFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
        String outputFile = "merged_feedback.txt";

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(outputFile));

            for (String inputFile : inputFiles) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(inputFile));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while reading " + inputFile + ": " + e.getMessage());
                } finally {
                    if (reader != null) {
                        reader.close();
                    }
                }
            }

            System.out.println("All files have been merged into " + outputFile);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the writer: " + e.getMessage());
            }
        }
    }
}