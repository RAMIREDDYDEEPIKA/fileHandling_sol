import java.io.*;

public class CopyFileContent
{
    public static void main(String[] args) {

        File sourceFile=new File("SourceFile.txt");
        File destinationFile=new File("DestinationFile.txt");

        try{
            FileWriter fileWriter=new FileWriter("SourceFile.txt");
            fileWriter.write("welcome to my world\ncome yaar! feel free here this is my world yaar, don't feel stressed,depressed");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(
                FileReader fileReader=new FileReader(sourceFile);
                FileWriter destinationFileWriter=new FileWriter(destinationFile))
                {
                    int character;
                    while((character=fileReader.read())!=-1)
                    {
                        destinationFileWriter.write(character);
                    }
                }

        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}