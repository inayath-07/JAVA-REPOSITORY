//client program
//importing packaes
import java.io.*;
import java.net.*;

//thread to handle multiple client 
class MULTI_THREAD implements Runnable
{
    Socket S;
    String sen_name;
    DataOutputStream DOS;
    DataInputStream DIS;
    String name;
    public void run()
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
      
        {
            try
            {
            //creating Socket object
            S = new Socket("localhost",9999);
            }catch(Exception e)
            {
                System.out.println("exception caught");
            }

            System.out.println("i am connected to server");
        } 

        
        System.out.println("enter your name below ");
        
        try
        {
            sen_name = in.readLine();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

        //transfering messages 
        
        
        try
        {
          DOS = new DataOutputStream(S.getOutputStream());
          DOS.writeUTF(sen_name);

          DIS = new DataInputStream(S.getInputStream());
          name = DIS.readUTF();

          System.out.println(name+"hmm");

        }catch(IOException IOE)
        {
         /*empty body */
        }

        

               
    }    
}

public class Single_Server_multiple_client_07
{
    public static void main(String[] args) 
    {
        MULTI_THREAD MT = new MULTI_THREAD();
        Thread Gun = new Thread(MT);
        
        Gun.start();
    }    
}
