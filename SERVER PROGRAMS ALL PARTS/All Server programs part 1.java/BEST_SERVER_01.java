import java.net.*;
import java.io.*;
public class BEST_SERVER_01
{
    public static void main(String[] args) throws Exception
    {
        //creating socket object 
        ServerSocket SS = new ServerSocket(9999);
        Socket S = SS.accept();

        DataInputStream DIS = new DataInputStream(S.getInputStream());
        String str = DIS.readUTF();

        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());


        switch (str)
        {
            case "HIND" :
            DOS.writeUTF("sara jaha sa acha HINDUSTAN hamara ");
            break;

            case "UAE" :
            DOS.writeUTF("we have world's tallest building 😎");
            break;

            case "PALESTINE " :
            DOS.writeUTF("we are the most breavest Muslim country who faught with terrorist ISREAL");
            break;

            case "SYRIA" :
            DOS.writeUTF("bashar ul asad killed US ");
            break;

            default :
            DOS.writeUTF(str+" is not a country");
        }

        SS.close();
    }    
}