/*these server can send multiple messages to multiple client*/
//importing packages
import java.util.*;
import java.io.*;
import java.net.*;

public class Server_06
{
    //decleration of variable 
    static ObjectOutputStream OOS;   
    static ObjectInputStream OIS;
    //accessing the variable 
    static Socket AS = Connection_thread.S;
    static File sendFile = file_handler.file;

    public static void main(String[] args)throws Exception
    {
        //runnimg the Connection_thread 
        Connection_thread CT = new Connection_thread();
        Thread TCT = new Thread(CT);

        TCT.start();
       /* OIS = new ObjectInputStream(AS.getInputStream());
        System.out.println("hi! founder i am connected to "+OIS.readObject());*/

        //file thread
        file_handler FH = new file_handler();
        Thread TFH = new Thread(FH);

        TFH.start();

        //Sending and receving messages
        OOS = new ObjectOutputStream(AS.getOutputStream());
        OOS.writeObject(sendFile);
        

    }
}

//these thread is responsible for connection
class Connection_thread extends Thread
{
    //decleration  of variable
    static ServerSocket SS;
    static Socket S;
    public void run()
    {
        while(true)
        {
            //ServerSocket
            try
            {
             SS = new ServerSocket(0606);
             S = SS.accept();

            }catch(Exception E)
            {
                /*Empty body*/
            }
        }
    }
}

//these thread is responsible for file handling
class file_handler implements Runnable
{
    //declaration of variable
    public static File file;
    static String file_name;
    static String fileC[];
    static int i = 1;
    static int lines;
    public void run()
    {
        //creating SCR object
        try(Scanner in = new Scanner(System.in))
        {
         System.out.println("enter file name");
         file_name = in.nextLine();
         //creating a new file
         file = new File("G:\\",file_name);
         try
         {
          file.createNewFile();
          System.out.println("a new file is created at :" + file.getAbsolutePath() + "\n");

          System.out.println("enter number of lines in your program");
          lines = in.nextInt();

          try (//writing in a file
        FileWriter FWr = new FileWriter(file)) 
        {
            System.out.println("what you want to write in your file");

              while(i<=(lines-1))
              {
                fileC[i]= in.nextLine();
                System.out.print(i+".");

                FWr.write(fileC[i]+"\n");

                i++;

              }//end of while block
        }
         }catch(IOException IOE)
         {
            System.err.println("an error is caought while creating a file");
         }
        }//end of try block of try with 
    }
}