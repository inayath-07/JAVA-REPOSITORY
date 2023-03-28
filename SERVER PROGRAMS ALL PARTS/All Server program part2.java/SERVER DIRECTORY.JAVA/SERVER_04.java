// these server can connect to multiple client and it is the most basic server
import java.io.*;
import java.util.*;
import java.net.*;
public class SERVER_04
{
    public static void main(String[] args)throws Exception
    {
        try (Scanner in = new Scanner(System.in)) 
        {
            try (ServerSocket SS = new ServerSocket(0404)) 
            {                
                System.out.println("enter any message that you want to send to your client");
                String message = in.nextLine();
                while(true)
                {
                 Socket S = SS.accept();
                 System.out.println("i am connected");
                 DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
                 DOS.writeUTF(message);
                }
            }
        }
    }
}