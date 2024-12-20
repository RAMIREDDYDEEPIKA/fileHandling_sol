import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadingFile {
    public static void main(String[] args) {
        try {
            FileReader reader=new FileReader("Me.txt");
            Scanner data=new Scanner(reader);
            while(data.hasNextLine()){
                System.out.println(data.nextLine());
            }
            data.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception occurs : "+e.getMessage());
        }
    }
}