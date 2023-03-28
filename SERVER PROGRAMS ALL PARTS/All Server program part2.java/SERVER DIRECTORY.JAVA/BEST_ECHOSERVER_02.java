//imprting packages 
import java.io.*;
import java.net.*;
public class BEST_ECHOSERVER_02
{
    //decleration of variable and creating objects
    static ServerSocket SS;
    static Socket S;
    static  DataOutputStream DOS;
    static DataInputStream DIS;
    public static void main(String[] args) throws Exception
    {
        SS = new ServerSocket(0202);
                  
        
        System.out.println("ServerSocket : "+SS);
        while(true)
        {
            try
            {
                S = SS.accept();
                System.out.println("a new client is connected ");

               DOS =new DataOutputStream(S.getOutputStream());
               DIS = new DataInputStream(S.getInputStream());

               Thread t = new multiple_client_handler(S,DOS,DIS);
               t.start();
            }catch(Exception e)
            {
                /*empty body */
            }
        }
    }    
}

//client handler
class multiple_client_handler extends Thread
{
    final DataInputStream DIS;
    final DataOutputStream DOS;
    final Socket S;

    //creating constructor 
    public multiple_client_handler(Socket S,DataOutputStream DOS,DataInputStream DIS)
    {
        //calling constructor 
        this.DIS=DIS;
        this.S=S;
        this.DOS=DOS;

    }   

    public void run()
    {
        String rec;
        while(true)
        {
            try
            {
                DOS.writeUTF("send message and if you want to exit type it ");
                rec = DIS.readUTF();
                if(rec.equals("exit"))
                {
                    System.out.println("closing connection");
                    this.S.close();
                    break;
                }
                DOS.writeUTF(rec);
            }catch(Exception e)
            {
                /*empty body */
            }
        }
    }
    
}