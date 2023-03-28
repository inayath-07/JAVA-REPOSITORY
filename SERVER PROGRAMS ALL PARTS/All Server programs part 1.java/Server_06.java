//converting string to integer 
import java.net.*;
import java.io.*;
public class Server_06
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket SS = new ServerSocket(999);
        Socket S = SS.accept();

        DataInputStream DIS = new DataInputStream(S.getInputStream());
        String convert = DIS.readUTF();

        //converting string to int
        int i = Integer.parseInt(convert);

        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());

        switch (i)
        {
            case 1:
            System.out.println("MONDAY");
            break;

            case 2:
            System.out.println("TUESDAY");
            break;

            case 3:
            System.out.println("WEDNESDAY");
            break;

            case 4:
            System.out.println("THURSDAY");
            break;

            case 5:
            DOS.writeUTF("FRIDAY");
            break;

            case 6:
            DOS.writeUTF("SATURDAY");
            break;

            case 7:
            DOS.writeUTF("SUNDAY");
            break;

            default :
            DOS.writeUTF("PLEASE ENTER CORRECT NUMBER");


        }


        SS.close();
    }
}