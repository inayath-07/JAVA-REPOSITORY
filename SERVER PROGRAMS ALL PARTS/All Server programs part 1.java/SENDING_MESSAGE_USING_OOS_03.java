//a simple program to send message using ObjectOutputStream 
import java.io.*;
import java.net.*;
public class SENDING_MESSAGE_USING_OOS_03
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket SS = new ServerSocket(786);
        Socket S = SS.accept();

        System.out.println("connection established");
        
        ObjectOutputStream OOS = new ObjectOutputStream(S.getOutputStream());
        OOS.flush();


        String message = "ASALAMUALAIKUM";

        OOS.writeObject(message);



        SS.close();
    }    
}
