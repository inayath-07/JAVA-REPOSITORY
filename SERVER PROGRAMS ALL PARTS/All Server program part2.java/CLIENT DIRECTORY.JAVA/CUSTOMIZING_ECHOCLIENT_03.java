//these cllient belogs to CUSTOMIZE_ECHOSERVER_03
//program to manage multiple clients to  receive messages from server
import java.io.*;
import java.net.*;

public class CUSTOMIZING_ECHOCLIENT_03
{
    static Socket S;
    static InetAddress IP;
    static DataInputStream DIS;
    public static void main(String[] args)throws Exception
    {

        //getting ip of a client
        IP = InetAddress.getLocalHost();
        S = new Socket(IP,0303);
        System.out.println("i am connected to server mr");

        DIS = new DataInputStream(S.getInputStream());
      
        while(true)
        {                       
            System.out.println(DIS.readUTF());         
            if(DIS.readUTF().equals("exit"))
            {
                System.out.println("i am going");
                break;
            }
        }

    }
}