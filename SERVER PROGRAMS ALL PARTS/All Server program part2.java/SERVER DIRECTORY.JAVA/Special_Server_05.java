/*this server sends 5 lines to client and client will store it in single 
dimensional array*/
//importing packages
import java.io.*;
import java.net.*;
public class Special_Server_05
{
    //decleration of variable 
    static int i=1;
    static String message[]=new String[10];
    static DataOutputStream DOS;
    public static void main(String args[])throws Exception
    {
        //creating ISR object
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        try (//creating ServerSocket and Socket object
        ServerSocket SS = new ServerSocket(0505)) 
        {
            Socket S = SS.accept();//establishing connection
            
            //creating DOS object
            DOS = new DataOutputStream(S.getOutputStream());
            System.out.println("enter 5 names");

            for(i=1;i<=5;i++)
            {
             
              message[i] = in.readLine();
              DOS.writeUTF(message[i]);
            }    
        }
        
    }        
}
