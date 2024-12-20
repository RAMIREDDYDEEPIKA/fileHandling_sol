import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReading
{
    public static void main(String[] args)
    {
        String file="Welcome.txt";
        try(BufferedReader bReader=new BufferedReader(new FileReader(file)))
        {
            String data;
            while((data= bReader.readLine())!=null){
                System.out.println(data);
            }
        }
        catch (IOException e) {
            System.out.println("Exception occurs : "+e.getMessage());
        }
    }
}