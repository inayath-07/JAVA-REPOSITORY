//program to receive message using ObjectInputStream 
import java.io.*;
import java.net.*;
public class RECEIVING_MESSAGE_USING_OIS_03 
{
    public static void main(String[] args)throws Exception
    {
        Socket S = new Socket("localhost",786);
        ObjectInputStream OIS = new ObjectInputStream(S.getInputStream());
        
        String rec_message =(String) OIS.readObject();

        System.out.println(rec_message);

        S.close();

    }    
}
