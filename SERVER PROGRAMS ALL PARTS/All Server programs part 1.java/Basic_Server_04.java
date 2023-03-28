import java.io.*;
import java.net.*;

public class Basic_Server_04
{

    public static void main(String args[])throws Exception
    {
        //creating server object 
        ServerSocket SS = new ServerSocket(4444);
        Socket S = SS.accept();

        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
        DOS.writeUTF("asalamualaikum");

        SS.close();
        }    
}
