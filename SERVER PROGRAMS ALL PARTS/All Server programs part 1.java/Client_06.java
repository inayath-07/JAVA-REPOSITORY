import java.net.*;
import java.io.*;

class Client_06
{
    public static void main(String args[]) throws Exception
    {

        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);


        Socket S = new Socket("localhost",999);

        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());

        System.out.print("enter your year of birth ");
        String year = in.readLine();

        DOS.writeUTF(year);

        DataInputStream DIS = new DataInputStream(S.getInputStream());
        String c = DIS.readUTF();

        System.out.println(c);

        
        S.close();
    }
}