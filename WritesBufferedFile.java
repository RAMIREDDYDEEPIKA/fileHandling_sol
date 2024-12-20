import java.io.*;

public class WritesBufferedFile
{
    public static void main(String[] args) {

        String file="Welcome.txt";
        try(BufferedWriter bwriter=new BufferedWriter(new FileWriter(file)))
        {
            bwriter.write("Welcome to maa, here is beautiful place to see");
            bwriter.newLine();
            bwriter.write("ayyo,yaar it's okay. cool i'll see");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}