import java.io.*;

public class LargeDataFileProcessing {

    public static void main(String[] args) {

        String inputFilePath = "Transactions.txt";
        String outputFilePath = "FilteredTransactions.txt";
        double thresholdAmount = 1000.0;

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 4) {
                    System.out.println("Skipping invalid record: " + line);
                    continue;
                }

                String transactionID = fields[0].trim();
                String customerID = fields[1].trim();
                double transactionAmount;
                try {
                    transactionAmount = Double.parseDouble(fields[2].trim());
                }
                catch (NumberFormatException e) {
                    System.out.println("Skipping invalid transaction amount: " + line);
                    continue;
                }
                String date = fields[3].trim();

                if (transactionAmount > thresholdAmount) {
                    writer.write(transactionID + "," + customerID + "," + transactionAmount + "," + date);
                    writer.newLine();
                }
            }

            System.out.println("Filtered transactions have been written to " + outputFilePath);
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        finally {
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