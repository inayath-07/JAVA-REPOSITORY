//imprting packages 
import java.io.*;
import java.net.*;
import java.util.*;

public class BEST_ECHOCLIENT_02
{
    //decleration of variable and creating objects
    static Scanner in = new Scanner(System.in);
    static InetAddress IP;
    static Socket S;
    static String message;

    public static void main(String[] args) throws Exception
    {
        //creating inet object
        IP = InetAddress.getLocalHost();
        Socket S = new Socket(IP,0202);

        System.out.println("Your IP : "+IP);
        System.out.println("Your socket : "+S);

        //creating DOS and DIS 
        DataInputStream DIS = new DataInputStream(S.getInputStream());
        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
        System.out.println("enter the message you want to send to multiple client");

        //messages transfer
        while(true)
        {
         System.out.println(DIS.readUTF()); 
         message = in.nextLine();
         DOS.writeUTF(message);

         if(message.equals("exit"))
         {
            S.close();
            break;
         }
        }

    }    
}

