//these client belong to SERVER_04
import java.io.*;
import java.net.*;
public class CLIENT_04
{
    public static void main(String[] args)throws Exception 
    {
        try (Socket S = new Socket("localhost",0404))
        {
            DataInputStream DIS = new DataInputStream(S.getInputStream());
            System.out.println(DIS.readUTF());
        }
    }
}