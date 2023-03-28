import java.io.*;
import java.net.*;
import java.util.Scanner;
public class CUSTOMIZE_ECHOSERVER_03
{
    static ServerSocket SS;
    static Socket S;
    public static void main(String[] args) throws Exception
    {
        SS = new ServerSocket(0303);             
        System.out.println("Hi i am on");
        while(true)
        {
            S = SS.accept();//connection established
            System.out.println("i am connected to server");
            DataInputStream DIS = new DataInputStream(S.getInputStream());
            DataOutputStream DOS = new DataOutputStream(S.getOutputStream());

            Thread T = new CHC( S,DIS,DOS);
            T.start();
        }

    }
}
//client handeler client
class CHC extends Thread
{
    final Socket S_CHC;
    final DataInputStream DIS_CHC;
    final DataOutputStream DOS_CHC;

    //creating constructor
    CHC(Socket SC , DataInputStream DISC , DataOutputStream DOSC)
    {
        this.S_CHC = SC;
        this.DIS_CHC = DISC;
        this.DOS_CHC =  DOSC;
    }

    public void run()
    {
        Scanner in  = new Scanner(System.in);
              
        while (true) 
        {
            System.out.println("enter what message you want to send to your client");
            String message = in.nextLine();
            
            try
            {
             DOS_CHC.writeUTF(message); 
             in.close();
            }catch(Exception e)
            {

            }
        }
    }
}
