//These client belongs to SERVER_01
//impoting packages
import java.io.*;
import java.net.*;

//Creating thread
class CLIENT_THREAD implements Runnable
{
    //Creating ISR objects
    InputStreamReader read =  new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(read);

    //decleration of variable
    Socket S;
    String rec_message;
    public void run()
    {
        try
        {
         S = new Socket("localhost",4444);
         System.out.println("i am connected to server");
         
        
         DataInputStream DIS = new DataInputStream(S.getInputStream());
         rec_message = DIS.readUTF();
        }catch(IOException IOE)
        {
            System.out.println("exception caught");
        }


        System.out.println(rec_message);
    }
}



public class CLIENT_01
{
    public static void main(String[] args) 
    {
        CLIENT_THREAD CT = new CLIENT_THREAD();
        Thread CT_T = new Thread(CT);

        CT_T.start();
    }    
}
