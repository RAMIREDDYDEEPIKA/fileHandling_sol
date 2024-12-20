import java.io.*;
import java.util.*;

public class InsuranceDataPolicyMnmt {

    public static class Policy {
        private String policyId;
        private String policyHolderName;
        private double policyAmount;

        public Policy(String policyId, String policyHolderName, double policyAmount) {
            this.policyId = policyId;
            this.policyHolderName = policyHolderName;
            this.policyAmount = policyAmount;
        }

        public String getPolicyId(){
            return policyId;
        }

        public String getPolicyHolderName() {
            return policyHolderName;
        }

        public double getPolicyAmount() {
            return policyAmount;
        }
    }

    public interface FileHandler {
        public List<String> readFile(String filename) throws IOException;
        public void writeFile(String filename, String content) throws IOException;
    }

    public static class FileHandlerImpl implements FileHandler {
        @Override
        public List<String> readFile(String filename) throws IOException {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            return lines;
        }

        @Override
        public void writeFile(String filename, String content) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(content);
            }
        }
    }

    public static class PolicyManager {
        private FileHandler fileHandler;

        public PolicyManager(FileHandler fileHandler) {
            this.fileHandler = fileHandler;
        }

        public List<Policy> readPoliciesFromFile(String filename) throws IOException {
            List<Policy> policies = new ArrayList<>();
            List<String> lines = fileHandler.readFile(filename);

            for (String line : lines) {
                String[] data = line.split(",");
                String policyId = data[0];
                String policyHolderName = data[1];
                double policyAmount = Double.parseDouble(data[2]);
                policies.add(new Policy(policyId, policyHolderName, policyAmount));
            }

            return policies;
        }

        public void generateSummary(List<Policy> policies, String filename) throws IOException {
            int totalPolicies = policies.size();
            double totalAmount = policies.stream().mapToDouble(Policy::getPolicyAmount).sum();
            String summary = "Total Number of Policies: " + totalPolicies + "\n" +
                    "Total Policy Amount: " + totalAmount;

            fileHandler.writeFile(filename, summary);
        }
    }

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandlerImpl();
        PolicyManager policyManager = new PolicyManager(fileHandler);

        try {
            List<Policy> policies = policyManager.readPoliciesFromFile("policies.txt");
            policyManager.generateSummary(policies, "summary.txt");
            System.out.println("Summary generated successfully in 'summary.txt'.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}