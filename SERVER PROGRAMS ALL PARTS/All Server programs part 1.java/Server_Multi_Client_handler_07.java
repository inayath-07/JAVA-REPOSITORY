/*@5
 these server can connect to multiple clients
 but it cannot server them at a time
 thus it work in a concarrant way 
 we will develop that kind of server as soon as 
 possible
 */
//Server program
//importing packages 
import java.io.*;
import java.net.*;

//creating a thread class to established connection and transfer messages
class CONNECTION_THREAD implements Runnable
{
    //decleratoin of variables @5 note that we are using utf path 
    ServerSocket SS;
    Socket S;
    DataOutputStream DOS;
    DataInputStream DIS;
    String name;


    @Override
    public void run()
    {
        //server socket object 
        try 
        {
        SS = new ServerSocket(9999,10);  
        S = SS.accept();
        }catch(IOException e)
        {
           /*System.out.println("exception caught");*/
        }

       // System.out.println("connection established ");

            try
        {
         DIS = new DataInputStream(S.getInputStream());
         name = DIS.readUTF();

         DOS = new DataOutputStream(S.getOutputStream());
         DOS.writeUTF(name+"is a good boy");
        }catch(IOException IOE)
        {
         /*empty body */
        }
                   
              
    }
}

public class Server_Multi_Client_handler_07 
{
    public static void main(String argd[])
    {
        CONNECTION_THREAD CT  = new CONNECTION_THREAD();
        Thread CT_ONE = new Thread(CT);
        //these loop is not causing these program to die 
        while(true)
        {
            CT_ONE.run();
        }

    }    
}
