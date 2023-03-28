import java.io.*;
import java.net.*; 
class SPECIAL_SERVER_02
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket SS = new ServerSocket(7896);
        Socket S = SS.accept();

        DataInputStream DIS = new DataInputStream(S.getInputStream());

        String str = (String)DIS.readUTF();
      //  System.out.println(str);  
      
      DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
      DOS.writeUTF(str);


        SS.close();
    }
}