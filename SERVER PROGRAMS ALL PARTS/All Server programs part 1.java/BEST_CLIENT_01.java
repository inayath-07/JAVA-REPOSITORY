import java.io.*;
import java.net.*;
public class BEST_CLIENT_01 
{
    public static void main(String args[]) throws Exception
    {
        //creating ISR object 
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        //creating SERVERSOCKET object 
        Socket S = new Socket("localhost",9999);

        System.out.println("enter name of country ");
        String country = in.readLine();

        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
        DOS.writeUTF(country);

         DataInputStream DIS = new DataInputStream(S.getInputStream());
         String c = DIS.readUTF();

         System.out.println(c);

        S.close();
    }    
}
