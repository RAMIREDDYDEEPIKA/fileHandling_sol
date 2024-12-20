import java.io.File;
import java.io.IOException;

public class CreateFile
{
    public static void main(String[] args)
    {
        try{
            File file=new File("Me.txt");
            if(file.createNewFile()){
                System.out.println("file created:"+file.getName());
            }
            else{
                System.out.println("file already present");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}