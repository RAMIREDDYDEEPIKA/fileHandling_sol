import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LogSummaryReport {

    public static void main(String[] args) {

        String inputFilePath = "logs.txt";
        String outputFilePath = "logSummary.txt";

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            Map<String, Integer> logLevelCounts = new HashMap<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", 3);
                if (fields.length != 3) {
                    System.out.println("Skipping invalid log entry: " + line);
                    continue;
                }

                String logLevel = fields[1].trim();
                logLevelCounts.put(logLevel, logLevelCounts.getOrDefault(logLevel, 0) + 1);
            }

            writer.write("Log Level Summary:\n");
            for (Map.Entry<String, Integer> entry : logLevelCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }

            System.out.println("Log summary has been written to " + outputFilePath);
        }
        catch (IOException e) {
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