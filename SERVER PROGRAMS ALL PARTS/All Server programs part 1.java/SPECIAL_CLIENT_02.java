import java.io.*;
import java.net.*;
class SPECIAL_CLIENT_02
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        Socket S = new Socket("localhost",7896);

        System.out.println("enter your name below:⬇");
        String name = in.readLine();

        DataOutputStream DOS = new DataOutputStream(S.getOutputStream());
        DOS.writeUTF(name);

        DataInputStream DIS = new DataInputStream(S.getInputStream());
        String name2 = (String)DIS.readUTF();

        System.out.println(name2);

        S.close();
        in.close();
    }
}