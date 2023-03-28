//these client belongs to Special_Server_05
//importing packages
import java.io.*;
import java.net.*;

public class Array_with_Client 
{
    //decleration of variable
    static String[] name = new String[10];
    static DataInputStream DIS;
    static int i;
    public static void main(String[] args)throws Exception
    {
        try (//creating Socket object
        Socket S = new Socket("localhost",0505)) {
            DIS = new DataInputStream(S.getInputStream());
            for(i=1;i<=5;i++)
            {
                name[i] = DIS.readUTF();
            }

            for(i=1;i<=5;i++)
            System.out.println(" these name are accepted from server "+name[i]);
        }
        
    }    
}
