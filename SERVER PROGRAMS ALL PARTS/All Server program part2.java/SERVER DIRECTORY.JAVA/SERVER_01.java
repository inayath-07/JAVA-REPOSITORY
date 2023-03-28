//These serves sends messsage to multiple client using DIS and DOS 
//importing packages
import java.util.*;
import java.io.*;
import java.net.*;

//creating thread 
class Server_Thread extends Thread
{
    //decleration of variable
    
    Scanner in;
    ServerSocket SS;
    Socket S;
    DataOutputStream DOS;
  
    public void run()
    {
        //creating SCR object
        Scanner in = new Scanner(System.in);
        System.out.println("enter what kind of message");
        System.out.println(" you want to send to your client");

        final String message = in.nextLine();

        try
        {
         //Creating SS object
         SS = new ServerSocket(4444);
         S = SS.accept();//connection establishes
         
         do 
         {
          DOS = new DataOutputStream(S.getOutputStream());
          DOS.writeUTF(message);
          DOS.flush();
         }while (true);
        }catch(IOException IOE)
        {
            /*empty body*/
        }

        in.close();
        
        
    }
}

class SERVER_01
{
    public static void main(String[] args) 
    {
        Server_Thread ST = new Server_Thread();
        
        while(true)
        {
            ST.start();
        }
    }
}