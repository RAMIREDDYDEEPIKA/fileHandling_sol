import java.io.File;

public class DeletingFile
{
    public static void main(String[] args)
    {
        File file=new File("Welcome.txt");
        if(file.isFile()){
            file.delete();
            System.out.println(file.getName()+" is deleted");
        }
        else{
            System.out.println("file not found to delete");
        }
    }
}