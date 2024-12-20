import java.io.FileWriter;
import java.io.IOException;

public class WriteFile
{
    public static void main(String[] args)
    {
        try{
            FileWriter writer=new FileWriter("Me.txt");
            writer.write("hello guys,welcome to our world..........................");
            writer.close();
            System.out.println("writes in created file");
        }
        catch (IOException e) {
            System.out.println("Exception : "+e.getMessage());
        }
    }
}