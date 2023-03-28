import java.io.*;
import java.net.*;

public class Basic_Client_04
{
    public static void main(String args[]) throws Exception
    {
        //creating client object
        Socket S = new Socket("localhost",4444);

        DataInputStream DIS = new DataInputStream(S.getInputStream());
        String i = DIS.readUTF();
        System.out.println(i);
        S.close();

    }    
}
