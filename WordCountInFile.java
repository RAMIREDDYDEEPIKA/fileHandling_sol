import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Deepika\\IdeaProjects\\FileHandlingOperations\\src\\Words.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int wordCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
                System.out.println("Words in this line: "+words.length);
            }

            System.out.println("Total number of words in the file: " + wordCount);
        }
        catch(IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
        }
    }
}